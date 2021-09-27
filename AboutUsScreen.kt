package com.compare.show.screens

import android.widget.ThemedSpinnerAdapter
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
fun AbouUsScreen(openDrawer: () -> Unit,navController: NavController) {
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

                                    painterResource(id = R.drawable.ic_baseline_menu_24),
                                    contentDescription = "", modifier = Modifier
                                        .clickable(
                                            enabled = true,
                                            onClickLabel = "Clickable image",
                                            onClick = {
                                                openDrawer()
                                              //  navController.navigate("home")
                                            }
                                        )
                                )
                            }
                            Text(
                                text = "About Us",
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
                        contentColor = androidx.compose.ui.graphics.Color.White
                    )

                }
            )
            {

            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "About Page content.")
        }
    }
