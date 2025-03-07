package com.example.mod4demo1states

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod4demo1states.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Form(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Form(modifier: Modifier = Modifier) {

    var firstname: String = "";
    var lastname by remember {
//        renvoie un objet qui stocke la valeur de l'élément encapsule la donnée, donc de type mutable
        mutableStateOf("")
    }
    var age by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        TextField(
            value = firstname,
            label = { Text(text = "Prénom ?") },
            onValueChange = {
                firstname = it;
            }
        );
        TextField(
            value = lastname,
            label = { Text(text = "Nom ?") },
            onValueChange = {
                lastname = it;
            }
        )
        TextField(
            value = age,
            label = { Text(text = "Age ?") },
            onValueChange = {
                age = it;
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}