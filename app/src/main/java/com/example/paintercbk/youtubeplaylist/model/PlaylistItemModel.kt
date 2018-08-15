package com.example.paintercbk.youtubeplaylist.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by paintercbk on 8/15/2018 AD.
 */
class PlaylistItemModel(@SerializedName("list_title") var playlistTitle : String? = null,
                        @SerializedName("list_items") var playlistItems : MutableList<SongModel>? = null,
                        var isExpand : Boolean? = false) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            TODO("playlistItems"),
            parcel.readValue(Boolean::class.java.classLoader) as? Boolean) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(playlistTitle)
        parcel.writeValue(isExpand)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaylistItemModel> {
        override fun createFromParcel(parcel: Parcel): PlaylistItemModel {
            return PlaylistItemModel(parcel)
        }

        override fun newArray(size: Int): Array<PlaylistItemModel?> {
            return arrayOfNulls(size)
        }
    }
}