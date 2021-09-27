package com.compare.show.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate

import com.compare.show.R
import com.example.jetpackcomposematerial.ui.components.SmallSpacer


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import com.compare.show.theme.JetpackComposeMaterialTheme

@SuppressLint("RestrictedApi")
@Composable
fun FilterScreen(navController: NavController, context: Context) {
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
                                text = "Filter",
                                color = Color.White,
                                modifier = Modifier.weight(2f),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .padding(top = 10.dp),
                                textAlign = TextAlign.End

                            )

                        }

                    },
                    backgroundColor = colorResource(id = R.color.red_700),
                    contentColor = Color.White
                )
            }) {

            Column {
                LazyRow()
                {
                    item {
                        BrandDropDown()
                        SmallSpacer()
                        RamDropDown()
                        SmallSpacer()
                        StorageDropDown()
                        SmallSpacer()
                        DisplayDropDown()
                        SmallSpacer()
                        BatteryDropDown()
                    }

                }



                Column(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth()
                ) {
                    FGreo(navController)
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = 20.dp),
                        verticalArrangement =
                        Arrangement.Bottom
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(top = 100.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,


                            ) {
                            Row() {
                                Buttonclear()
                                ButtonShow(navController)
                            }


                        }
                    }

//                  Butt
//            })

                }
            }
        }


    }
//
}

@Composable
fun BrandDropDown() {
    var closeBrand by remember { mutableStateOf(false) }

    var arrBrand: Array<String> = arrayOf("Brand", "Realme", "Samsung", "Intel", "Touch", "Apple")
    Spacer(modifier = Modifier.height(20.dp))
    var selectBrand: String by remember {
        mutableStateOf(arrBrand[0])
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 5.dp)
            .clickable {
                closeBrand = !closeBrand
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = closeBrand,
            onDismissRequest = { closeBrand = false },
        )
        {
            arrBrand.forEach { item ->
                DropdownMenuItem(onClick = {
                    closeBrand = false
                    selectBrand = item
                }) {
                    Text(item)
                }
            }
        }

        // Back arrow here
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = selectBrand)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }
}

@Composable
fun RamDropDown() {
    var closeRam by remember { mutableStateOf(false) }

    var arrRam: Array<String> = arrayOf("Ram", "2 GB", "3 GB", "4 GB", "8 GB", "16 GB", "32 GB")
    Spacer(modifier = Modifier.height(20.dp))
    var selectRam: String by remember {
        mutableStateOf(arrRam[0])
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 5.dp)
            .clickable {
                closeRam = !closeRam
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = closeRam,
            onDismissRequest = { closeRam = false },
        )
        {
            arrRam.forEach { item ->
                DropdownMenuItem(onClick = {
                    closeRam = false
                    selectRam = item
                }) {
                    Text(item)
                }
            }
        }

        // Back arrow here
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = selectRam)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }
}

@Composable
fun StorageDropDown() {
    var closeStorage by remember { mutableStateOf(false) }

    var arrStorage: Array<String> =
        arrayOf("Storage", "2 GB", "3 GB", "4 GB", "8 GB", "16 GB", "32 GB")
    Spacer(modifier = Modifier.height(20.dp))
    var selectStorage: String by remember {
        mutableStateOf(arrStorage[0])
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 5.dp)
            .clickable {
                closeStorage = !closeStorage
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = closeStorage,
            onDismissRequest = { closeStorage = false },
        )
        {
            arrStorage.forEach { item ->
                DropdownMenuItem(onClick = {
                    closeStorage = false
                    selectStorage = item
                }) {
                    Text(item)
                }
            }
        }

        // Back arrow here
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = selectStorage)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }
}

@Composable
fun DisplayDropDown() {
    var closeDisplay by remember { mutableStateOf(false) }

    var arrDisplay: Array<String> = arrayOf("Display", "display1", "display2", "display3")
    Spacer(modifier = Modifier.height(20.dp))
    var selectDisplay: String by remember {
        mutableStateOf(arrDisplay[0])
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 5.dp)
            .clickable {
                closeDisplay = !closeDisplay
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = closeDisplay,
            onDismissRequest = { closeDisplay = false },
        )
        {
            arrDisplay.forEach { item ->
                DropdownMenuItem(onClick = {
                    closeDisplay = false
                    selectDisplay = item
                }) {
                    Text(item)
                }
            }
        }

        // Back arrow here
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = selectDisplay)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }
}

@Composable
fun BatteryDropDown() {
    var closeBattery by remember { mutableStateOf(false) }

    var arrBattery: Array<String> = arrayOf("Battery", "Battery1", "Battery2", "Battery3")
    Spacer(modifier = Modifier.height(20.dp))
    var selectBattery: String by remember {
        mutableStateOf(arrBattery[0])
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 5.dp)
            .clickable {
                closeBattery = !closeBattery
            },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        DropdownMenu(
            expanded = closeBattery,
            onDismissRequest = { closeBattery = false },
        )
        {
            arrBattery.forEach { item ->
                DropdownMenuItem(onClick = {
                    closeBattery = false
                    selectBattery = item
                }) {
                    Text(item)
                }
            }
        }

        // Back arrow here
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = selectBattery)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = ""
            )
        }
    }
}



@Composable
fun ButtonPrototyping() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )

    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Prototyping", color = Color.Blue)
            } else {
                Text("Prototyping", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonSketch() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Sketch", color = Color.Blue)
            } else {
                Text("Sketch", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonProduct() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Product", color = Color.Blue)
            } else {
                Text("Product", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonFigma() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Figma", color = Color.Blue)
            } else {
                Text("Figma", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun ButtonUIkit() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "UIkit", color = Color.Blue)
            } else {
                Text("UIkit", color = colors.primary)
            }
        }
    }


}

@Composable
fun ButtonuserExperince() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "userExperince", color = Color.Blue)
            } else {
                Text("userExperince", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonWireframing() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Wireframing", color = Color.Blue)
            } else {
                Text("Wireframing", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonXD() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "XD", color = Color.Blue)
            } else {
                Text("XD", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonLeadership() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Leadership", color = Color.Blue)
            } else {
                Text("Leadership", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonUIdesign() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "UI design", color = Color.Blue)
            } else {
                Text("UI design", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
}

@Composable
fun ButtonReactJS() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "ReactJS", color = Color.Blue)
            } else {
                Text("ReactJS", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))

}

@Composable
fun ButtonPhotoShop() {
    var selected = remember { mutableStateOf(true) }
    Button(
        onClick = {
            selected.value = !selected.value
        },
        border = BorderStroke(
            1.dp, if (selected.value)
                Color.Black
            else
                Color.Red
        ),
        shape = RoundedCornerShape(50),
        colors = buttonColors(
            backgroundColor = if (selected.value)
                Color.White
            else
                Color.White
        )

    )
    {
        Row {

            if (selected.value == false) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

            }
            Spacer(modifier = Modifier.width(1.dp))
            if (selected.value == false) {
                Text(text = "Photoshop", color = Color.Blue)
            } else {
                Text("Photoshop", color = colors.primary)
            }
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))


}

@Composable
fun Buttonclear() {
    var buttoncolorchange = remember { mutableStateOf(true) }
    Button(
        onClick = {
            buttoncolorchange.value = !buttoncolorchange.value
        }, modifier = Modifier
            .height(60.dp)
            .padding(start = 20.dp),
        border = BorderStroke(2.dp, Color.Red),
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.buttonColors(
            backgroundColor =
            if (buttoncolorchange.value)
                Color.White
            else
                JetpackComposeMaterialTheme.colors.primary
        )
    )
    {
        if(buttoncolorchange.value) {
            Text(text = "Clear All)", color= JetpackComposeMaterialTheme.colors.primary)
        }
        else {
            Text(text ="Clear All", color = Color.White)
        }

    }
    Spacer(
        modifier = Modifier
            .width(60.dp)

    )
}
@Composable
fun ButtonShow(navController: NavController) {
    var buttoncolorchange1 = remember { mutableStateOf(true) }
    Button(
        onClick = {
            //navController.navigate("comparelist")
            buttoncolorchange1.value = !buttoncolorchange1.value
        }, modifier = Modifier

            .height(60.dp),
        border = BorderStroke(2.dp, Color.Red),
        shape = RoundedCornerShape(30),
        colors =ButtonDefaults.buttonColors(
            backgroundColor =
            if (buttoncolorchange1.value)
                Color.White
            else
                JetpackComposeMaterialTheme.colors.primary
        )
    )
    {
        if(buttoncolorchange1.value) {
            Text(text = "Show(25)", color= colors.primary)
        }
        else {
            Text(text ="Show(25)", color = Color.White)
        }
    }
}
//


@Composable
fun FGreo(navController: NavController) {
    val words = ("Lorem")
        .split(" ")

    ChipVerticalGrid(
        spacing = 7.dp,
        modifier = Modifier
            .padding(10.dp)
    ) {
        words.forEach { word ->
//            Text(
//                word,
//                modifier = Modifier
//                    .background(color = Color.Gray, shape = CircleShape)
//                    .padding(vertical = 3.dp, horizontal = 5.dp)
//            )
            ButtonPrototyping()
            ButtonSketch()
            ButtonProduct()
            ButtonFigma()
            ButtonUIkit()
            ButtonuserExperince()
            ButtonWireframing()
            ButtonXD()
            ButtonLeadership()
            ButtonUIdesign()
            ButtonReactJS()
            ButtonPhotoShop()
            AdditionalRow()
        }
    }

}

@Composable
fun ChipVerticalGrid(
    modifier: Modifier = Modifier,
    spacing: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        var currentRow = 0
        var currentOrigin = IntOffset.Zero
        val spacingValue = spacing.toPx().toInt()
        val placeables = measurables.map { measurable ->
            val placeable = measurable.measure(constraints)

            if (currentOrigin.x > 0f && currentOrigin.x + placeable.width > constraints.maxWidth) {
                currentRow += 1
                currentOrigin =
                    currentOrigin.copy(x = 0, y = currentOrigin.y + placeable.height + spacingValue)
            }

            placeable to currentOrigin.also {
                currentOrigin = it.copy(x = it.x + placeable.width + spacingValue)
            }
        }

        layout(
            width = constraints.maxWidth,
            height = placeables.lastOrNull()?.run { first.height + second.y } ?: 0
        ) {
            placeables.forEach {
                val (placeable, origin) = it
                placeable.place(origin.x, origin.y)
            }
        }
    }
}
    @Composable
    fun AdditionalRow() {
        Row(modifier = Modifier.height(20.dp).fillMaxWidth())
        {

        }
    }
