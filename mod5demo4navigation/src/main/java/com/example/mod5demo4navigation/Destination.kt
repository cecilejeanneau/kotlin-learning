package com.example.mod5demo4navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val route: String
}

object HomeDestination : Destination {
    override val route : String = "Home";

//    public argument for example the id
    val argName by lazy{"loginValue"};

    val args = listOf(navArgument(argName){
        type = NavType.StringType
    });

    val routeWithArgs = "$route/{$argName}"
}

object SignInDestination : Destination {
    override val route: String = "SignIn";
}