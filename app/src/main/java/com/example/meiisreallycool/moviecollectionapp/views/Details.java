package com.example.meiisreallycool.moviecollectionapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.meiisreallycool.moviecollectionapp.database.MovieDatabase;
import com.example.meiisreallycool.moviecollectionapp.R;
import com.example.meiisreallycool.moviecollectionapp.database.Movie;

public class Details extends AppCompatActivity {

    private MovieDatabase imdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        imdb = MovieDatabase.getMovieDatabase(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText newTitle = findViewById(R.id.movie_title_edit);
                EditText newDirectorFirst = findViewById(R.id.movie_director_firstname_edit);
                EditText newDirectorLast = findViewById(R.id.movie_director_lastname_edit);
                EditText newYear = findViewById(R.id.movie_year_edit);
                EditText newRuntime = findViewById(R.id.movie_runtime_edit);


                Movie addNewMovie = new Movie(
                    newTitle.getText().toString(),
                    newDirectorFirst.getText().toString(),
                    newDirectorLast.getText().toString(),
                    newYear.getText().toString(),
                    newRuntime.getText().toString()
                );

                imdb.movieDAO().insertMovie(addNewMovie);
                Snackbar.make(view, "Movie Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent backToMain = new Intent(Details.this, MainActivity.class);
                startActivity(backToMain);
            }
        });
    }

}
