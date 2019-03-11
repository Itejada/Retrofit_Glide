package com.example.ismael.m08_retrofit_glide;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static PhotoRepository photoRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        photoRepository = new PhotoRepository();
    }

    public static LiveData<List<Photo>> getPhotos(){
        return photoRepository.getPhotos();
    }


    public static LiveData<Photo> getPhoto(int id) {
        return photoRepository.getPhotoRepository(id);

    }
}