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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.restaurantandroid.database.DBHandler
import com.example.restaurantandroid.ui.theme.RestaurantAndroidTheme


class MainActivity : ComponentActivity() {
    //    val dbHandler: DBHandler = DBHandler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantAndroidTheme {
                Scaffold(topBar = { Header() }, bottomBar = { Footer() }) {
//                    dbHandler.getConnection()
                    Body()
                }
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

private val showDialog = mutableStateOf(-1)

@Composable
fun Header() {
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
fun Footer() {
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
                    /* Add code later */
                })
        }
    }
}

@Composable
fun Body() {
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
                            fontSize = 6.em
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
                            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
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
                                        Text(item.title!!)
                                        Image(
                                            painter = painterResource(id = R.drawable.line),
                                            contentDescription = item.title,
                                            modifier = Modifier
                                                .size(150.dp, 3.dp)
                                                .clip(RoundedCornerShape(25.dp)),
                                            alignment = Alignment.Center,
                                            contentScale = ContentScale.FillBounds
                                        )
                                        Text(item.description!!)
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
                                            fontSize = 3.em
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

//@Preview
//@Composable
//fun PreviewMessageCard() {
//    Header("Android")
//}
