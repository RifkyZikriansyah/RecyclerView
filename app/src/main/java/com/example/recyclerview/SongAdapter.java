package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> songList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tvRank, tvSongName, tvSinger, tvYear;
        public ImageView ivAlbumCover;

        public ViewHolder(View v) {
            super(v);
            tvRank = (TextView) v.findViewById(R.id.tv_rank);
            tvSongName = (TextView) v.findViewById(R.id.tv_song_name);
            tvSinger = (TextView) v.findViewById(R.id.tv_singer);
            tvYear = (TextView) v.findViewById(R.id.tv_year);
            ivAlbumCover = (ImageView) v.findViewById(R.id.iv_album_cover);
        }

    }
    //Provide a suitable constructor
    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }
    //Create new Views (invoked by the layout manager)
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_song_list_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(String.valueOf(song.getName()));
        holder.tvSinger.setText(String.valueOf(song.getSinger()));
        holder.tvYear.setText(String.valueOf(song.getYear()));
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText("2016");
    }
    @Override
    public int getItemCount() {
        return songList.size();
    }
}
