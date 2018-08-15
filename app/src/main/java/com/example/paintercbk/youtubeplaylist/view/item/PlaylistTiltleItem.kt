package com.example.paintercbk.youtubeplaylist.view.item

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.paintercbk.youtubeplaylist.R
import com.example.paintercbk.youtubeplaylist.model.PlaylistItemModel
import com.example.paintercbk.youtubeplaylist.view.adapter.SongAdapter
import kotlinx.android.synthetic.main.playlist_header.view.*

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class PlaylistTiltleItem : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    lateinit var playlistItem: PlaylistItemModel
    lateinit var adapter : SongAdapter

    init {
        View.inflate(context, R.layout.playlist_header, this)
    }

    fun bindview(playlistItem : PlaylistItemModel) {
        this.playlistItem = playlistItem
        setPlaylistHeader()
        setSongList()
        setOnClick()
    }

    fun setPlaylistHeader() {
        playlistTitleTV.text = playlistItem.playlistTitle
    }

    fun setSongList() {
        adapter = SongAdapter(context, playlistItem.playlistItems!!)
        songRecyclerview.adapter = adapter
        songRecyclerview.layoutManager = LinearLayoutManager(context)
    }

    fun setOnClick() {
        this.setOnClickListener {
            android.util.Log.wtf("ptcbk", "Click ${playlistItem.isExpand}")
            if (playlistItem.isExpand!!) {
                collapseSongList()
            } else {
                expandSongList()
            }
        }
    }

    fun expandSongList() {
        songRecyclerview.visibility = visibility
        playlistItem.isExpand = true
    }

    fun collapseSongList() {
        songRecyclerview.visibility = View.GONE
        playlistItem.isExpand = false
    }
}