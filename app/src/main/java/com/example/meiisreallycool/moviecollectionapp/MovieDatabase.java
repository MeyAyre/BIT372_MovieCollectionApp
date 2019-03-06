package com.example.meiisreallycool.moviecollectionapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.meiisreallycool.moviecollectionapp.database.Director;
import com.example.meiisreallycool.moviecollectionapp.database.Movie;
import com.example.meiisreallycool.moviecollectionapp.database.MovieDAO;

@Database(entities = {Movie.class, Director.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDAO movieDAO();
}
