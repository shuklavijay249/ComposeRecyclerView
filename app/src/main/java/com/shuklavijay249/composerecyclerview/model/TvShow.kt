package com.shuklavijay249.composerecyclerview.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class TvShow(
    val id: Int,
    val name: String,
    val year: Int,
    val rating : Double,
    val imageId : Int,
    val overview : String
    ) : Serializable


