package com.example.movieapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.models.GenreModel;

import java.util.List;

public class GenreRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<GenreModel> genreList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_category, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((GenreViewHolder) holder).name.setText(genreList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (genreList != null) {
            return genreList.size();
        }
        return 0;
    }

    public void setGenre(List<GenreModel> list) {
        this.genreList = list;
        System.out.println("genreList" + list);
        notifyDataSetChanged();
    }

    public GenreModel getSelectedGenre(int pos) {
        if (genreList != null) {
            if (genreList.size() > 0) {
                return genreList.get(pos);
            }
        }
        return null;
    }
}
