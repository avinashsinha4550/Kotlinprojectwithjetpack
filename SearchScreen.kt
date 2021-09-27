package com.compare.show.screens

import android.annotation.SuppressLint


import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.compare.show.DatabaseHandler
import com.compare.show.R
import com.compare.show.theme.JetpackComposeMaterialTheme
import com.example.jetpackcomposematerial.ui.components.LargeSpacer
import com.example.jetpackcomposematerial.ui.components.SmallSpacer
 import com.sqlitekotline.ProductAttributes

//
@ExperimentalStdlibApi
@SuppressLint("RestrictedApi")
@Composable
fun SearchScreen(navController: NavController, context: Context) {
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
                                text = "Search Product",
                                color = androidx.compose.ui.graphics.Color.White,
                                modifier = Modifier.weight(2f),
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = "",
                                color = androidx.compose.ui.graphics.Color.White,
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center
                            )

                        }

                    },
                    backgroundColor = androidx.compose.ui.res.colorResource(id = R.color.red_700),
                    contentColor = androidx.compose.ui.graphics.Color.White
                )

            }
        )
        {
            val textState = remember { mutableStateOf(TextFieldValue("")) }
            Column(
                modifier = Modifier.padding(20.dp).background(Color.White),
            ){


                    SearchView(textState)

                MobileList(context,navController = navController, state = textState)
            }
        }
    }

//        )
//    }
}
@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    Card(
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier

//            .border(BorderStroke(1.dp,color = Color.Gray))
        ) {
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            modifier = Modifier.fillMaxWidth()
                .background(Color.White),
            textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {
                if (state.value != TextFieldValue("")) {
                    IconButton(
                        onClick = {
                            state.value =
                                TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(15.dp)
                                .size(24.dp)
                        )
                    }
                }
            },
            singleLine = true,
            shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
            colors = TextFieldDefaults.textFieldColors(

//            textColor = androidx.compose.ui.graphics.Color.Black,
//            cursorColor = androidx.compose.ui.graphics.Color.Black,
//            leadingIconColor = androidx.compose.ui.graphics.Color.Black,
//            trailingIconColor = androidx.compose.ui.graphics.Color.Black,
//            backgroundColor = androidx.compose.ui.graphics.Color.White,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            disabledIndicatorColor = androidx.compose.ui.graphics.Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(textState)
}

@ExperimentalStdlibApi
@Composable
fun MobileList(context:Context,navController: NavController, state: MutableState<TextFieldValue>) {
//    val mobileList = getMobileData1()
//    var listState = rememberLazyListState()
//    val selectMobilelist = mutableListOf<SelectMobileListModel>()

//    var numberOfMobileCount by remember { mutableStateOf(0) }
    var datah= DatabaseHandler(context)
    var mobileList = datah.getMobileData()

    var filteredMobile: MutableList<ProductAttributes>//ArrayList<MobileListModel>

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        val searchedText = state.value.text

        filteredMobile =  if(searchedText.isEmpty()) {
            mobileList
            }
            else {
            var list = mutableListOf<ProductAttributes>()
                mobileList.forEach { item ->
                if (item.name.lowercase()
                        .contains(searchedText.lowercase())
                ) {

                    list.add(
                        ProductAttributes(
                            id = item.id,
                            name = item.name,
                            descripations = item.descripations,
                            frantImage = item.frantImage,
                            backImage = item.backImage,
                            ramTitle = item.ramTitle,
                            ramDetails = item.ramDetails,
                            ramEg = item.ramEg,
                            displayTitle = item.displayTitle,
                            displayDiscription = item.displayDiscription,
                            proccesor = item.proccesor,
                            mainCameraTitle = item.mainCameraTitle,
                            mainCameraDiscription = item.mainCameraDiscription,
                            frontCameraTitle = item.frontCameraTitle,
                            frontCameraDiscription = item.frontCameraDiscription,
                            gamingGpuTitle = item.gamingGpuTitle,
                            gamingGpuDiscription = item.gamingGpuDiscription,
                            networkSpeedTitle = item.networkSpeedTitle,
                            networkSpeedDiscription = item.networkSpeedDiscription,
                            bodyStroageTitle = item.bodyStroageTitle,
                            bodyStroageDiscription = item.bodyStroageDiscription,
                            operatingSystemTitle = item.operatingSystemTitle,
                            operatingSystemDiscription = item.operatingSystemDiscription,
                            networkFrequencyTitle = item.networkFrequencyTitle,
                            networkFrequencyDiscription = item.networkFrequencyDiscription,
                            companyAccessoryTitle = item.companyAccessoryTitle,
                            companyAccessoryDiscription = item.companyAccessoryDiscription,
                            conclusionTitle = item.conclusionTitle,
                            conclusionDiscription = item.conclusionDiscription,
                            ssd_space = item.ssd_space,
                            water_proff = item.water_proff,
                            price = item.price,
                            check = item.check
                        )
                    )
                }

            }
            list
              }
        filteredMobile

        items(filteredMobile) { filteredMobile ->
            MobileListItem(
               navController, MobileText = filteredMobile
            ) { selectedMobile ->
                navController.navigate("mobiledetails/{${filteredMobile.id}}")
                // navController.navigate("details/$selectedMobile") {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
//                        popUpTo("main") {
//                            saveState = true
//                        }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                // launchSingleTop = true
                // Restore state when reselecting a previously selected item
                //   restoreState = true
                // }
            }
        }
    }
}

@ExperimentalStdlibApi

@Composable
fun MobileListPreview(context: Context) {
    val navController = rememberNavController()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    MobileList(context ,navController = navController, state = textState)
}

@Composable
fun MobileListItem(navController:NavController, MobileText: ProductAttributes, onItemClick: (String) -> Unit) {
//    Row(
//        modifier = Modifier
//            .clickable(onClick = { onItemClick(MobileText) })
//            .background(androidx.compose.ui.graphics.Color.Black)
//            .height(57.dp)
//            .fillMaxWidth()
//            .padding(PaddingValues(8.dp, 16.dp))
//    ) {
//        Text(text = MobileText, fontSize = 18.sp, color = androidx.compose.ui.graphics.Color.White)
//    }
    Box(modifier = Modifier.padding(10.dp)) {
            Column() {

                Text(
                    fontSize =20.sp,
                    color= JetpackComposeMaterialTheme.colors.primary,
                    text = MobileText.name, modifier =Modifier.padding(
                        top = 20.dp,bottom = 2.dp
                    )

                )

                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.clickable {
                        navController.navigate("mobiledetails/{${MobileText.id}}")
                    }
                ) {
                    Column {
                        Image(painter = painterResource(id = R.drawable.mobile), contentDescription = "false",modifier =
                        Modifier.size(70.dp))
                        SmallSpacer()
                        Image(painter = painterResource(id = R.drawable.mobileback), contentDescription = "false",modifier =
                        Modifier.size(70.dp))
                    }

                    Column {
                        Text(
                            text = "Ram : ${MobileText.ramTitle}",
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 22.dp
                            ),
                            fontSize = 15.sp
                        )
                        Text(
                            text = MobileText.proccesor!!,
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 22.dp
                            ),
                            fontSize = 15.sp
                        )
                        Text(
                            text = "Camera:- Front {${MobileText.frontCameraTitle}} , Main {${MobileText.mainCameraTitle}}",
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 22.dp
                            ),
                            fontSize = 15.sp
                        )

                        Text(
                            text = MobileText.water_proff,
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 22.dp
                            ),
                            fontSize = 15.sp
                        )

                        Text(
                            text = MobileText.price,
                            modifier = Modifier.padding(
                                top = 4.dp,
                                start = 22.dp
                            ),
                            fontSize = 15.sp
                        )
                     LargeSpacer()

                    }


                }

            }
        Divider()
        }
}

@Preview(showBackground = true)
@Composable
fun MobileListItemPreview() {
   // MobileListItem(MobileText = "United States 🇺🇸") { }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "App name", fontSize = 18.sp) },
        backgroundColor = androidx.compose.ui.graphics.Color.Black,
        contentColor =androidx.compose.ui.graphics.Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

 
//fun getMobileData(): MutableList<MobileListModel> {
//    val list = mutableListOf<MobileListModel>()
//    list.add(
//        MobileListModel(
//            mobileId = 1,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung1",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    list.add(
//        MobileListModel(
//            mobileId = 2,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung2",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    list.add(
//        MobileListModel(
//            mobileId = 3,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung3",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    list.add(
//        MobileListModel(
//            mobileId = 4,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung4",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    list.add(
//        MobileListModel(
//            mobileId = 5,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung5",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    list.add(
//        MobileListModel(
//            mobileId = 6,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung6",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    list.add(
//        MobileListModel(
//            mobileId = 7,
//            frantImage = R.drawable.mobile,
//            backImage = R.drawable.mobileback,
//            mobileName = "Samsung7",
//            RAM = "12GB",
//            Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",
//            Front_camera = "20 MP front camera",
//            Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",
//            Price = "RS 10000",
//            Check = false
//        )
//    )
//    return list
//}

//fun getListOfMobile(): ArrayList<String> {
//    val isoMobileCodes = Locale.getISOMobile()
//    val MobileListWithEmojis = ArrayList<String>()
//    for (MobileCode in isoMobileCodes) {
//        val locale = Locale("", MobileCode)
//        val MobileName = locale.displayMobile
//        val flagOffset = 0x1F1E6
//        val asciiOffset = 0x41
//        val firstChar = Character.codePointAt(MobileCode, 0) - asciiOffset + flagOffset
//        val secondChar = Character.codePointAt(MobileCode, 1) - asciiOffset + flagOffset
//        val flag =
//            (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
//        MobileListWithEmojis.add("$MobileName $flag")
//    }
//    return MobileListWithEmojis
//}