package com.example.restaurantandroid

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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

val w = mutableStateOf(
    Modifier.fillMaxWidth()
)

@Composable
fun HomeScreen() {
    BoxWithConstraints {
        if (maxWidth < 420.dp)
            w.value = Modifier.fillMaxWidth()
        else
            w.value = Modifier.width(420.dp)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 50.dp)
            .verticalScroll(ScrollState(0))
    ) {
        Column() {
            eat.forEachIndexed { index, item ->
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
                            Column(modifier = w.value) {
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