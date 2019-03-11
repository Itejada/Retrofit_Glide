package com.example.ismael.m08_retrofit_glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PhotoAPI {
    @GET("list")
    Call<List<Photo>> getPhotosApi();



    @GET("https://picsum.photos/300/300/{id}")
    Call<Photo> getPhotoById(@Path("id") String id);

}