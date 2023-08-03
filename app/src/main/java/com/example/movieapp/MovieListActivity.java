package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.movieapp.adapters.MovieRecycleView;
import com.example.movieapp.adapters.OnMovieListener;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.models.viewModels.PopularMovieListViewModel;
import com.example.movieapp.models.viewModels.SearchMovieListViewModel;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    private PopularMovieListViewModel popularMovieListViewModel;
    private SearchMovieListViewModel searchMovieListViewModel;
    private RecyclerView recyclerView;
    private MovieRecycleView recycleViewAdapter;

    private boolean isPopular = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.recycleView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        popularMovieListViewModel = new ViewModelProvider(this).get(PopularMovieListViewModel.class);
        searchMovieListViewModel = new ViewModelProvider(this).get(SearchMovieListViewModel.class);

        // search setup
        searchSetup();

        // data observer
        ObservasingAnyChangesPopularMovie();
        ObservasingAnyChangesSearchMovie();

        // show popular movies
        popularMovieListViewModel.getPopularMovie(1);

        // configuring recyclerview
        configureRecycleView();
    }

    private void searchSetup() {
        final SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchMovieListViewModel.getSearchMovie(query,1);
                isPopular = false;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnClickListener(view -> isPopular = false);
    }

    // init recycleView and adding data to it
    private void configureRecycleView() {
        recycleViewAdapter = new MovieRecycleView(this);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // pagination & loading nect results
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollVertically(1)) {
                    // here display next result
//                    searchMovieListViewModel.searchMovieNextPage();
//                    if (isPopular) {
                        popularMovieListViewModel.popularMovieNextPage();
//                    }
                }
            }
        });
    }

    private void ObservasingAnyChangesSearchMovie() {
        searchMovieListViewModel.getSearchMovie().observe(this, movieModels -> {
            // observing any data changes
            if (movieModels != null) {
                for (MovieModel model : movieModels) {
                    // get data
                    recycleViewAdapter.setMovie(movieModels);
                }
            }
        });
    }

    private void ObservasingAnyChangesPopularMovie() {
        popularMovieListViewModel.getPopularMovie().observe(this, movieModels -> {
            // observing any data changes
            if (movieModels != null) {
                for (MovieModel model : movieModels) {
                    // get data
                    recycleViewAdapter.setMovie(movieModels);
                }
            }
        });
    }

    @Override
    public void onMovieClick(int pos) {
        // here is going to detail movie that has clicked
        Intent intent = new Intent(this,DetailMovieActivity.class);
        intent.putExtra("movie",recycleViewAdapter.getSelectedMovie(pos));
        startActivity(intent);
    }
}