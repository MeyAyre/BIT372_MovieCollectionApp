package com.example.meiisreallycool.moviecollectionapp.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

public interface DirectorDAO {
    @Query("SELECT * FROM director")
    List<Movie> getAll();

    @Query("SELECT * FROM director WHERE _id IN (:directorIds)")
    List<Movie> loadAllByIds(int[] directorIds);

    @Query("SELECT * FROM director ORDER BY  last_name ")
    List<Movie> listAlphabetically();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Director... directors);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Director... directors);

    @Delete
    void delete(Director director);
}
