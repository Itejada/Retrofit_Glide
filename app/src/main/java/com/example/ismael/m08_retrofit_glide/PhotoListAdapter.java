package com.example.ismael.m08_retrofit_glide;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.MovieListViewHolder>{

    public List<Photo> photoList = new ArrayList<>();
    public static final String PHOTO_ID ="PHOTO_ID";
    public static final String PHOTO_OBJECT ="PHOTO_OBJECT";



    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        final Photo photo = photoList.get(position);
        holder.title.setText(photo.author);
        GlideApp.with(holder.itemView.getContext()).load("https://picsum.photos/300/300/?image=" + position).into(holder.photo);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),PhotoInfo.class);
                intent.putExtra(PHOTO_ID,photo.id);
                intent.putExtra(PHOTO_OBJECT,  photo);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    class MovieListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView photo;
        public MovieListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.photoTitle);
            photo = itemView.findViewById(R.id.Image);
        }
    }
    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}