package com.example.pokeapp.data

import retrofit2.http.GET

interface PokemonAPI {
    @GET("pokemon/")
    suspend fun getPokemon(): PokedexModel
}