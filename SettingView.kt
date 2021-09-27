package com.example.jetpackcomposematerial.ui.components

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color.WHITE
import android.graphics.Color.red
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.foundation.ScrollerPosition
import androidx.ui.foundation.VerticalScroller
import com.compare.show.MainRoot
import com.compare.show.R

import com.example.jetpackcomposematerial.ui.components.ThemeType.*
 import java.time.format.TextStyle

@Composable
fun SettingView(
    modifier: Modifier = Modifier,
    darkMode: MutableState<Boolean>,
    themeType: MutableState<ThemeType>,
    context: Context
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        LazyColumn( ) {
            item {
                Column {
                    Text("Light Theme")
                    Divider()
                    SmallSpacer()
                    ThemePickRadioGroup(themeType,context)
                    SmallSpacer()
                    Text("Background of Light Theme is bit Darker Shade of White")
                    Divider()
                    Spacer(modifier = Modifier.height(50.dp))
                    DarkModeCheckBox(darkMode)
                    SmallSpacer()
                    ThemePickRadioGroup(themeType,context)
                    SmallSpacer()
                    Text("Background of Darl Theme is bit Darker Shade of Black")
                    LargeSpacer()
                }
            }
        }
    }
}

@Composable
fun DarkModeCheckBox(darkMode: MutableState<Boolean>) {
    Row {
        Checkbox(
            checked = darkMode.value,
            onCheckedChange = { checked -> darkMode.value = checked },
        )
        SmallSpacer()
        Text(text = "Dark Themes Preview")
    }
}

@Composable
fun ThemePickRadioGroup(themeType: MutableState<ThemeType>,context: Context) {

    Column {
//        Text(text = stringResource(R.string.theme_select))

        LazyRow(
            modifier = Modifier.padding(10.dp)
        ) {
            item {
                Card() {
                    Box(
                        Modifier
                            .height(240.dp)
                            .width(200.dp)

                    ) {

                        Column() {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .background(Color.Red)
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(30.dp),
                                    painter = painterResource(R.drawable.pinkface),
                                    contentDescription = "App icon",
                                    tint = Color.White
                                )
//                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    text = "Red",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .size(30.dp),
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row() {
                                Text(
                                    text = "Simple Title",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Red,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row() {
                                Text(
                                    text = "Sample Text",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            TabRowDefaults.Divider(color = Color.Black, thickness = 1.dp)

                            val mRememberObserver = remember { mutableStateOf("") }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)

                                    .clickable {
                                        themeType.value = RED
                                    }) {
                                Text(
                                    text = "Select",
                                    color = Color.Red,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.width(50.dp))
                                RadioButton(
                                    colors = RadioButtonDefaults.colors(
                                        disabledColor = Color.Red,
                                        unselectedColor = Color.Red,
                                        selectedColor = Color.Red
                                    ), selected = themeType.value == RED, onClick = {
                                        themeType.value = RED

                                        val sharedPrefFile = "kotlinsharedpreference"
                                        val sharedPreferences: SharedPreferences =context.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
                                        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
                                        editor.putString("lang","IN")
                                        editor.putString("theme", "RED")
                                        editor.apply()
                                        editor.commit()
                                    })


                                //   }


                            }

                        }
                    }

                }
                TinySpacer()
            }
            item {
                Card() {
                    Box(
                        Modifier
                            .height(240.dp)
                            .width(200.dp)

                    ) {
                        Column() {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement =  Arrangement.Center,
                                modifier = Modifier
                                    .background(Color.Blue)
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(30.dp),
                                    painter = painterResource(R.drawable.pinkface),
                                    contentDescription = "App icon",
                                    tint = Color.White
                                )
//                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    text = "Pink", modifier = Modifier
                                        .fillMaxWidth()
                                        .size(30.dp),
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row() {
                                Text(
                                    text = "Simple Title",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Blue,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row() {
                                Text(
                                    text = "Sample Text",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            TabRowDefaults.Divider(color = Color.Black, thickness = 1.dp)

                            val mRememberObserver = remember { mutableStateOf("") }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement =  Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)

                                    .clickable {
                                        themeType.value = BLUE
                                    }) {
                                Text(text = "Select",textAlign = TextAlign.Center,color=Color.Blue,
                                    fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(50.dp))
                                RadioButton(colors = RadioButtonDefaults.colors(disabledColor = Color.Blue,unselectedColor = Color.Blue,selectedColor = Color.Blue),selected = themeType.value == BLUE, onClick = {
                                    themeType.value = BLUE
//                                    var share=MainRoot()
//                                    var SharedPreferences=share.
//                                     val editor: SharedPreferences.Editor =  sharedPreferences.edit()
//                                    editor.putString("lang","IN")
//                                    editor.putString("theme", "BLUE")
//                                    editor.apply()
//                                    editor.commit()
                                })


                                //   }


                            }


                        }
                    }
                }
                TinySpacer()
            }
            item {
                Card() {
                    Box(
                        Modifier
                            .height(240.dp)
                            .width(200.dp)

                    ) {
                        Column() {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement =  Arrangement.Center,
                                modifier = Modifier
                                    .background(Color.Yellow)
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(30.dp),
                                    painter = painterResource(R.drawable.pinkface),
                                    contentDescription = "App icon",
                                    tint = Color.White
                                )
//                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    text = "Yellow", modifier = Modifier
                                        .fillMaxWidth()
                                        .size(30.dp),
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row() {
                                Text(
                                    text = "Simple Title",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Yellow,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row() {
                                Text(
                                    text = "Sample Text",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            TabRowDefaults.Divider(color = Color.Black, thickness = 1.dp)

                            val mRememberObserver = remember { mutableStateOf("") }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement =  Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)

                                    .clickable {
                                        themeType.value = YELLOW
                                    }) {
                                Text(text = "Select",color=Color.Yellow,textAlign = TextAlign.Center,
                                    fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(50.dp))
                                RadioButton(colors = RadioButtonDefaults.colors(disabledColor = Color.Yellow,unselectedColor = Color.Yellow,selectedColor = Color.Yellow),selected = themeType.value == YELLOW, onClick = {
                                    themeType.value = YELLOW

//                                    val sharedPrefFile = "kotlinsharedpreference"
//                                    val sharedPreferences: SharedPreferences =this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
//                                    val editor: SharedPreferences.Editor =  sharedPreferences.edit()
//                                    editor.putString("lang","IN")
//                                    editor.putString("theme", "YELLOW")
//                                    editor.apply()
//                                    editor.commit()
                                })


                                //   }


                            }


                        }
                    }
                }
                TinySpacer()
            }
            item {
                Card() {
                    Box(
                        Modifier
                            .height(240.dp)
                            .width(200.dp)

                    ) {
                        Column() {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement =  Arrangement.Center,
                                modifier = Modifier
                                    .background(Color.Magenta)
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(30.dp),
                                    painter = painterResource(R.drawable.pinkface),
                                    contentDescription = "App icon",
                                    tint = Color.White
                                )
//                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    text = "Pink", modifier = Modifier
                                        .fillMaxWidth()
                                        .size(30.dp),
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row() {
                                Text(
                                    text = "Simple Title",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Magenta,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Row() {
                                Text(
                                    text = "Sample Text",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            TabRowDefaults.Divider(color = Color.Black, thickness = 1.dp)

                            val mRememberObserver = remember { mutableStateOf("") }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement =  Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .height(40.dp)

                                    .clickable {
                                        themeType.value = PINK
                                    }) {
                                Text(text = "Select",color=Color.Magenta,textAlign = TextAlign.Center,
                                    fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(50.dp))
                                RadioButton(colors = RadioButtonDefaults.colors(disabledColor = Color.Magenta,unselectedColor = Color.Magenta,selectedColor = Color.Magenta),selected = themeType.value == PINK, onClick = {
                                    themeType.value = PINK
                                })


                                //   }


                            }


                        }
                    }
                }
                TinySpacer()
            }

        }
    }
}

enum class ThemeType  {
    RED,
    PURPLE,
    YELLOW,
    BLUE,
    PINK
}
