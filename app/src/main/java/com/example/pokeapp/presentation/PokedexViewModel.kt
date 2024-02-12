package com.example.pokeapp.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.PokedexModel
import com.example.pokeapp.domain.PokemonRepository
import com.example.pokeapp.utils.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    val data: MutableState<DataOrException<PokedexModel, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception(""))
    )

    init {
        getAllPokedex()
    }

    private fun getAllPokedex() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllPokedex()

            if(data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
            }
        }
    }

    fun getTotalCountPokemon(): Int? {
        return data.value.data?.count?.toInt()
    }
}