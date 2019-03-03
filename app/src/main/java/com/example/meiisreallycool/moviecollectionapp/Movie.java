package com.example.meiisreallycool.moviecollectionapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity( foreignKeys = @ForeignKey(entity = Director.class, parentColumns = "id", childColumns = "director_id"))
public class Movie {
    @PrimaryKey
    public int _id;

    public String m_title;
    public String year;

   @ColumnInfo(name = "director_id")
    public int directorID;

    public String run_time;
    public Boolean collection_y_n;
}
