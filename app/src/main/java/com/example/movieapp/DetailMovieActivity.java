package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.adapters.MovieViewHolder;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.utils.Credentials;
import com.example.movieapp.utils.UIUtils;

public class DetailMovieActivity extends AppCompatActivity {

    private ImageView poster;
    private TextView title,releaseDate,rating,overview;
    LinearLayout dotsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        title = findViewById(R.id.titleDetail);
        overview = findViewById(R.id.overview);
        releaseDate = findViewById(R.id.releaseDate);
        rating = findViewById(R.id.ratingTextDetail);
        poster = findViewById(R.id.posterDetail);
        dotsLayout = findViewById(R.id.dotsDetail);

        getMovieDetail();
    }

    private void getMovieDetail() {
        if (getIntent().hasExtra("movie")) {
            MovieModel model = getIntent().getParcelableExtra("movie");

            // string text
            String getRating = String.valueOf(model.getVote_average());
            title.setText(model.getTitle());
            releaseDate.setText(model.getRelease_date());
            overview.setText(model.getOverview());
            rating.setText(getRating);

            Glide.with(this).load(Credentials.POSTER_URL + model.getPoster_path()).into(poster);

            UIUtils.setRatingDots(model.getVote_average(), dotsLayout, this);

        }
    }
}