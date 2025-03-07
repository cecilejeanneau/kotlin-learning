package com.example.mod3demo5lists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleList();
        }
    }
}

@Composable
fun ArticleList(modifier : Modifier = Modifier) {
    val articles = List(300){
        "Article $it";
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(articles){
//            it = boolean of state of checkbox
            ArticleItem(article = it);
        }
    }
}

@Composable
fun ArticleItem(article: String, modifier: Modifier = Modifier) {
    var isChecked = false;
    Surface(
        border = BorderStroke(2.dp, Color.Magenta),
        shape = AbsoluteRoundedCornerShape(100.dp),
        shadowElevation = 8.dp,
        color = Color.LightGray,
        contentColor = Color.DarkGray
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text(
                text = article,
                style = TextStyle(fontSize = 20.sp)
            );
            Checkbox(checked = isChecked, onCheckedChange = {
                isChecked = it
            })
        }
    }
}

@Preview
@Composable
fun Preview() {
//    ArticleItem(article = "Faire une TODOLIST");
//    ArticleItem("pc");
    ArticleList();
}