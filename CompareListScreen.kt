//package com.compare.show.screens
//
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.TabRowDefaults.Divider
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment.Companion.CenterVertically
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.compose.navigate
//import android.content.Context
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color.Companion.Gray
//import androidx.compose.ui.res.colorResource
//import androidx.navigation.NavController
//import androidx.ui.foundation.shape.border.Border
//import com.compare.show.R
//import com.example.jetpackcomposematerial.ui.components.LargeSpacer
//import com.example.jetpackcomposematerial.ui.components.SmallSpacer
//
//@Composable
//fun CompareListScreen(navController: NavController, context: Context,listState:String) {
////    Scaffold(
////        topBar ={
////        TopAppBar(
////            title = {
////                Row(modifier = Modifier
////                .fillMaxWidth()
////                .height(50.dp)) {
////                IconButton(onClick = {
////                   navController.navigate("home")
////                }) {
////                    Image(painterResource(id = R.drawable.back_button),modifier = Modifier.align(alignment = CenterVertically), contentDescription ="" )
////                }
////                Spacer(modifier = Modifier.width(60.dp))
////                Text(text = "Select Product", fontSize = 18.sp,modifier = Modifier.align(alignment = CenterVertically))
////                Spacer(modifier = Modifier.width(60.dp))
////                IconButton(onClick = {
////                    ///toast.maketext(this@spinner1,"clear_button",toast.length_short).show()
////                }) {
////                    Text(text = "Clear", fontSize = 18.sp,
////                        modifier = Modifier
////                            .align(alignment = CenterVertically),
////                    )
////                }
////            }
////
////            },
////            backgroundColor = colorResource(id = R.color.red_700),
////            contentColor = Color.White
////
////        )
////    }) {
//        val usss=setdata()
//    Column(){
////     val v=listState;
////        Text(listState.firstVisibleItemIndex.toString())
//        LazyColumn(state = listState){
//            items(usss){usss->
//                setlayout(user = usss)
//            }
//        }
//    }
//
//       }
//
//    fun setdata():MutableList<User>
//    {
//        val list= mutableListOf<User>()
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        list.add(User(frantImage= R.drawable.mobile,backImage= R.drawable.mobileback,RAM = "12GB",Proccesor = "snapdragon 888 procesor",
//            Main_camera = "40 MP Main Camera",Front_camera = "20 MP front camera",Water_proff = "Water Prooof",
//            SSD_space = "256GB SSd",Price = "RS 10000"))
//        return list
//    }
//
//@Composable
//fun setlayout( user: User)
//{
//    Card(
//        shape = RoundedCornerShape(8.dp),
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxWidth(),
//        backgroundColor = MaterialTheme.colors.surface,
//
//    ) {
//        Box(modifier = Modifier.padding(10.dp)) {
//            Column() {
//                Text(
//                    fontSize =20.sp,
//                    color= Color.Blue,
//                    text = "Samsung M31 12GB", modifier =Modifier.padding(
//                        top = 20.dp,bottom = 2.dp
//                    )
//
//                )
//                Divider()
//                Spacer(modifier = Modifier.padding(10.dp))
//                Row() {
//                    Column {
//                        Image(painter = painterResource(id = user.frantImage!!), contentDescription = "false",modifier =
//                        Modifier.size(70.dp))
//                        SmallSpacer()
//                        Image(painter = painterResource(id = user.backImage!!), contentDescription = "false",modifier =
//                        Modifier.size(70.dp))
//                    }
//
//                    Column {
//                        Text(
//                            text = user.RAM!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                        Text(
//                            text = user.Proccesor!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                        Text(
//                            text = user.Main_camera!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                        Text(
//                            text = user.Front_camera!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                        Text(
//                            text = user.Water_proff!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                        Text(
//                            text = user.SSD_space!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                        Text(
//                            text = user.Price!!,
//                            modifier = Modifier.padding(
//                                top = 4.dp,
//                                start = 22.dp
//                            ),
//                            fontSize = 15.sp
//                        )
//                     LargeSpacer()
//
//                    }
//
//
//                }
//                Column() {
//
//                    Divider()
//
//                    Row(modifier = Modifier.padding(10.dp)) {
//
//                        var buttonchange:Boolean=true
//                        Text(
//                            fontSize=16.sp,
//                            text = "ADD to Compare", modifier = androidx.compose.ui.Modifier.padding(
//                                top = 4.dp
//                            )
//                        )
//                        val mRememberObserver = remember { mutableStateOf("") }
//
//                        Checkbox(modifier = Modifier.padding(
//                            top = 4.dp, start = 150.dp
//                        ),
//
//                            checked = mRememberObserver.value == "mText",
//                            onCheckedChange = {
//                                mRememberObserver.value = "mText"
//                         },
//
//
//                        )
//
//                    }
//
//                }
//            }
//
//        }
//
//    }
//
//}
//
//data class User(
//    var frantImage:Int?=null,
//    var backImage:Int?=null,
//    val RAM:String="",
//    val Proccesor:String="",
//    val Main_camera:String="",
//    val Front_camera:String="",
//    val Water_proff:String="",
//    val SSD_space:String="",
//    val Price:String=""
//)
