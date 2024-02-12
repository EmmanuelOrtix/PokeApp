package com.example.pokeapp.domain

import android.util.Log
import com.example.pokeapp.data.PokedexModel
import com.example.pokeapp.data.PokemonAPI
import com.example.pokeapp.utils.DataOrException
import javax.inject.Inject

class PokemonRepository @Inject constructor(
   private val pokemonAPI: PokemonAPI
) {
    private val dataOrException = DataOrException<PokedexModel, Boolean, Exception>()

    suspend fun getAllPokedex(): DataOrException<PokedexModel, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = pokemonAPI.getPokemon()

            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (ex: Exception) {
            dataOrException.e = ex
            Log.d("Exc", "getAllPokedex: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}