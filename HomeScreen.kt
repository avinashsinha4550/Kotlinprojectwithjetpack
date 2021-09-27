package com.compare.show.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

import com.compare.show.R

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.Model
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.ui.foundation.Clickable
//import coil.compose.rememberImagePainter
import com.compare.show.DatabaseHandler
import com.compare.show.model.SelectMobileListModel
import com.compare.show.theme.JetpackComposeMaterialTheme
import com.example.jetpackcomposematerial.ui.components.LargeSpacer
import com.example.jetpackcomposematerial.ui.components.SmallSpacer

@ExperimentalAnimationApi
@Composable
fun HomeScreen(openDrawer: () -> Unit, navController: NavController, context: Context) {

       Column(modifier = Modifier.fillMaxSize()) {

        MyPageContent(openDrawer = { openDrawer() }, navController, context)

    }
}

@ExperimentalAnimationApi
@Composable
fun MyPageContent(openDrawer: () -> Unit, navController: NavController, context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(


                {
                    Row(
                        modifier = Modifier
                            .background(color = JetpackComposeMaterialTheme.colors.primary)
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
                                        }
                                    )
                            )
                        }

                        Text(
                            modifier = Modifier
                                .weight(2f)
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            text = "Home",
                            color = androidx.compose.ui.graphics.Color.White,
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.weight(1f),

                            ) {
                            IconButton(

                                onClick = {
                                    navController.navigate("search")
                                }) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_baseline_search_24),
                                    contentDescription = "App icon",
                                    tint = androidx.compose.ui.graphics.Color.White
                                )
                            }
//                            IconButton(
//
//                                onClick = {
//                                    navController.navigate("filter")
//                                }) {
//                                Icon(
//                                    painter = painterResource(R.drawable.ic_baseline_filter_alt_24),
//                                    contentDescription = "App icon",
//                                    tint = androidx.compose.ui.graphics.Color.White
//                                )
//                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                },
                backgroundColor = JetpackComposeMaterialTheme.colors.primary,
                contentColor = androidx.compose.ui.graphics.Color.White
            )

        })
    {
        var listState = rememberLazyListState()
        val selectMobilelist = mutableListOf<SelectMobileListModel>()

        var numberOfMobileCount by remember { mutableStateOf(0) }
        var datah=DatabaseHandler(context)
        var mobileList = datah.getMobileData()

        Box {
            //   Text(offset.toString())
            LazyColumn(
                // state =  listState
            ) {
                itemsIndexed(mobileList) { index, item ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .clickable {
                                       navController.navigate("mobiledetails/{${item.id}}")
                            },

                        backgroundColor = MaterialTheme.colors.surface,

                        ) {
                        Box(modifier = Modifier.padding(10.dp)) {
                            Column() {
                                Text(
                                    fontSize = 20.sp,
                                    color = Color.Blue,
                                    text = item.name, modifier = Modifier.padding(
                                        top = 20.dp, bottom = 2.dp
                                    )

                                )
                                TabRowDefaults.Divider()
                                Spacer(modifier = Modifier.padding(10.dp))
                                Row() {
                                    Column {
                                        Image(
                                            painter = painterResource(id = R.drawable.mobile),
                                            contentDescription = "",
                                            modifier =
                                            Modifier.size(70.dp)
                                        )
                                        SmallSpacer()
                                        Image(
                                            painter = painterResource(id = R.drawable.mobileback),
                                            contentDescription = "",
                                            modifier =
                                            Modifier.size(70.dp)
                                        )
                                    }

                                    Column {
                                        Text(
                                            text = "Ram "+item.ramTitle,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        Text(
                                            text = item.proccesor,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        Text(
                                            text = "Camera Main "+item.mainCameraTitle,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        Text(
                                            text = "Camera Front "+item.frontCameraTitle,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        Text(
                                            text = "Water Proff "+item.water_proff!!,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        Text(
                                            text = "SSD Space"+item.ssd_space!!,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        Text(
                                            text = "INR "+item.price!!,
                                            modifier = Modifier.padding(
                                                top = 4.dp,
                                                start = 22.dp
                                            ),
                                            fontSize = 15.sp
                                        )
                                        LargeSpacer()

                                    }


                                }
                                Column() {

                                    TabRowDefaults.Divider()

                                    Row(modifier = Modifier.padding(10.dp)) {

                                        var buttonchange: Boolean = true
                                        Text(
                                            fontSize = 16.sp,
                                            text = "ADD to Compare",
                                            modifier = androidx.compose.ui.Modifier.padding(
                                                top = 4.dp
                                            )
                                        )
                                        val isChecked =
                                            remember { mutableStateOf(mobileList[index].check) }
                                        Checkbox(

                                            modifier = Modifier.padding(
                                                top = 4.dp, start = 150.dp).background(color = JetpackComposeMaterialTheme.colors.onPrimary),
                                            colors=CheckboxDefaults.colors(JetpackComposeMaterialTheme.colors.primary),

                                            checked = isChecked.value,
                                            onCheckedChange = {
                                                if (selectMobilelist.size == 4) {
                                                    if (mobileList[index].check == true) {
                                                        isChecked.value = it
                                                        Log.e(
                                                            "MINUS",
                                                            "" + item.id!!.toString()
                                                        )
                                                        mobileList = mobileList.toMutableList().also {
                                                            mobileList[index].check =
                                                                false
                                                        }
                                                        selectMobilelist.removeAt(index)
                                                        numberOfMobileCount = selectMobilelist.size
                                                    }else {
//                                                        toast.maketext(
//                                                            this@LazyColumn,
//                                                            "Sorry you are already select 4 mobile ",
//                                                            toast.length_short
//                                                        ).show()
                                                    }
                                                    numberOfMobileCount = selectMobilelist.size
                                                } else {
                                                    isChecked.value = it
                                                    mobileList = mobileList.toMutableList().also {
                                                        mobileList[index].check = isChecked.value
                                                        // selectItem(mobileList[index].Check,item.mobileId!!,index)
                                                        if (mobileList[index].check == true) {
                                                            selectMobilelist.add(
                                                                SelectMobileListModel(
                                                                    mobileId = item.id!!,
                                                                    mobileName = item.name!!
                                                                )
                                                            )
                                                            numberOfMobileCount = selectMobilelist.size
                                                        } else {
                                                            if(selectMobilelist.size > 0) {
                                                                Log.e(
                                                                    "MINUS",
                                                                    "" + item.id!!.toString()
                                                                )

                                                                  //  if (mobileList[index].Check == true) {
                                                                        selectMobilelist.removeAt(
                                                                            index
                                                                        )
                                                                   // }


                                                            }
                                                            numberOfMobileCount = selectMobilelist.size
                                                        }


                                                        Log.e(
                                                            "Array size",
                                                            "" + selectMobilelist.toString()
                                                        )

                                                    }

                                                }
                                                Log.e(
                                                    "Array size",
                                                    "" + selectMobilelist.toString()
                                                )
                                            }
                                        )

                                    }

                                }
                            }

                        }

                    }
                }
            }//listState.firstVisibleItemIndex.toDouble()
//        ExtendedFloatingActionButtonContent(navController, 1.0,selectMobilelist)
            var btnSize = listState.firstVisibleItemIndex + 1
            Box( modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                ExtendedFloatingActionButton(
                    shape = RoundedCornerShape(topStart = 20.dp),
                    text = {
                        Row {
                            Text(if (btnSize > 0) "Compare" else "")

                            SmallSpacer()
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .wrapContentSize(Alignment.BottomCenter)
                                    .background(
                                        color = JetpackComposeMaterialTheme.colors.background,
                                        shape = RoundedCornerShape(
                                            topEnd = 10.dp,
                                            topStart = 10.dp,
                                            bottomEnd = 10.dp,
                                            bottomStart = 10.dp
                                        )
                                    )
                                    .height(20.dp)
                                    .width(20.dp)
                            )
                            {
                                Text(
                                    if (btnSize > 0) numberOfMobileCount.toString() else "",
                                    color = JetpackComposeMaterialTheme.colors.primary
                                )
                            }


                        }
                    },
                    onClick = {
                        var m1:String="Select Mobile"
                        var m2:String="Select Mobile"
                        var m3:String="Select Mobile"
                        var m4:String="Select Mobile"
                        if(selectMobilelist.size == 1 || selectMobilelist.size == 0) {
                            Toast.makeText(context, "Select at least two product", Toast.LENGTH_SHORT).show()
                        }else if(selectMobilelist.size == 2){
                              m1=selectMobilelist[0].mobileName;
                              m2=selectMobilelist[1].mobileName;

                        }else if(selectMobilelist.size == 3){
                            m1=selectMobilelist[0].mobileName;
                            m2=selectMobilelist[1].mobileName;
                            m3=selectMobilelist[2].mobileName;
                        }else if(selectMobilelist.size == 4){
                            m1=selectMobilelist[0].mobileName;
                            m2=selectMobilelist[1].mobileName;
                            m3=selectMobilelist[2].mobileName;
                            m4=selectMobilelist[3].mobileName;
                        }
                        if(selectMobilelist.size > 1) {
                            navController.navigate("compare/" + m1 + "/" + m2 + "/" + m3 + "/" + m4)
                        }
                    },
                    icon = {
                        Image(
                            painterResource(id = R.drawable.pinkface),
                            modifier = Modifier
                                .height(30.dp),
                            contentDescription = ""
                        )
                    },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                    backgroundColor = JetpackComposeMaterialTheme.colors.primary,
                    contentColor = Color.White,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(alignment = Alignment.BottomEnd)
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentSize(align = Alignment.CenterEnd)
//                .width(if (btnSize > 0) 180.dp else 70.dp)
                )
            }
        }

    }

}

//@ExperimentalAnimationApi
//@Composable
//fun setlayout(context: Context, navController: NavController, listState: LazyListState) {
//
//    var mobileList = getMobileData()
//
//    Box {
//        //   Text(offset.toString())
//        LazyColumn(
//            // state =  listState
//        ) {
//            itemsIndexed(mobileList) { index, item ->
//                Card(
//                    shape = RoundedCornerShape(8.dp),
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .fillMaxWidth(),
//                    backgroundColor = MaterialTheme.colors.surface,
//
//                    ) {
//                    Box(modifier = Modifier.padding(10.dp)) {
//                        Column() {
//                            Text(
//                                fontSize = 20.sp,
//                                color = Color.Blue,
//                                text = "Samsung M31 12GB", modifier = Modifier.padding(
//                                    top = 20.dp, bottom = 2.dp
//                                )
//
//                            )
//                            TabRowDefaults.Divider()
//                            Spacer(modifier = Modifier.padding(10.dp))
//                            Row() {
//                                Column {
//                                    Image(
//                                        painter = painterResource(id = item.frantImage!!),
//                                        contentDescription = "false",
//                                        modifier =
//                                        Modifier.size(70.dp)
//                                    )
//                                    SmallSpacer()
//                                    Image(
//                                        painter = painterResource(id = item.backImage!!),
//                                        contentDescription = "false",
//                                        modifier =
//                                        Modifier.size(70.dp)
//                                    )
//                                }
//
//                                Column {
//                                    Text(
//                                        text = item.RAM!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    Text(
//                                        text = item.Proccesor!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    Text(
//                                        text = item.Main_camera!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    Text(
//                                        text = item.Front_camera!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    Text(
//                                        text = item.Water_proff!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    Text(
//                                        text = item.SSD_space!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    Text(
//                                        text = item.Price!!,
//                                        modifier = Modifier.padding(
//                                            top = 4.dp,
//                                            start = 22.dp
//                                        ),
//                                        fontSize = 15.sp
//                                    )
//                                    LargeSpacer()
//
//                                }
//
//
//                            }
//                            Column() {
//
//                                TabRowDefaults.Divider()
//
//                                Row(modifier = Modifier.padding(10.dp)) {
//
//                                    var buttonchange: Boolean = true
//                                    Text(
//                                        fontSize = 16.sp,
//                                        text = "ADD to Compare",
//                                        modifier = androidx.compose.ui.Modifier.padding(
//                                            top = 4.dp
//                                        )
//                                    )
//                                    val isChecked =
//                                        remember { mutableStateOf(mobileList[index].Check) }
//                                    Checkbox(
//                                        modifier = Modifier.padding(
//                                            top = 4.dp, start = 150.dp
//                                        ),
//                                        checked = isChecked.value,
//                                        onCheckedChange = {
//                                            isChecked.value = it
//                                            mobileList = mobileList.toMutableList().also {
//                                                mobileList[index].Check = isChecked.value
//                                                selectItem(mobileList[index].Check,item.mobileId!!,index)
//                                            }
//
//                                        },
//                                    )
//
//                                }
//
//                            }
//                        }
//
//                    }
//
//                }
//            }
//        }//listState.firstVisibleItemIndex.toDouble()
////        ExtendedFloatingActionButtonContent(navController, 1.0,selectMobilelist)
//        var btnSize = listState.firstVisibleItemIndex + 1
//        Box( modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()) {
//            ExtendedFloatingActionButton(
//                shape = RoundedCornerShape(topStart = 20.dp),
//                text = {
//                    Row {
//                        Text(if (btnSize > 0) "Compare" else "")
//
//                        SmallSpacer()
//                        Column(
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .wrapContentSize(Alignment.BottomCenter)
//                                .background(
//                                    color = JetpackComposeMaterialTheme.colors.background,
//                                    shape = RoundedCornerShape(
//                                        topEnd = 10.dp,
//                                        topStart = 10.dp,
//                                        bottomEnd = 10.dp,
//                                        bottomStart = 10.dp
//                                    )
//                                )
//                                .height(20.dp)
//                                .width(20.dp)
//                        )
//                        {
//                             Text(
//                                if (btnSize > 0) selectMobilelist.size.toString() else "",
//                                color = JetpackComposeMaterialTheme.colors.primary
//                            )
//                        }
//
//
//                    }
//                },
//                onClick = {
//                    navController.navigate("compare")
//                },
//                icon = {
//                    Image(
//                        painterResource(id = R.drawable.pinkface),
//                        modifier = Modifier
//                            .height(30.dp),
//                        contentDescription = ""
//                    )
//                },
//                elevation = FloatingActionButtonDefaults.elevation(8.dp),
//                backgroundColor = JetpackComposeMaterialTheme.colors.primary,
//                contentColor = Color.White,
//                modifier = Modifier
//                    .padding(10.dp)
//                    .align(alignment = Alignment.BottomEnd)
//                    .wrapContentWidth(align = Alignment.CenterHorizontally)
//                    .wrapContentSize(align = Alignment.CenterEnd)
////                .width(if (btnSize > 0) 180.dp else 70.dp)
//            )
//        }
//    }
//
//}

//fun selectItem(isSelect:Boolean,id:Int,index:Int) {
//    //val selectMobilelist = mutableListOf<SelectMobileListModel>()
//    //selectMobilelist.add(SelectMobileListModel(12))
//    if (isSelect == true) {
//        selectMobilelist.add(
//            SelectMobileListModel(
//                mobileId = id!!
//            )
//        )
//
//        Log.e(
//            "ADDD",
//            "" + isSelect.toString()
//        )
//    } else {
//        selectMobilelist.removeAt(id)
//        Log.e(
//            "MINUS",
//            "" + isSelect.toString()
//        )
//    }
//    Log.e(
//        "Array size",
//        "" + selectMobilelist.toString()
//    )
//}

    data class MobileListModel(
    var mobileId: Int? = null,
    var frantImage: String? = null,
    var backImage: Int? = null,
    val mobileName: String = "",
    val RAM: String = "",
    val Proccesor: String = "",
    val Main_camera: String = "",
    val Front_camera: String = "",
    val Water_proff: String = "",
    val SSD_space: String = "",
    val Price: String = "",
    var Check: Boolean = false
)


//@Composable
//fun ExtendedFloatingActionButtonContent(
//    navController: NavController,
//    btnSize: Double
//) {
//
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//    ) {
//        ExtendedFloatingActionButton(
//            shape = RoundedCornerShape(topStart = 20.dp),
//            text = {
//                Row {
//                    Text(if (btnSize > 0) "Compare" else "")
//
//                    SmallSpacer()
//                    Column(
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier
//                            .wrapContentSize(Alignment.BottomCenter)
//                            .background(
//                                color = JetpackComposeMaterialTheme.colors.background,
//                                shape = RoundedCornerShape(
//                                    topEnd = 10.dp,
//                                    topStart = 10.dp,
//                                    bottomEnd = 10.dp,
//                                    bottomStart = 10.dp
//                                )
//                            )
//                            .height(20.dp)
//                            .width(20.dp)
//                    )
//                    {
//                        Text(
//                            if (btnSize > 0)  else "",
//                            color = JetpackComposeMaterialTheme.colors.primary
//                        )
//                    }
//
//
//                }
//            },
//            onClick = {
//                navController.navigate("compare")
//            },
//            icon = {
//                Image(
//                    painterResource(id = R.drawable.pinkface),
//                    modifier = Modifier
//                        .height(30.dp),
//                    contentDescription = ""
//                )
//            },
//            elevation = FloatingActionButtonDefaults.elevation(8.dp),
//            backgroundColor = JetpackComposeMaterialTheme.colors.primary,
//            contentColor = Color.White,
//            modifier = Modifier
//                .padding(10.dp)
//                .align(alignment = Alignment.BottomEnd)
//                .wrapContentWidth(align = Alignment.CenterHorizontally)
//                .wrapContentSize(align = Alignment.CenterEnd)
////                .width(if (btnSize > 0) 180.dp else 70.dp)
//        )
//    }
//    //newBtnSize=btnSize.toDouble()
//}

//@Composable
//fun getSelectMobileData(): MutableList<SelectMobileListModel> {
//    val list = mutableListOf<SelectMobileListModel>()
//    return list
//}

