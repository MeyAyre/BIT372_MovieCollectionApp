package com.example.meiisreallycool.moviecollectionapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MovieDAO {
    @Query("SELECT * FROM movie")
    List<Movie> getAll();

    @Query("SELECT * FROM movie WHERE _id IN (:movieIds)")
    List<Movie> loadAllByIds(int[] movieIds);

 //   @Query("SELECT * FROM movie WHERE ")
 //   List<Movie> listAlphabetically();


    @Insert
    void insertAll(Movie... movies);

    @Delete
    void delete(Movie movie);
}
