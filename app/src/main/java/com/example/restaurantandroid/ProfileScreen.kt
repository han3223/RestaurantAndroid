package com.example.restaurantandroid

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun ProfileScreen() {
    AnimatedVisibility(visible = profile.value, enter = fadeIn(), exit = fadeOut()) {
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
}
