package com.example.movieapp.models.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.models.GenreModel;
import com.example.movieapp.repositories.GenreRepository;

import java.util.List;

public class GenreListViewModel extends ViewModel {
    private GenreRepository genreRepository;
    public GenreListViewModel(){
        genreRepository = GenreRepository.getInstance();
    }

    public LiveData<List<GenreModel>> getGenre(){
        return genreRepository.getGenre();
    }

    public void getGenreFromApi(){
        genreRepository.getGenreFromApi();
    }

}
