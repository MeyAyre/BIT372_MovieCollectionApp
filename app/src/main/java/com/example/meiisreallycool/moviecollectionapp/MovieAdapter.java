package com.example.meiisreallycool.moviecollectionapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.mViewHolder> {
    private final List<Movie> movieData;
    private final Context appContext;

    public MovieAdapter(List<Movie> movieData, Context appContext){
        this.movieData = movieData;
        this.appContext = appContext;
    }

    public static class mViewHolder extends  RecyclerView.ViewHolder{
        @BindView(R.id.title);
        public TextView title;
        public mViewHolder(TextView v){
            super(v);
            title = v.findViewById(R.id.title);
        }
    }

    public MovieAdapter(String[] movieDataSet){
        movieData = movieDataSet;
    }

    @Override
    public MovieAdapter.mViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        mViewHolder vh = new mViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position){
        holder.title.setText(movieData[position]);
    }

    @Override
    public int getItemCount(){
        return movieData.length;
    }
}
