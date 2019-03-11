package com.example.ismael.m08_retrofit_glide;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class PhotoInfo extends AppCompatActivity {
    private MainViewModel mainViewModel;
    Gson gson=new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_info);
        Intent intent = getIntent();
        int id = intent.getIntExtra(PhotoListAdapter.PHOTO_ID, 0);
        Photo photo=(Photo) intent.getSerializableExtra(PhotoListAdapter.PHOTO_OBJECT);


        final ImageView ImageView_photo= findViewById(R.id.ImageView_photo);
        final TextView photo_url = findViewById(R.id.photo_url);
        final TextView photo_author = findViewById(R.id.photo_author);
        GlideApp.with(PhotoInfo.this).load("https://picsum.photos/300/300/?image=" +id).into(ImageView_photo);
        photo_author.setText(photo.getAuthor());

    }


}
