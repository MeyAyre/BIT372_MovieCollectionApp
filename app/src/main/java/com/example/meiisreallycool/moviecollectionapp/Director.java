package com.example.meiisreallycool.moviecollectionapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Director {
    @PrimaryKey
    public int _id;

    public String first_name;
    public String last_name;
}
