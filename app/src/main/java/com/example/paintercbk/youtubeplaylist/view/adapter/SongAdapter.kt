package com.example.paintercbk.youtubeplaylist.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.paintercbk.youtubeplaylist.R
import com.example.paintercbk.youtubeplaylist.model.SongModel
import com.example.paintercbk.youtubeplaylist.view.viewholder.SongViewHolder

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class SongAdapter(var context: Context, var songList: MutableList<SongModel>) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.song_viewholder, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return when(songList.size) {
            0 -> 0
            null -> 0
            else -> songList.size
        }
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songItem.bindView(songList.get(position))
    }
}