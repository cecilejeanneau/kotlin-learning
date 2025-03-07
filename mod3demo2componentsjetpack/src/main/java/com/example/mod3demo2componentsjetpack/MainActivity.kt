package com.example.mod3demo2componentsjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod3demo2componentsjetpack.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Text(text = "Hello world !");
            Hello("LilithKorn!Nette")
        }
    }
}

// annotation that define a function as a component
@Composable
fun Hello(name : String) {
//    component of lvl screen!
    Scaffold {
//        callback {} dans Column qui attend les autres composants
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "Hello $name !",
//        color = MaterialTheme.colorScheme.onPrimary
//        Color companion object that we instance and get its constants
                color = Color.DarkGray
            );
            Text(text = "oeirjgoierj");
            Text(text = "khorgohr", color = MaterialTheme.colorScheme.onSecondary);
        }
    }
}

// ne doit pas prendre de paramètres !!!
// permet de voir dans la preview en haut à droite les trois barres horizontales et le phone
@Composable
@Preview
fun Preview(){
    Hello(name = "jhgierhi");
}