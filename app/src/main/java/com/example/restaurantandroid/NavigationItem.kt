package com.example.restaurantandroid

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object home : NavigationItem("home", R.drawable.eat, "Home")
    object basket : NavigationItem("basket", R.drawable.basket, "Basket")
    object profile: NavigationItem("profile", R.drawable.profile, "Profile")
}
