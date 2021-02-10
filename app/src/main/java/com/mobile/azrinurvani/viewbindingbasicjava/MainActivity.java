package com.mobile.azrinurvani.viewbindingbasicjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;

import com.mobile.azrinurvani.viewbindingbasicjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        setupRecyclerView();
        initMovieList();
    }

    private void setupRecyclerView(){
        recyclerViewAdapter = new RecyclerViewAdapter();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(activityMainBinding.rvMain.getContext(), DividerItemDecoration.VERTICAL);
        activityMainBinding.rvMain.setAdapter(recyclerViewAdapter);
        activityMainBinding.rvMain.addItemDecoration(dividerItemDecoration);
    }

    private void initMovieList(){
        List<String> movieList = new ArrayList<String>();

        movieList.add("Avengers");
        movieList.add("Captain America");
        movieList.add("Iron Man");
        movieList.add("Hulk");
        movieList.add("Doctor Strange");
        movieList.add("Spiderman");
        movieList.add("Ant Man");
        movieList.add("Black Widow");
        recyclerViewAdapter.updateMovie(movieList);

    }
}