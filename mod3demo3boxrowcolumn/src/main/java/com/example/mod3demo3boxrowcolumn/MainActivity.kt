package com.example.mod3demo3boxrowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod3demo3boxrowcolumn.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun RowAndColumnExample(){
    Column {
        Text(text = "Column");
        Row {
            Text(text = "rowit1");
            Text(text = "rowit2");
            Text(text = "rowit3");
        }
        Column {
            Text(text = "columnit1");
            Text(text = "columnit2");
            Text(text = "columnit3");
        }
    }
}

//we can't place, handle position of an element which doesn't have a width/size

@Composable
fun BoxExample(){
    Box(contentAlignment = Alignment.BottomCenter) {
//        resource png or jpg Image painter
        Image(
            painter = painterResource(id = R.drawable.favicon),
            contentDescription = "logo",
            modifier = Modifier.clip(CircleShape).background(color = Color.White),
//            modifier = Modifier.background(color = Color.White)
        )
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "icon of user",
            tint = Color.Cyan
        )
    }
}

@Preview
@Composable
fun Preview(){
//    RowAndColumnExample();
    BoxExample();
}