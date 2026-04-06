package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.myapplication.ui.viewmodel.DetailViewModel

@Composable
fun DetailScreen(bookId: String, navController: NavHostController) {
    val viewModel = DetailViewModel(bookId)
    val detail by viewModel.detail.collectAsState()

    detail?.let { data ->
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = data.synopsis,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(data.episodes) { episode ->
                    ListItem(
                        headlineContent = { Text("${episode.index}. ${episode.title}") },
                        leadingContent = {
                            episode.cover?.let {
                                AsyncImage(
                                    model = it,
                                    contentDescription = null,
                                    modifier = Modifier.size(60.dp)
                                )
                            }
                        },
                        modifier = Modifier.clickable {
                            navController.navigate("player/${episode.vid}")
                        }
                    )
                }
            }
        }
    } ?: Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}