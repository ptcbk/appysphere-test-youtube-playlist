package com.example.paintercbk.youtubeplaylist.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.paintercbk.youtubeplaylist.R
import com.example.paintercbk.youtubeplaylist.model.PlaylistCollection
import com.example.paintercbk.youtubeplaylist.model.PlaylistItemModel
import com.example.paintercbk.youtubeplaylist.view.viewholder.PlaylistHeaderViewHolder

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class PlaylistAdapter(var context: Context) : RecyclerView.Adapter<PlaylistHeaderViewHolder>() {
    var playlistCollection = PlaylistCollection()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistHeaderViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.playlist_header_viewholder, parent, false)
        return PlaylistHeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return when(playlistCollection.playlists?.size) {
            0 -> 0
            null -> 0
            else -> playlistCollection.playlists!!.size
        }
    }

    override fun onBindViewHolder(holder: PlaylistHeaderViewHolder, position: Int) {
        holder.playlsitHeaderItem.bindview(playlistCollection.playlists!!.get(position))
    }

    fun setCollection(collection : PlaylistCollection) {
        this.playlistCollection = collection
    }
}