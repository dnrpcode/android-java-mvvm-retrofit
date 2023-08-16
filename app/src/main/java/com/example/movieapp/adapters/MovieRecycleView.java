package com.example.movieapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.models.MovieModel;
import com.example.movieapp.utils.Credentials;
import com.example.movieapp.utils.UIUtils;

import java.util.List;

public class MovieRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieModel> movieList;
    private final OnHomeListener onHomeListener;

    public MovieRecycleView(OnHomeListener onHomeListener) {
        this.onHomeListener = onHomeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new MovieViewHolder(view, onHomeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((MovieViewHolder) holder).title.setText(movieList.get(position).getTitle());
        ((MovieViewHolder) holder).releaseDate.setText(movieList.get(position).getRelease_date());
        ((MovieViewHolder) holder).lang.setText(movieList.get(position).getOriginal_language());
        ((MovieViewHolder) holder).rating.setText(String.valueOf(movieList.get(position).getVote_average()));

        Glide.with(holder.itemView.getContext()).load(Credentials.POSTER_URL + movieList.get(position).getPoster_path()).into(((MovieViewHolder) holder).poster);

        UIUtils.setRatingDots(movieList.get(position).getVote_average(), ((MovieViewHolder) holder).dots, holder.itemView.getContext());
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
