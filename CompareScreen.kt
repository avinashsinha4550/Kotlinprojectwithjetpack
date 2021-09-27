package com.compare.show.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.compare.show.DatabaseHandler
import com.compare.show.R
import com.compare.show.model.SelectMobileListModel


@Composable
fun CompareScreen(navController: NavController, context: Context, selectMobile1: String,selectMobile2: String,selectMobile3: String,selectMobile4: String) {
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
                                    .width(30.dp)
                                    .height(30.dp)
                                    .weight(1f)
                                    .padding(top = 15.dp)
                            ) {
                                Image(

                                    painterResource(id = R.drawable.down),
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
                                text =  "Select Product",
                                color = Color.White,
                                modifier = Modifier.weight(4f),
                                textAlign = TextAlign.Center
                            )
                            Text(text = "",
                                    modifier = Modifier.weight(1f),
                            )



                        }

                    },
                backgroundColor = colorResource(id = R.color.red_700),
                contentColor = Color.White

            )
        }) {
        LazyColumn(modifier = Modifier.padding(20.dp)) {
            item {
                val context = context
                spinner(navController, context,selectMobile1,selectMobile2,selectMobile3,selectMobile4)
            }
        }
    }

}}


@Composable

fun spinner(navController: NavController, context: Context, selectMobile1: String,selectMobile2: String,selectMobile3: String,selectMobile4: String) {
    var close by remember { mutableStateOf(false) }

//    var array1: Array<String> = arrayOf()
//    var array2: Array<String> = arrayOf()
//    var array3: Array<String> = arrayOf()
//    var array4: Array<String> = arrayOf()
   var datah= DatabaseHandler(context)
    var mobileList = datah.getMobileData()
//    mobileList.forEachIndexed { idx, item ->
////        if(idx != 1 ) {
//            item.name.also {
//                array1[idx] = it
//                array2[idx] = it
//                array3[idx] = it
//                array4[idx] = it
//
//            }
////        }
//    }
//    = arrayOf(
//        selectMobile1, "Samsung Galaxy S21 Ultra 5G",
//        "Samsung Galaxy M31s"
//    )
//    var array2: Array<String> = arrayOf(
//        selectMobile2, "Samsung Galaxy S21 Ultra 5G",
//        "Samsung Galaxy M31s"
//    )
//    var array3: Array<String> = arrayOf(
//        selectMobile3, "Samsung Galaxy S21 Ultra 5G",
//        "Samsung Galaxy M31s"
//    )
    var array4: Array<String> = arrayOf(
        selectMobile4, "Samsung Galaxy S21 Ultra 5G",
        "Samsung Galaxy M31s"
    )
    Spacer(modifier = Modifier.height(20.dp))
    var mobilename: String by remember {
        mutableStateOf(selectMobile1)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                close = !close
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = close,
            onDismissRequest = { close = false },
        )
        {
            mobileList.forEach { city ->
                DropdownMenuItem(onClick = {
                    close = false
                    mobilename = city.name
                }) {
                    Text(city.name)
                }
            }
        }

        // Back arrow here
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = mobilename, modifier = Modifier.weight(3f))
            Icon(modifier = Modifier.weight(1f),
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    var mobilename1: String by remember {
        mutableStateOf(selectMobile2)   }
    var close1 by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                close1 = !close1
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = close1,
            onDismissRequest = { close1 = false },
            modifier = Modifier.padding(start = 40.dp),

            )
        {
            mobileList.forEach { city ->
                DropdownMenuItem(onClick = {
                    close1 = false
                    mobilename = city.name
                }) {
                    Text(city.name)
                }
            }
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = mobilename1, modifier = Modifier.weight(3f))
            Icon(modifier = Modifier.weight(1f),
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }


    }

    Spacer(modifier = Modifier.height(20.dp))
    var mobilename2: String by remember {
        mutableStateOf(selectMobile3)
    }
    var close2 by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                close2 = !close2
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = close2,
            onDismissRequest = { close2 = false },
            modifier = Modifier.padding(start = 40.dp),

            )
        {
            mobileList.forEach { city ->
                DropdownMenuItem(onClick = {
                    close2 = false
                    mobilename2 = city.name
                }) {
                    Text(city.name)
                }
            }
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = mobilename2, modifier = Modifier.weight(3f))
            Icon(modifier = Modifier.weight(1f),
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }

    }
    Spacer(modifier = Modifier.height(20.dp))
    var mobilename3: String by remember {
        mutableStateOf(selectMobile4)
    }
    var close3 by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                close3 = !close3
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = close3,
            onDismissRequest = { close3 = false },
            modifier = Modifier.padding(start = 40.dp),
            )
        {
            mobileList.forEach { city ->
                DropdownMenuItem(onClick = {
                    close3 = false
                    mobilename3 = city.name
                }) {
                    Text(city.name)
                }
            }
        }
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = mobilename3, modifier = Modifier.weight(3f))
            Icon(modifier = Modifier.weight(1f),
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                navController.navigate("comparedetails/{$selectMobile1}/{$selectMobile2}/{$selectMobile3}/{$selectMobile4}")
            }, modifier = Modifier
                .fillMaxWidth()
                .height(40.dp), colors =
            ButtonDefaults.buttonColors(colorResource(id = R.color.red_700))
        )
        { Text("COMPARE", color = Color.White) }
    }

}
