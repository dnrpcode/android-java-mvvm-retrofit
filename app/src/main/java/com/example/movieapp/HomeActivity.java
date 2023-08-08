package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieapp.adapters.GenreRecycleView;
import com.example.movieapp.models.GenreModel;
import com.example.movieapp.models.viewModels.GenreListViewModel;

public class HomeActivity extends AppCompatActivity {

    private GenreListViewModel genreListViewModel;
    private RecyclerView recyclerView;
    private GenreRecycleView recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.categories);

        genreListViewModel = new ViewModelProvider(this).get(GenreListViewModel.class);


        // data observer
        ObservasingAnyChangesGenres();

        // show popular movies
        genreListViewModel.getGenres();

        // configuring recyclerview
        configureRecycleView();
    }

    // init recycleView and adding data to it
    private void configureRecycleView() {
        recycleViewAdapter = new GenreRecycleView();
        recyclerView.setAdapter(recycleViewAdapter);
    }


    private void ObservasingAnyChangesGenres() {
        genreListViewModel.getGenre().observe(this, GenreModels -> {
            // observing any data changes
            if (GenreModels != null) {
                for (GenreModel model : GenreModels) {
                    // get data
                    recycleViewAdapter.setGenre(GenreModels);
                }
            }
        });
    }
}