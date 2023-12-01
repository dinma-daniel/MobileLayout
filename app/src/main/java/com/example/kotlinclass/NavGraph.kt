package com.example.kotlinclass

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    catViewModel: CatViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(
                navController = navController,
                catViewModel = catViewModel
            )
        }
        composable(
            route = Screen.Detail.route
        ){
            Details {

            }
        }
    }
}