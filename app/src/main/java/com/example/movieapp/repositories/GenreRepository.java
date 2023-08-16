package com.example.movieapp.repositories;

import androidx.lifecycle.LiveData;

import com.example.movieapp.models.GenreModel;
import com.example.movieapp.request.GenreApiClient;

import java.util.List;

public class GenreRepository {

    private static GenreRepository instance;
    private GenreApiClient genreApiClient;

    public static GenreRepository getInstance() {
        if (instance == null) {
            instance = new GenreRepository();
        }
        return instance;
    }

    private GenreRepository() {
        genreApiClient = GenreApiClient.getInstance();
    }

    public LiveData<List<GenreModel>> getGenre() {
        return genreApiClient.getGenre();
    }

    public void getGenreFromApi() {
        genreApiClient.getGenreFromApi();
    }

}
