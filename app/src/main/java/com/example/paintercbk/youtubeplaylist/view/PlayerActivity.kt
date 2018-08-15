package com.example.paintercbk.youtubeplaylist.view

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.paintercbk.youtubeplaylist.R
import com.example.paintercbk.youtubeplaylist.model.SongModel
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    val API_KEY = "AIzaSyBrtoqBHROHH16W9qhH7-q_Bm7pyAHz2cM"
    var songObj = SongModel()
    lateinit var youtubePlayer : YouTubePlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        if (intent.getParcelableExtra<SongModel>("song") != null) {
            songObj = intent.getParcelableExtra<SongModel>("song")
        }
        playerView.initialize(API_KEY, this)
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
        this.youtubePlayer = player!!
        if (!wasRestored) {
            player?.loadVideo(getVideoID())
            player?.play()
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?, error: YouTubeInitializationResult?) {
        Log.wtf("ptcbk", "YT INIT ERROR: ${error.toString()}")
    }

    fun getVideoID() : String {
        var splitString = songObj.link!!.split("v=")
        return splitString[1]
    }
}