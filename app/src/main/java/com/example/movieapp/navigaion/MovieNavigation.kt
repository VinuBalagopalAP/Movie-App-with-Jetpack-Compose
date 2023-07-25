package com.example.movieapp.navigaion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.detail.DetailScreen
import com.example.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreen.HomeScreen.name){
        composable(MovieScreen.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(
            route =  MovieScreen.DetailScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){ type= NavType.StringType }) ){
            backStackEntry ->
            DetailScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}