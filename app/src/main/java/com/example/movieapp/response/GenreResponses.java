package com.example.movieapp.response;

import com.example.movieapp.models.GenreModel;
import com.example.movieapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreResponses {
    @SerializedName("genres")
    @Expose
    private List<GenreModel> genres;

    public List<GenreModel> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "GenreResponses{" +
                "genres=" + genres +
                '}';
    }
}
