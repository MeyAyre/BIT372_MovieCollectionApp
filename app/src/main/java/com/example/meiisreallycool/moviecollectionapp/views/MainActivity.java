package com.example.meiisreallycool.moviecollectionapp.views;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.meiisreallycool.moviecollectionapp.MovieAdapter;
import com.example.meiisreallycool.moviecollectionapp.MovieDatabase;
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
        MovieDatabase db = Room.databaseBuilder(getApplicationContext(), MovieDatabase.class, "main_database").build();
        recyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MovieAdapter(db.movieDAO().getAll(),this);
        recyclerView.setAdapter(mAdapter);
    }
}
