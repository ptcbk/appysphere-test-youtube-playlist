package com.example.paintercbk.youtubeplaylist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.paintercbk.youtubeplaylist.manager.HttpManager
import com.example.paintercbk.youtubeplaylist.model.PlaylistCollection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class PlaylistViewModel : ViewModel() {

    fun getPlaylist(context: Context) : LiveData<PlaylistCollection> {
        var collection = MutableLiveData<PlaylistCollection>()
        HttpManager(context){}.service.getPlaylist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isSuccessful) {
                        collection.value = it.body()!!
                    } else {
                        Toast.makeText(context, "ERROR CODE : ${it.code()}", Toast.LENGTH_SHORT).show()
                    }
                }, {
                    Log.wtf("ptcbk", it.message)
                })
        return collection
    }
}