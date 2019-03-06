package com.example.meiisreallycool.moviecollectionapp.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Director {
    @PrimaryKey(autoGenerate = true)
    public int _id;
    public String first_name;
    public String last_name;


    @Ignore
    public Director(int id, String first_name, String last_name){
        this._id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Director(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public int getID(){
        return _id;
    }
    public String getFirstName(){
        return first_name;
    }
    public void setFirstName(String first){
        this.first_name = first;
    }
    public String getLastName(){
        return last_name;
    }
    public void setLastName(String last){
        this.last_name = last;
    }
    public String getName(){
        return first_name + " " + last_name;
    }
}
