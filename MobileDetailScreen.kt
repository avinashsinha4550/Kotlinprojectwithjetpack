package com.compare.show.screens

import android.content.Context
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally


import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.compare.show.DatabaseHandler


import com.compare.show.R
import com.compare.show.model.SelectMobileListModel


@Composable
fun MobileDetails(navController: NavController, context: Context, mobileid:String)
{
    Column(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier
                                // .background(JetpackComposeMaterialTheme.colors.primary)
                                .fillMaxWidth()
                                .height(52.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .padding(top = 15.dp)
                            ) {
                                Image(

                                    painterResource(id = R.drawable.back_button),
                                    contentDescription = "", modifier = Modifier
                                        .clickable(
                                            enabled = true,
                                            onClickLabel = "Clickable image",
                                            onClick = {
//                                                openDrawer()
                                                navController.navigate("home")
                                            }
                                        )
                                )
                            }
                            Text(
                                text = "Product Detail",
                                color = Color.White,
                                modifier = Modifier.weight(2f),
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = "",
                                color = Color.White,
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center
                            )

                        }

                    },
                    backgroundColor = colorResource(id = R.color.red_700),
                    contentColor = Color.White
                )

            }
        )
        {
            var listState = rememberLazyListState()
            val selectMobilelist = mutableListOf<SelectMobileListModel>()

            var numberOfMobileCount by remember { mutableStateOf(0) }
            var datah= DatabaseHandler(context)
            var mobileList = datah.getMobileDataDetails()
            LazyColumn() {
                item {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)

                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mobile!!),
                            contentDescription = "",
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .fillMaxWidth()
                                .height(300.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = mobileList[0].name,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row() {
                            Column(modifier = Modifier.padding(5.dp)) {
                                Text(
                                    text = "PRICE :",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = mobileList[0].price)
                            }

                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Row() {
                            Column(modifier = Modifier.padding(5.dp)) {
                                Text(
                                    text = "CPU RAM :",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = mobileList[0].ramTitle +"\n"+mobileList[0].ramDetails          )
                            }


                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Row() {
                            Column(modifier = Modifier.padding(5.dp)) {
                                Text(
                                    text = "Display :",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text =  mobileList[0].displayTitle +"\n"+mobileList[0].displayDiscription,

                                )
                            }

                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Row() {
                            Column(modifier = Modifier.padding(5.dp)) {
                                Text(
                                    text = "Main Camera :",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text =  mobileList[0].mainCameraTitle +"\n"+mobileList[0].mainCameraDiscription,

                                )
                            }

                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Row() {
                            Column(modifier = Modifier.padding(5.dp)) {
                                Text(
                                    text = "Front Camera :",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text =  mobileList[0].frontCameraTitle +"\n"+mobileList[0].frontCameraDiscription, fontSize = 18.sp)
                            }

                        }

                        Spacer(modifier = Modifier.height(20.dp))


                    }

                }
            }
        }}

}


