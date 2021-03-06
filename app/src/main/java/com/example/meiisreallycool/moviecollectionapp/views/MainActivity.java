package com.example.meiisreallycool.moviecollectionapp.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.meiisreallycool.moviecollectionapp.MovieAdapter;
import com.example.meiisreallycool.moviecollectionapp.database.MovieDatabase;
import com.example.meiisreallycool.moviecollectionapp.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Database
        MovieDatabase db = MovieDatabase.getMovieDatabase(this);
        recyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MovieAdapter(db.movieDAO().getAll(),this);
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addMovie = new Intent(MainActivity.this, Details.class);
                startActivity(addMovie);
            }
        });
    }
}
