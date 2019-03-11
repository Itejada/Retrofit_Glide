package com.example.ismael.m08_retrofit_glide;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhotoGreaseAdapter extends RecyclerView.Adapter<PhotoGreaseAdapter.MovieListViewHolder>{
    public List<Photo> photoArrayListGrease = new ArrayList<>();
    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_grease_list, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        Photo photoGrease = photoArrayListGrease.get(position);

        holder.title.setText(photoGrease.author);
        Log.e("grease", "https://picsum.photos/g/600/700/" + photoGrease.filename);
        GlideApp.with(holder.itemView.getContext()).load("https://picsum.photos/g/300/300/?image=" + position).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return photoArrayListGrease.size();
    }

    class MovieListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView photo;
        public MovieListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.photoTitleGrease);
            photo = itemView.findViewById(R.id.ImageGrease);
        }
    }
}