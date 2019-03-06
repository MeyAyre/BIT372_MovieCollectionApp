package com.example.meiisreallycool.moviecollectionapp.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.example.meiisreallycool.moviecollectionapp.database.Director;

@Entity( foreignKeys = @ForeignKey(entity = Director.class, parentColumns = "id", childColumns = "director_id"))
public class Movie {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String m_title;
    private String year;
    @ColumnInfo(name = "director_id")
    private String director_first;
    @ColumnInfo(name = "director_id")
    private String director_last;
    private String run_time;
    private Boolean collection_y_n;

    @Ignore
    public Movie(){}

    public Movie(String m_title, String year, String directorfirst, String directorlast, String runtime){
        this.m_title = m_title;
        this.director_first = directorfirst;
        this.director_last = directorlast;
        this.run_time = runtime;
    }
    public Movie(int id, String m_title, String year, String directorfirst, String directorlast, String runtime){
        this._id = id;
        this.m_title = m_title;
        this.director_first = directorfirst;
        this.director_last = directorlast;
        this.run_time = runtime;
    }

    public int getId(){
        return _id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getTitle(){
        return m_title;
    }

    public void setTitle(String title){
        this.m_title = title;
    }

    public String getRuntime(){
        return run_time;
    }

    public void setRuntime(String runtime){
        this.run_time = runtime;
    }

    public String getDirectorFull(){
        return director_first + " " + director_last;
    }

    public void setDirectorFirst(String name){
        this.director_first = name;
    }
    public void setDirectorLast(String name){
        this.director_last = name;
    }
}
