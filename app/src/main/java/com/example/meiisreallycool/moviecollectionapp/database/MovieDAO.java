package com.example.meiisreallycool.moviecollectionapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.meiisreallycool.moviecollectionapp.database.Movie;

import java.util.List;

@Dao
public interface MovieDAO {
    @Query("SELECT * FROM movie")
    List<Movie> getAll();

    @Query("SELECT * FROM movie WHERE _id IN (:movieIds)")
    List<Movie> loadAllByIds(int[] movieIds);

    @Query("SELECT * FROM movie ORDER BY  m_title ")
    List<Movie> listAlphabetically();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Movie... movies);

    @Delete
    void delete(Movie movie);
}
