package com.example.pokeapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokedexModel(
    @SerializedName("count") val count: Long,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<ResultModel>
): Parcelable

@Parcelize
data class ResultModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
): Parcelable
