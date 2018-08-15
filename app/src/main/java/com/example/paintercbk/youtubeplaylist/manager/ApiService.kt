package com.example.paintercbk.youtubeplaylist.manager

import com.example.paintercbk.youtubeplaylist.model.PlaylistCollection
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
interface ApiService {

    @GET("playlists")
    fun getPlaylist() : Single<Response<PlaylistCollection>>
}