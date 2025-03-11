package com.example.mod5demo2implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod5demo2implicitintent.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        GotoMap(
                            modifier = Modifier.padding(innerPadding)
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Call(
                            modifier = Modifier.padding(innerPadding)
                        );
                    }
                }
            }
        }
    }
}

@Composable
fun GotoMap(modifier: Modifier = Modifier) {
    val context = LocalContext.current;

    Column {
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:48.039,-1.692")
                ).also {
                    context.startActivity(it)
                }
            }
        ) {
            Text(text = "Go !")
        }
    }
}

@Composable
fun Call(modifier: Modifier = Modifier) {
    val context = LocalContext.current;
//    check if permissions active
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Intent(
                Intent.ACTION_CALL, Uri.parse(
                    "tel:0606060606"
                )).also {
                context.startActivity(it)
            }
        } else {
            Intent(
                Intent.ACTION_DIAL, Uri.parse(
                    "tel:654561659879"
                )).also {
                context.startActivity(it)
            }
        }
    }
    Column {
        Button(
            onClick = {
                requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
            }
        ) {
            Text(text = "Call A FRIEND");
        }
    }
}