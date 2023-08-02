package com.example.movieapp.response;

import com.example.movieapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovieResponses {
    @SerializedName("results")
    @Expose
    private List<MovieModel> movies;

    public List<MovieModel> getMovies() {
        System.out.println("movies"+ movies);
        return movies;

    }

    @Override
    public String toString() {
        return "MovieResponses{" +
                "movies=" + movies +
                '}';
    }
}
