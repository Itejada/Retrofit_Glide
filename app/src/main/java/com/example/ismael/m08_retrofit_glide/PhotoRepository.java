package com.example.ismael.m08_retrofit_glide;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {
    PhotoAPI photoAPI;


    public PhotoRepository(){
        photoAPI = PhotoModule.getAPI();
    }

    public LiveData<List<Photo>> getPhotos(){
        final MutableLiveData<List<Photo>> lista = new MutableLiveData<>();
        Log.e("sss", "repository onResponse"+lista);

        photoAPI.getPhotosApi().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                lista.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
            }
        });

        return lista;
    }

    public  LiveData<Photo> getPhotoRepository(int id) {
             String string_id="?image="+id;
        final MutableLiveData<Photo> photo = new MutableLiveData<>();
        photoAPI.getPhotoById(string_id).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                photo.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
            }
        });

        return photo;

    }

  
}