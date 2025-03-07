package com.example.tpvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tpvm.ui.theme.CoursAndroidTheme
import com.example.tpvm.vm.DiceViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        DiceGame();
                    }
                }
            }
        }
    }
}

@Composable
fun DiceGame(
    modifier: Modifier = Modifier,
    viewModel: DiceViewModel = viewModel()
) {
//    listen to the only var which will be always changed
    val totalRolls by viewModel.totalRolls.collectAsState();
    val dice by viewModel.dice.collectAsState();

    val diceImage = painterResource(dice);

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = diceImage,
            contentDescription = "actual dice image",
            modifier = Modifier.size(75.dp)
        );
        Text(text = totalRolls.toString());
//        Row {
//            Text(text = "Total = ${viewModel.totalDicesLeft} / ${viewModel.totalRollsLeft} lancer(s)");
//            Text(text = "Total = ${viewModel.totalDicesRight} / ${viewModel.totalRollsRight} lancer(s)");
//        }
//        Row {
//            Button(onClick = {
//                viewModel.leftRound()
//            }) {
//                Text(text = "GAUCHE")
//            }
//            Button(onClick = {
//                viewModel.rightRound()
//            }) {
//                Text(text = "DROITE")
//            }
//        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Total = ${viewModel.totalDicesLeft} / ${viewModel.totalRollsLeft} lancer(s)");
                Button(onClick = {
                    viewModel.leftRound()
                }) {
                    Text(text = "GAUCHE")
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Total = ${viewModel.totalDicesRight} / ${viewModel.totalRollsRight} lancer(s)");

                Button(onClick = {
                    viewModel.rightRound()
                }) {
                    Text(text = "DROITE")
                }
            }
        }
        Button(
            onClick = {
                viewModel.reset()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "RECOMMENCER");
        }
    }
}