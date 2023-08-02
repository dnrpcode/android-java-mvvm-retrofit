package com.example.movieapp.utils;

import com.example.movieapp.response.PopularMovieResponses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    // popular movie
    @GET("movie/popular")
    Call<PopularMovieResponses> getPopularMovie(@Query("api_key") String key,
                                                @Query("page") int page);

    // search movie
//    @GET("search/movie/")
//    Call<SearchMovieResponses> searchMovie(@Query("api_key") String key,
//                                           @Query("query") String query,
//                                           @Query("page") int page);
}