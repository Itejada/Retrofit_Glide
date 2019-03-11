package com.example.ismael.m08_retrofit_glide.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ismael.m08_retrofit_glide.GlideApp;
import com.example.ismael.m08_retrofit_glide.MainViewModel;
import com.example.ismael.m08_retrofit_glide.PhotoListAdapter;
import com.example.ismael.m08_retrofit_glide.R;

public class RandomPhotoFragment extends Fragment {

    private ImageView imageView;
    private Button botonRandom;
    int random;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_random_photo, container, false);
         imageView= v.findViewById(R.id.photo_random1);
        GlideApp.with(getContext()).load("https://picsum.photos/g/300/300/?random").into(imageView);

        botonRandom=v.findViewById(R.id.random_button);
        botonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
                  //random=(int) Math.ceil(Math.random() * 1084);
                GlideApp.with(getContext()).load("https://picsum.photos/g/300/300/?random").into(imageView);
            }
        });

        return v;
    }
}
