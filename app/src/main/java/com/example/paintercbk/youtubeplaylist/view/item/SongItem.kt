package com.example.paintercbk.youtubeplaylist.view.item

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.paintercbk.youtubeplaylist.R
import com.example.paintercbk.youtubeplaylist.model.SongModel
import kotlinx.android.synthetic.main.song_list_item.view.*

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class SongItem : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    lateinit var songItem: SongModel


    init {
        View.inflate(context, R.layout.song_list_item, this)
    }

    fun bindView(songItem : SongModel) {
        this.songItem = songItem
        setPreviewImg()
        setSongTitle()
        playVideo()
    }

    fun setPreviewImg() {
        Glide.with(context)
                .load(songItem.thumb)
                .into(songPrevImg)
    }

    fun setSongTitle() {
        songTitleTV.text = songItem.title
    }

    fun playVideo() {
        this.setOnClickListener {
            var intent = android.content.Intent(context, com.example.paintercbk.youtubeplaylist.view.PlayerActivity::class.java)
            intent.putExtra("song", songItem)
            context.startActivity(intent)
        }
    }
}