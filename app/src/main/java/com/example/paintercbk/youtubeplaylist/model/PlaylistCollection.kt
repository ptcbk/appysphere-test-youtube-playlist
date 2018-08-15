package com.example.paintercbk.youtubeplaylist.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class PlaylistCollection(@SerializedName("playlists") var playlists : MutableList<PlaylistItemModel>? = null) {
}