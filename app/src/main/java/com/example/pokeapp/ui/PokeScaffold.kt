package com.example.pokeapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokeScaffold(
    topBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {}
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = topBar,
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content.invoke()
        }
    }
}