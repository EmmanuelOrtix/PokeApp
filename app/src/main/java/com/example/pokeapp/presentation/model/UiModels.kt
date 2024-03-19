package com.example.pokeapp.presentation.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiPokedexModel(
    @SerializedName("count") val count: Long,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<UiResultModel>
): Parcelable

@Parcelize
data class UiResultModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
): Parcelable