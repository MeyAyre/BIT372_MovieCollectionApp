package com.example.meiisreallycool.moviecollectionapp.views;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.meiisreallycool.moviecollectionapp.MovieAdapter;
import com.example.meiisreallycool.moviecollectionapp.MovieDatabase;
import com.example.meiisreallycool.moviecollectionapp.R;
import com.example.meiisreallycool.moviecollectionapp.database.Movie;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Database
        MovieDatabase db = Room.databaseBuilder(getApplicationContext(), MovieDatabase.class, "main_database").build();
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
