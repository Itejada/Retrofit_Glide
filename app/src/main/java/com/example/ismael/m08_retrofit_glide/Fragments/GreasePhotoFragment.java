package com.example.ismael.m08_retrofit_glide.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ismael.m08_retrofit_glide.MainViewModel;
import com.example.ismael.m08_retrofit_glide.Photo;
import com.example.ismael.m08_retrofit_glide.PhotoGreaseAdapter;
import com.example.ismael.m08_retrofit_glide.R;

import java.util.List;

public class GreasePhotoFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private PhotoGreaseAdapter mPhotoGreaseAdapter =new PhotoGreaseAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_grease, container, false);

        mRecyclerView = view.findViewById(R.id.greaseList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mPhotoGreaseAdapter = new PhotoGreaseAdapter();
        mRecyclerView.setAdapter(mPhotoGreaseAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        Log.e("abc", "tal");
        mViewModel.getPhotos().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(@Nullable List<Photo> photos) {
                Log.e("abc", "sie " + photos.size());
                mPhotoGreaseAdapter.photoArrayListGrease = photos;
                mPhotoGreaseAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
