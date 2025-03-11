package com.example.mod5demo4navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mod5demo4navigation.ui.theme.CoursAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    NavHostExample()
                }
            }
        }
    }
}

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    loginValue: String
    ) {
    Text(
        text = "Votre espace $loginValue",
        modifier = modifier.padding(16.dp)
    );
}

@Composable
fun SignInPage(
    modifier: Modifier = Modifier,
    onClickToHome: (String) -> Unit
    ) {

    var loginValue by remember {
        mutableStateOf("")
    }
    Scaffold(Modifier.padding(16.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Connectez-vous",
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            );
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = loginValue,
                onValueChange = {
                    loginValue = it
                }
            );
            OutlinedButton(
//                onClick = {
//                    onClickToHome()
//                },
                onClick = {
                    onClickToHome(loginValue)
                          },
                modifier = Modifier.padding(it)
            ) {
                Text(text = "Se connecter");
            }
        }
    }
}

@Composable
fun NavHostExample(
    modifier : Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    ) {
//    need dependence in Manifest :
//    implementation ("androidx.navigation:navigation-compose:2.8.4")
//    implementation("androidx.navigation:navigation-runtime-ktx:2.8.4")
    NavHost(
        navController = navHostController,
        startDestination = SignInDestination.route
    ) {
        composable(SignInDestination.route){
            SignInPage(
                onClickToHome = {
//                    to declare routes
                    navHostController.navigate("${HomeDestination.route}/$it")
                }
            )
        }
        composable(route = HomeDestination.routeWithArgs, arguments = HomeDestination.args) {
            navBackStackEntry -> val login = navBackStackEntry.arguments?.getString(HomeDestination.argName)
            if (login != null) {
                HomePage(
                    loginValue = login
                );
            }
        }
    }
}
