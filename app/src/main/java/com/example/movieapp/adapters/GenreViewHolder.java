package com.example.movieapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;

public class GenreViewHolder extends RecyclerView.ViewHolder {

    TextView name;

    public GenreViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameCategory);
    }
}
