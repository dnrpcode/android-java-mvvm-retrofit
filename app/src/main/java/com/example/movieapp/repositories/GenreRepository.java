package com.example.movieapp.repositories;

import androidx.lifecycle.LiveData;

import com.example.movieapp.models.GenreModel;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.request.GenreApiClient;
import com.example.movieapp.request.PopularMovieApiClient;

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

    public void getGenres() {
        genreApiClient.getGenres();
    }

}
