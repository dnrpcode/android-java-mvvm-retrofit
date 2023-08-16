package com.example.movieapp.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.models.GenreModel;

import java.util.ArrayList;
import java.util.List;

public class GenreRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GenreModel> genreList;
    private final OnHomeListener onHomeListener;
    private Context context;
    private ArrayList<Integer> activeGenres = new ArrayList<>();

    public GenreRecycleView(OnHomeListener onHomeListener) {
        this.onHomeListener = onHomeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_category, parent, false);
        return new GenreViewHolder(view, onHomeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((GenreViewHolder) holder).name.setText(genreList.get(position).getName());
        boolean isActive = activeGenres.contains(genreList.get(position).getId());
        if (isActive) {
            ((GenreViewHolder) holder).category.setCardBackgroundColor(context.getResources().getColor(R.color.primary));
        } else {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.item, typedValue, true);
            ((GenreViewHolder) holder).category.setCardBackgroundColor(typedValue.data);
        }
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

    public void setActiveGenres(int selectedId) {
        if (activeGenres.contains(selectedId)) {
            activeGenres.remove(Integer.valueOf(selectedId));
        } else {
            activeGenres.add(selectedId);
        }
        notifyDataSetChanged();
    }
}
