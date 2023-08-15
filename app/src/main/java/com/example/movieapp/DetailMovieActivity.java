package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.utils.Credentials;

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
            TextView[] dots;
            int dotSize = 5;

            title.setText(model.getTitle());
            releaseDate.setText(model.getRelease_date());
            overview.setText(model.getOverview());
            rating.setText(getRating);

            // poster
            Glide.with(this).load(Credentials.POSTER_URL + model.getPoster_path()).into(poster);

            // set dots rating
            dots = new TextView[dotSize];
            float ratings = model.getVote_average();
            dotsLayout.removeAllViews();

            for (int j = 0; j < dots.length; j++) {
                dots[j] = new TextView(this);
                dots[j].setText(Html.fromHtml("&#8226;"));
                dots[j].setTextColor(this.getResources().getColor(R.color.dotsBg));
                dots[j].setTextSize(50);
                dotsLayout.addView(dots[j]);
            }

            for (float j = 1.0f; j <= 1.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.dots_half));
                }
            }

            for (float j = 2.0f; j <= 2.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                }
            }

            for (float j = 3.0f; j <= 3.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.dots_half));
                }
            }

            for (float j = 4.0f; j <= 4.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                }
            }

            for (float j = 5.0f; j <= 5.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[2].setTextColor(this.getResources().getColor(R.color.dots_half));
                }
            }

            for (float j = 6.0f; j <= 6.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[2].setTextColor(this.getResources().getColor(R.color.primary));
                }
            }

            for (float j = 7.0f; j <= 7.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[2].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[3].setTextColor(this.getResources().getColor(R.color.dots_half));
                }
            }

            for (float j = 8.0f; j <= 8.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[2].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[3].setTextColor(this.getResources().getColor(R.color.primary));
                }
            }

            for (float j = 9.0f; j <= 9.9f; j += 0.1f) {
                if (ratings == j) {
                    dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[2].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[3].setTextColor(this.getResources().getColor(R.color.primary));
                    dots[4].setTextColor(this.getResources().getColor(R.color.dots_half));
                }
            }

            if (ratings == 10) {
                dots[0].setTextColor(this.getResources().getColor(R.color.primary));
                dots[1].setTextColor(this.getResources().getColor(R.color.primary));
                dots[2].setTextColor(this.getResources().getColor(R.color.primary));
                dots[3].setTextColor(this.getResources().getColor(R.color.primary));
                dots[4].setTextColor(this.getResources().getColor(R.color.primary));
            }
        }
    }
}