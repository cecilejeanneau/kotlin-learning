package com.example.mod6demo3room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6demo3room.ui.theme.CoursAndroidTheme
import com.example.mod6demo3room.vm.MusicViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MusicScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MusicScreen(
    modifier: Modifier = Modifier,
    musicViewModel: MusicViewModel = viewModel(factory = MusicViewModel.Factory)
) {
    val musics by musicViewModel.musics.collectAsState(initial = emptyList());

    LazyColumn {
        items(musics){m ->
            Text(
                text = "Name: ${m.title}, Author: ${m.author}"
            );
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursAndroidTheme {
        MusicScreen();
    }
}