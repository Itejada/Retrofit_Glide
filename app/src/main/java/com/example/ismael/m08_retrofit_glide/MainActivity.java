package com.example.ismael.m08_retrofit_glide;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private PhotoListAdapter mPhotoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.photoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPhotoListAdapter = new PhotoListAdapter();
        mRecyclerView.setAdapter(mPhotoListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        Log.e("abc", "tal");
        mViewModel.getPhotos().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(@Nullable List<Photo> photos) {
                Log.e("abc", "sie " + photos.size());
                mPhotoListAdapter.photoList = photos;
                mPhotoListAdapter.notifyDataSetChanged();
            }
        });
    }
}
