package com.example.mod3demo4spaces

//ctrl alt o to clean useless imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

//alt enter if error of import on a class/function or to surround with a widget
@Composable
fun SpacerExample(){
    Column {
        Text(text = "La belle verte");
        Spacer(modifier = Modifier.height(8.dp))
        Row(
//            modifier = Modifier.height(
//            fill content
//            IntrinsicSize.Min
//        )
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "favourite icon",
                tint = Color.Magenta,
//                modifier = Modifier.fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "La ligne verte");
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "favourite icon",
                tint = Color.Magenta
            )
        };
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Eternal sunshine of the spotless mind");
    }
}

@Composable
@Preview
fun Preview(){
    SpacerExample();
}