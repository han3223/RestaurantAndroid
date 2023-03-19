@file:Suppress("UNUSED_EXPRESSION")

package com.example.restaurantandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    //    val dbHandler: DBHandler = DBHandler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = {  // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box() {
                Navigation(navController)
            }
        },
        backgroundColor = colorResource(R.color.black) // Set background color to avoid the white flashing when you switch between screens
    )
}

@Composable
fun Navigation(navController: androidx.navigation.NavHostController) {
    NavHost(navController, startDestination = NavHostController.home.route) {
        composable(NavHostController.home.route) {
            HomeScreen()
        }
        composable(NavHostController.basket.route) {
            BasketScreen()
        }
        composable(NavHostController.profile.route) {
            ProfileScreen()
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
fun BottomNavigationBar(navController: androidx.navigation.NavHostController) {
    val items = listOf(
        NavHostController.home,
        NavHostController.basket,
        NavHostController.profile,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.nav), contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
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
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

private val showDialog = mutableStateOf(-1)

@Composable
fun HomeScreen() {
    val items = Eat.Food().food
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 50.dp)
            .verticalScroll(ScrollState(0))
    ) {
        Column() {
            items.forEachIndexed { index, item ->
                when (item.route) {
                    "lineCategory" -> {
                        Text(
                            item.title!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                            fontSize = 6.em,
                            color = Color.White
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 0.dp, 0.dp, 10.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(id = item.icon!!),
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(350.dp, 10.dp)
                                    .clip(RoundedCornerShape(25.dp)),
                                alignment = Alignment.Center,
                                contentScale = ContentScale.FillBounds
                            )
                        }

                    }
                    "lineSubcategory" -> {
                        Text(
                            item.title!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                            color = Color.White
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(id = item.icon!!),
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(250.dp, 10.dp)
                                    .clip(RoundedCornerShape(25.dp)),
                                alignment = Alignment.Center,
                                contentScale = ContentScale.FillBounds
                            )
                        }

                    }
                    else -> {
                        Spacer(modifier = Modifier.size(15.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column() {
                                Row() {
                                    Image(
                                        painter = painterResource(id = item.icon!!),
                                        contentDescription = item.title,
                                        modifier = Modifier
                                            .size(150.dp)
                                            .clip(RoundedCornerShape(25.dp)),
                                        alignment = Alignment.Center,
                                        contentScale = ContentScale.FillBounds
                                    )
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Text(item.title!!, color = Color.White)
                                        Image(
                                            painter = painterResource(id = R.drawable.line),
                                            contentDescription = item.title,
                                            modifier = Modifier
                                                .size(150.dp, 3.dp)
                                                .clip(RoundedCornerShape(25.dp)),
                                            alignment = Alignment.Center,
                                            contentScale = ContentScale.FillBounds
                                        )
                                        Text(item.description!!, color = Color.White)
                                        Image(
                                            painter = painterResource(id = R.drawable.line),
                                            contentDescription = item.title,
                                            modifier = Modifier
                                                .size(150.dp, 3.dp)
                                                .clip(RoundedCornerShape(25.dp)),
                                            alignment = Alignment.Center,
                                            contentScale = ContentScale.FillBounds
                                        )
                                        Text(
                                            "каллорийность - ${item.calories!!} ккал \nбелки - 00г, жиры - 00г, углеводы - 00г",
                                            fontSize = 3.em,
                                            color = Color.White
                                        )
                                    }
                                }
                                Price(item, index)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .padding(0.dp, 15.dp, 0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        Box(modifier = Modifier.width(300.dp)) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(text = "Важенин Иван", color = Color.White, fontSize = 6.em)
                        Text(text = "Анатольевич", color = Color.White, fontSize = 6.em)
                    }

                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "profile",
                        modifier = Modifier.size(60.dp),
                        alignment = Alignment.BottomEnd
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = "line",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "тел: 89116172604", color = Color.White, fontSize = 6.em)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "email: ivan.vazhenin34@gmail.com",
                        color = Color.White,
                        fontSize = 6.em,
                        modifier = Modifier.width(260.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                ) {
                    Text(
                        text = "адрес доставки:\nул. Коровникова, д. 12, кв. 101",
                        color = Color.White,
                        fontSize = 6.em,
                        modifier = Modifier.width(260.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                        .padding(0.dp, 25.dp, 0.dp, 0.dp)
                ) {
                    Text(
                        text = "История заказов:",
                        color = Color.White,
                        fontSize = 6.em,
                        modifier = Modifier.width(260.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                        .padding(0.dp, 5.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Время заказа",
                        color = Color.White,
                        fontSize = 5.em,
                    )
                    Text(
                        text = "Сумма",
                        color = Color.White,
                        fontSize = 5.em,
                    )
                    Text(
                        text = "Чек",
                        color = Color.White,
                        fontSize = 5.em,
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = "line",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(30.dp, 120.dp)
                        .padding(0.dp, 5.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "12 фев. 2023 г. 18:32",
                        color = Color.White,
                        fontSize = 4.em,
                    )
                    Text(
                        text = "1780 ₽",
                        color = Color.White,
                        fontSize = 4.em,
                    )
                    Text(
                        text = "Посмотреть",
                        color = Color.White,
                        fontSize = 4.em,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }

    }
}

@Composable
fun BasketScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
            .wrapContentSize(Alignment.Center)
    ) {
        Box(modifier = Modifier.width(300.dp)) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(0.5f),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.btn_active))
            ) {

            }
//            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(0.5f)) {
//
//            }
        }

    }
}

@Composable
fun Price(item: Eat, index: Int) {
    Box(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)) {
        if (showDialog.value == index) {
            AddFood()
        } else {
            Button(
                onClick = {
                    showDialog.value = index
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(150.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.button_price),
                    contentColor = Color.White
                )
            ) {
                val cena = Text(text = "${item.price} ₽")
            }
        }
    }
}

@Composable
fun AddFood() {
    Row(modifier = Modifier.width(150.dp), horizontalArrangement = Arrangement.Center) {
        var text by remember { mutableStateOf(0) }
        Button(
            onClick = {
                if (text == 0)
                    text = 0
                else
                    text -= 1
            },
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .border(0.dp, Color.White, CircleShape),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.button_price),
                contentColor = Color.White
            )
        ) {
            Text(text = "-")
        }
        Spacer(modifier = Modifier.size(7.dp))
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(0.dp, Color.White, CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center

        ) {
            Text(text = text.toString(), color = Color.Black)
        }
        Spacer(modifier = Modifier.size(7.dp))
        Button(
            onClick = { text += 1 },
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .border(0.dp, Color.White, CircleShape),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.button_price),
                contentColor = Color.White
            )
        ) {
            Text(text = "+")
        }
    }
}