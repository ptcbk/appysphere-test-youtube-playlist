package com.example.paintercbk.youtubeplaylist.view

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.paintercbk.youtubeplaylist.R
import com.example.paintercbk.youtubeplaylist.view.adapter.PlaylistAdapter
import com.example.paintercbk.youtubeplaylist.viewmodel.PlaylistViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initData()
    }

    fun initRecyclerView() {
        adapter = PlaylistAdapter(this)
        playlistRecyclerview.adapter = adapter
        playlistRecyclerview.layoutManager = LinearLayoutManager(this)
    }

    fun initData() {
        PlaylistViewModel().getPlaylist(this)
                .observe(this, Observer {
                    it?.let {
                        adapter.setCollection(it)
                        adapter.notifyDataSetChanged()
                    }
                })
    }
}
