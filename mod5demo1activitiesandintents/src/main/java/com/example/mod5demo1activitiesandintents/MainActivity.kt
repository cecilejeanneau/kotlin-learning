package com.example.mod5demo1activitiesandintents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod5demo1activitiesandintents.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    from a component get the context
    val context = LocalContext.current;
    Scaffold { innerPadding ->
        OutlinedButton(
            onClick = {
                context.startActivity(
//                    explicit intent
                    Intent(
                        context,
                        TargetActivity::class.java
                    )
                );
            },
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(text = "Go to Target Activity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursAndroidTheme {
        Greeting("Android")
    }
}