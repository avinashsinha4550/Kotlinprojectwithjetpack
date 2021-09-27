package com.compare.show.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.compare.show.R
import com.compare.show.TopBar

@Composable
fun TermsAndCondition(openDrawer: () -> Unit,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier
//                                    .background(color = Color.Red)
                                .fillMaxWidth()
                                .padding(5.dp)
                                .height(52.dp)
                            ) {
                                Image(

                                painterResource(id = R.drawable.ic_baseline_menu_24),
                                contentDescription = "", modifier = Modifier.padding(top = 10.dp)
                                    .clickable(
                                        enabled = true,
                                        onClickLabel = "Clickable image",
                                        onClick = {
                                            navController.navigate("home")

                                        }
                                    )
                            )
                            Text(
                                modifier = Modifier
                                    .weight(4f )
                                ,
                                textAlign = TextAlign.Center,
                                text = "Terms and Condition",
                                color = androidx.compose.ui.graphics.Color.White,
                            )
                        }

                        Spacer(modifier = Modifier.width(180.dp))

                    },
                    backgroundColor = colorResource(id = R.color.red_700),
                    contentColor = androidx.compose.ui.graphics.Color.White
                )

            })
        {

        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Terms and conditions Page content.")
    }
}
