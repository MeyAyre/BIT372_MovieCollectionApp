package com.example.meiisreallycool.moviecollectionapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.meiisreallycool.moviecollectionapp.database.Director;

@Entity(tableName ="movie")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    @NonNull
    private String m_title;
    private String year;
   // @ColumnInfo(name = "director_id")
    private String director_first;
   // @ColumnInfo(name = "director_id")
    private String director_last;
    private String run_time;
   // private Boolean collection_y_n;

    @Ignore
    public Movie(){}

    public Movie(String m_title, String year, String director_first, String director_last, String run_time){
        this.m_title = m_title;
        this.year = year;
        this.director_first = director_first;
        this.director_last = director_last;
        this.run_time = run_time;
    }
    @Ignore
    public Movie(int id, String m_title, String year, String director_first, String director_last, String run_time){
        this._id = id;
        this.m_title = m_title;
        this.year = year;
        this.director_first = director_first;
        this.director_last = director_last;
        this.run_time = run_time;
    }
    public int get_id(){
        return _id;
    }

    public void set_id(int id){
        this._id = id;
    }

    public String getM_title(){
        return m_title;
    }

    public void setM_title(String title){
        this.m_title = title;
    }

    public String getYear(){return year;}

    public String getRun_time(){
        return run_time;
    }

    public void setRun_time(String runtime){
        this.run_time = runtime;
    }

    public String getDirector_first(){
        return director_first;
    }
    public String getDirector_last(){
        return director_last;
    }
    public void setDirector_first(String name){
        this.director_first = name;
    }
    public void setDirector_last(String name){
        this.director_last = name;
    }

   /* public Boolean getCollection_y_n(){
        return collection_y_n;
    } */
}
