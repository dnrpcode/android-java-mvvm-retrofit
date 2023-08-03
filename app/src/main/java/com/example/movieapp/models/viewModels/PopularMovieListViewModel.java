package com.example.movieapp.models.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.models.MovieModel;
import com.example.movieapp.repositories.PopularMovieRepository;

import java.util.List;

public class PopularMovieListViewModel extends ViewModel {
    private PopularMovieRepository popularMovieRepository;
    public PopularMovieListViewModel(){
        popularMovieRepository = PopularMovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getPopularMovie(){
        return popularMovieRepository.getPopularMovie();
    }

    public void getPopularMovie(int page){
        popularMovieRepository.getPopularMovie(page);
    }

    public void popularMovieNextPage(){
        popularMovieRepository.popularMovieNextPage();
    }
}
