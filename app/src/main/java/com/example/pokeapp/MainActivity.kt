package com.example.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokeapp.presentation.PokedexViewModel
import com.example.pokeapp.ui.PokeScaffold
import com.example.pokeapp.utils.PokeObject
import com.example.pokeapp.utils.components.CardView
import com.example.pokeapp.utils.ui.theme.PokeAppTheme
import com.example.pokeapp.utils.ui.theme.PokeColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            PokeAppTheme {
                val viewModel: PokedexViewModel = hiltViewModel()
                PokeScaffold(
                    topBar = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(75.dp)
                                .background(PokeColors.RED)
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(25.dp)
                            )
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                Arrangement.Center,
                                Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Pokedex",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(150.dp),
                        )
                        {
                            viewModel.data.value.data?.results?.size?.let { pokemon ->
                                items(pokemon) {
                                    CardView(
                                        name = viewModel.data.value.data!!.results[it].name,
                                        PokeObject.regexNumber.find(viewModel.data.value.data!!.results[it].url.replace("V2", "", true))?.value.toString()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

//Column(
//modifier = Modifier.padding(16.dp)
//) {
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(150.dp),
//    )
//    {
//        viewModel.data.value.data?.results?.size?.let { pokemon ->
//            items(pokemon) {
//                CardView(name = viewModel.data.value.data!!.results[it].name
//                )
//            }
//        }
//    }
//}
