package com.example.myjetpack1.Comparision

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.compare.show.DatabaseHandler
import com.compare.show.R
import com.example.jetpackcomposematerial.ui.components.SmallSpacer
import com.sqlitekotline.ProductAttributes


@Composable
fun MobileComparision(
    navController: NavController,
    context: Context,
    selectMobile1: String,
    selectMobile2: String,
    selectMobile3: String,
    selectMobile4: String
) {
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
                                    .width(40.dp)
                                    .height(40.dp)
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
                                text = "Compare",
                                color = Color.White,
                                modifier = Modifier.weight(4f),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "",
                                modifier = Modifier.weight(1f),
                            )


                        }

                    },
                    backgroundColor = colorResource(id = R.color.red_700),
                    contentColor = Color.White

                )
            }) {
            LazyRow() {
                item {
                    LazyColumn() {
                        item {
                            var datah= DatabaseHandler(context)
                            var mobileList = datah.getMobileData()
                            mobileList.forEachIndexed { idx, item ->
                                  ViewItem(item)
                            }

                        }
                    }
                    SmallSpacer()
                    LazyColumn() {
                        item {
                            var datah= DatabaseHandler(context)
                            var mobileList = datah.getMobileData()
                            mobileList.forEachIndexed { idx, item ->
                                ViewItem(item)
                            }
                        }
                    }
                    SmallSpacer()
                    LazyColumn() {
                        item {
                            var datah= DatabaseHandler(context)
                            var mobileList = datah.getMobileData()
                            mobileList.forEachIndexed { idx, item ->
                                ViewItem(item)
                            }
                        }
                    }
                    SmallSpacer()
                    LazyColumn() {
                        item {
                            var datah= DatabaseHandler(context)
                            var mobileList = datah.getMobileData()
                            mobileList.forEachIndexed { idx, item ->
                                ViewItem(item)
                            }
                        }
                    }
                    SmallSpacer()

                }
            }
        }
    }
}

@Composable
fun ViewItem(item: ProductAttributes) {
    Column(modifier = Modifier
        .padding(20.dp))
    {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(20.dp)
            .width(200.dp),
        backgroundColor = Color.White,
    ) {

                Text(
                    text = item.name,modifier = Modifier
                        .padding(10.dp)
                )


    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "CPU",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(20.dp)
            .width(200.dp),
        backgroundColor = Color.White,
    ) {
        Column {
            Text(text = item.ramTitle,modifier = Modifier
                .padding(10.dp))
            Divider()
            Text(
                text = item.ramDetails,
                modifier = Modifier
                    .padding(10.dp)
            )
        }

    }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Display",modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.displayTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text = item.displayDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Main Camera",modifier = Modifier
                    .padding(10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .width(200.dp),
                backgroundColor = Color.White,
            ) {
                Column {
                    Text(
                        text = item.mainCameraTitle, modifier = Modifier
                            .padding(10.dp)
                    )
                    Divider()
                    Text(
                        text = item.mainCameraDiscription, modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Front Camera",modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.frontCameraTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text = item.frontCameraDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Gaming (GPU)"
                    ,modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.gamingGpuTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text = item.gamingGpuDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Network Speed"
            ,modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.networkSpeedTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text = item.networkSpeedDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }

    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Body Storage Sensors"
        ,modifier = Modifier
            .padding(10.dp),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(20.dp)
            .width(200.dp),
        backgroundColor = Color.White,
    ) {
        Column {
            Text(
                text = item.bodyStroageTitle, modifier = Modifier
                    .padding(10.dp)
            )
            Divider()
            Text(
                text = item.bodyStroageDiscription, modifier = Modifier
                    .padding(10.dp)
            )
        }
    }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Operating System"
            ,modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.operatingSystemTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text = item.operatingSystemDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Network Frequency"
            ,modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.networkFrequencyTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text =  item.networkFrequencyDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Company Accessory"
            ,modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.companyAccessoryTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text = item.companyAccessoryDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Conclusion"
            ,modifier = Modifier
                .padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            backgroundColor = Color.White,
        ) {
            Column {
                Text(
                    text = item.conclusionTitle, modifier = Modifier
                        .padding(10.dp)
                )
                Divider()
                Text(
                    text =  item.conclusionDiscription, modifier = Modifier
                        .padding(10.dp)
                )
            }
        }

}
    Spacer(modifier = Modifier.height(10.dp))
}