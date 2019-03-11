package com.example.ismael.m08_retrofit_glide.Fragments;

import android.arch.lifecycle.LiveData;
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
import com.example.ismael.m08_retrofit_glide.PhotoListAdapter;
import com.example.ismael.m08_retrofit_glide.R;

import java.util.List;

public class ListPhotoFragment extends Fragment {

     MainViewModel mViewModel;
    final PhotoListAdapter mPhotoListAdapter=new PhotoListAdapter();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView mRecyclerView;

        View view = inflater.inflate(R.layout.fragment_list_photo, container, false);

        mRecyclerView = view.findViewById(R.id.photoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mPhotoListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPhotos().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(@Nullable List<Photo> photos) {
                mPhotoListAdapter.setPhotoList(photos);
                mPhotoListAdapter.notifyDataSetChanged();
            }

        });

        return view;
    }

        public LiveData<List<Photo>> getPhotos() {
        return MainViewModel.getPhotos();
    }

    public LiveData<Photo> getPhoto(int id) {
        return MainViewModel.getPhoto(id);
    }

}
