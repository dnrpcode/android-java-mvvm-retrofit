package com.example.movieapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;

public class GenreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView category;
    TextView name;
    OnHomeListener onHomeListener;

    public GenreViewHolder(@NonNull View itemView, OnHomeListener onHomeListener) {
        super(itemView);
        this.onHomeListener = onHomeListener;
        itemView.setOnClickListener(this);

        category = itemView.findViewById(R.id.category);
        name = itemView.findViewById(R.id.nameCategory);
    }

    @Override
    public void onClick(View view) {
        onHomeListener.onGenreClick(getBindingAdapterPosition());
    }
}
