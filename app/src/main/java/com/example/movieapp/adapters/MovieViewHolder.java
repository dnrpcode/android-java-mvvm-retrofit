package com.example.movieapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title, releaseDate, rating, lang;
    ImageView poster;
    LinearLayout dots;
    OnHomeListener onHomeListener;

    public MovieViewHolder(@NonNull View itemView, OnHomeListener onHomeListener) {
        super(itemView);
        this.onHomeListener = onHomeListener;

        title = itemView.findViewById(R.id.title);
        releaseDate = itemView.findViewById(R.id.releaseDate);
        rating = itemView.findViewById(R.id.ratingText);
        lang = itemView.findViewById(R.id.lang);
        poster = itemView.findViewById(R.id.poster);
        dots = itemView.findViewById(R.id.dots);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onHomeListener.onMovieClick(getBindingAdapterPosition());
    }
}
