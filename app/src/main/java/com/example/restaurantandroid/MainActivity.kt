@file:Suppress("UNUSED_EXPRESSION")

package com.example.restaurantandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

val showDialog = mutableStateOf(-1)
var home = mutableStateOf(true)
var basket = mutableStateOf(false)
var profile = mutableStateOf(false)
val eat = Eat.Food().food
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { TopBar() },
                bottomBar = { BottomNavigationBar() },
                content = {
                    HomeScreen()
                    BasketScreen()
                    ProfileScreen()
                },
                backgroundColor = colorResource(R.color.black)
            )
        }
    }
}


@Composable
fun TopBar() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.header),
            contentDescription = null,
        )

        Image(
            painter = painterResource(id = R.drawable.ejzshomoqb1ze4mw),
            contentDescription = null,
            modifier = Modifier.size(250.dp, 70.dp)
        )

        Row() {

        }

    }
}

@Composable
fun BottomNavigationBar() {
    var visibleHome by remember {
        mutableStateOf(true)
    }
    var visibleBasket by remember {
        mutableStateOf(false)
    }
    var visibleProfile by remember {
        mutableStateOf(false)
    }

    val items = listOf(
        NavHostController.home,
        NavHostController.basket,
        NavHostController.profile,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.nav), contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(icon = {
                Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.title,
                    modifier = Modifier.size(25.dp)
                )
            },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    if (item.title == "Home") {
                        profile.value = false
                        basket.value = false
                        home.value = true
                    }
                    if (item.title == "Basket") {
                        home.value = false
                        profile.value = false
                        basket.value = true
                    }
                    if (item.title == "Profile") {
                        home.value = false
                        basket.value = false
                        profile.value = true
                    }

                }
            )
        }
    }
}



