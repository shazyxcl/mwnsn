package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp                  // ← ditambahkan
import androidx.navigation.NavHostController
import com.example.myapplication.ui.components.DramaItem
import com.example.myapplication.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = HomeViewModel()
    val latest by viewModel.latest.collectAsState()
    val trending by viewModel.trending.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = "Drama Terbaru",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(latest) { book ->
            DramaItem(book) {
                navController.navigate("detail/${book.bookId}")
            }
        }

        item {
            Text(
                text = "Drama Trending",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(trending) { book ->
            DramaItem(book) {
                navController.navigate("detail/${book.bookId}")
            }
        }
    }
}