package com.example.ismael.m08_retrofit_glide;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ismael.m08_retrofit_glide.Fragments.GreasePhotoFragment;
import com.example.ismael.m08_retrofit_glide.Fragments.ListPhotoFragment;
import com.example.ismael.m08_retrofit_glide.Fragments.RandomPhotoFragment;

public class Main2Activity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    
    private ViewPager mViewPager;
    private MainViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new ListPhotoFragment();
                case 1:
                    return new GreasePhotoFragment();
                case 2:
                    return new RandomPhotoFragment();
                default:
                    return new ListPhotoFragment();
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }


    }
