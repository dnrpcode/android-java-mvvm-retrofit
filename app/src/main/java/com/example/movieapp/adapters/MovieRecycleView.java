package com.example.movieapp.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.utils.Credentials;

import java.util.List;

public class MovieRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieModel> movieList;
    private final OnMovieListener onMovieListener;

    public MovieRecycleView(OnMovieListener onMovieListener) {
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new MovieViewHolder(view, onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TextView[] dots;
        int dotSize = 5;

        ((MovieViewHolder) holder).title.setText(movieList.get(position).getTitle());
        ((MovieViewHolder) holder).releaseDate.setText(movieList.get(position).getRelease_date());
        ((MovieViewHolder) holder).lang.setText(movieList.get(position).getOriginal_language());
        ((MovieViewHolder) holder).rating.setText(String.valueOf(movieList.get(position).getVote_average()));

        Glide.with(holder.itemView.getContext()).load(Credentials.POSTER_URL + movieList.get(position).getPoster_path()).into(((MovieViewHolder) holder).poster);

        float rating = movieList.get(position).getVote_average();
        dots = new TextView[dotSize];
        ((MovieViewHolder) holder).dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(holder.itemView.getContext());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextColor(holder.itemView.getResources().getColor(R.color.dotsBg));
            dots[i].setTextSize(50);
            ((MovieViewHolder) holder).dots.addView(dots[i]);
        }

        // dots calculate
        for (float j = 1.0f; j <= 1.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.dots_half));
            }
        }

        for (float j = 2.0f; j <= 2.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            }
        }

        for (float j = 3.0f; j <= 3.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.dots_half));
            }
        }

        for (float j = 4.0f; j <= 4.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            }
        }

        for (float j = 5.0f; j <= 5.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[2].setTextColor(holder.itemView.getResources().getColor(R.color.dots_half));
            }
        }

        for (float j = 6.0f; j <= 6.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[2].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            }
        }

        for (float j = 7.0f; j <= 7.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[2].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[3].setTextColor(holder.itemView.getResources().getColor(R.color.dots_half));
            }
        }

        for (float j = 8.0f; j <= 8.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[2].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[3].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            }
        }

        for (float j = 9.0f; j <= 9.9f; j += 0.1f) {
            if (rating == j) {
                dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[2].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[3].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
                dots[4].setTextColor(holder.itemView.getResources().getColor(R.color.dots_half));
            }
        }

        if (rating == 10) {
            dots[0].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            dots[1].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            dots[2].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            dots[3].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
            dots[4].setTextColor(holder.itemView.getResources().getColor(R.color.primary));
        }

    }

    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        }
        return 0;
    }

    public void setMovie(List<MovieModel> list) {
        this.movieList = list;
        notifyDataSetChanged();
    }

    public MovieModel getSelectedMovie(int pos) {
        if (movieList != null) {
            if (movieList.size() > 0) {
                return movieList.get(pos);
            }
        }
        return null;
    }
}
