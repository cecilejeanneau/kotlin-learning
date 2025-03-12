package com.example.mod6demo2sqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6demo2sqlite.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(56.dp)
                    ) {
                        Spacer(
                            modifier = Modifier.height(30.dp)
                        );
                        BookScreen(
                            modifier = Modifier.padding(innerPadding)
                        );
                    }
                }
            }
        }
    }
}

@Composable
fun BookScreen(
    modifier: Modifier = Modifier,
    bookViewModel: ListBookViewModel = viewModel(factory = ListBookViewModel.Factory)
) {
    val books by bookViewModel.books.collectAsState();

    LazyColumn {
        items(books){b ->
            Text(
                text = "Name: ${b.name}, Author: ${b.author}"
            );
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursAndroidTheme {
        BookScreen();
    }
}