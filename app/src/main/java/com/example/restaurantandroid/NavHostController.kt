package com.example.restaurantandroid

sealed class NavHostController(var route: String, var icon: Int, var title: String) {
    object home : NavHostController("home", R.drawable.eat, "Home")
    object basket : NavHostController("basket", R.drawable.basket, "Basket")
    object profile: NavHostController("profile", R.drawable.profile, "Profile")
}
