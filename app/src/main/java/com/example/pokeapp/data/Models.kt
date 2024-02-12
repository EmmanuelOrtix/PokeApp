package com.example.pokeapp.data

import com.google.gson.annotations.SerializedName

data class PokedexModel(
    @SerializedName("count") val count: Long,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<ResultModel>
)

data class ResultModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)