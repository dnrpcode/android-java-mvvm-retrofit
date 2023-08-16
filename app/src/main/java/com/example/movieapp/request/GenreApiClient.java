package com.example.movieapp.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.models.GenreModel;
import com.example.movieapp.response.GenreResponses;
import com.example.movieapp.utils.AppExecutor;
import com.example.movieapp.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class GenreApiClient {
    private static GenreApiClient instance;

    public static GenreApiClient getInstance() {
        if (instance == null) {
            instance = new GenreApiClient();
        }
        return instance;
    }

    //live data
    private final MutableLiveData<List<GenreModel>> genreLiveData;

    //global variable for runnable
    private GenreApiClient.GenreRunnable genreRunnable;

    private GenreApiClient() {
        genreLiveData = new MutableLiveData<>();
    }


    public LiveData<List<GenreModel>> getGenre() {
        return genreLiveData;
    }

    public void getGenreFromApi() {
        if (genreRunnable != null) {
            genreRunnable = null;
        }

        genreRunnable = new GenreApiClient.GenreRunnable();

        final Future handler = AppExecutor.getInstance().getNetworkIO().submit(genreRunnable);
        AppExecutor.getInstance().getNetworkIO().schedule(() -> {
            //cancelling retrofit call
            handler.cancel(true);
        }, 3000, TimeUnit.MILLISECONDS);
    }

    //retrieve data from rest api use retrofit
    public class GenreRunnable implements Runnable {

        boolean cancelRequest;

        public GenreRunnable() {
            cancelRequest = false;
        }

        @Override
        public void run() {
            //getting request
            try {
                Response response = getGenreApi().execute();
                if (cancelRequest) {
                    return;
                }

                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        assert response.body() != null;
                        List<GenreModel> genreList = new ArrayList<>(((GenreResponses) response.body()).getGenres());
                        genreLiveData.postValue(genreList);
                    } else {
                        assert response.errorBody() != null;
                        System.out.println(response.errorBody().string());
                        genreLiveData.postValue(null);
                    }
                } else {
                    System.out.println("Request isn't successful");
                }

            } catch (IOException e) {
                System.out.println(e);
                genreLiveData.postValue(null);
            }
        }

        private Call<GenreResponses> getGenreApi() {
            return ApiService.getMovieApi().getGenres(Credentials.API_KEY);
        }
    }
}
