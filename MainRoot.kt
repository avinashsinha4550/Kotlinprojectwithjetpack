package com.compare.show

import android.app.Person
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.compare.show.screens.*
import com.compare.show.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

import androidx.compose.runtime.*
import androidx.core.view.WindowCompat
import com.example.jetpackcomposematerial.ui.components.ThemeType
import com.example.jetpackcomposematerial.ui.theme.*
import com.example.myjetpack1.Comparision.MobileComparision
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sqlitekotline.ProductAttributes
import com.sqlitekotline.Utils
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainRoot : ComponentActivity() {


    @ExperimentalStdlibApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        createDatabase()


        val sharedPrefFile = "kotlinsharedpreference"
        val sharedPreferences: SharedPreferences =this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
       // val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        //editor.putString("lang","IN")
       // editor.putString("theme", "YELLOW")
        //editor.apply()
//        editor.commit()


        setContent {
              var themeType:MutableState<ThemeType> = mutableStateOf(ThemeType.YELLOW)
//
//           //
             val darkMode = remember { mutableStateOf(false) }
            if(sharedPreferences.getString("theme","RED") == "RED") {
                   themeType = remember { mutableStateOf(ThemeType.RED) }
            }
            if(sharedPreferences.getString("theme","RED") == "PURPLE") {
                themeType = remember { mutableStateOf(ThemeType.PURPLE) }
            }
            if(sharedPreferences.getString("theme","RED") == "PINK") {
                themeType = remember { mutableStateOf(ThemeType.PINK) }
            }
            if(sharedPreferences.getString("theme","RED") == "YELLOW") {
                themeType = remember { mutableStateOf(ThemeType.YELLOW) }
            }



            val themeFunction: @Composable (
                isDarkMode: Boolean, content: @Composable () -> Unit
            ) -> Unit =
                when (themeType.value) {
                    ThemeType.RED -> { isDarkMode, content ->
                        RedTheme(
                            isDarkMode,
                            content
                        )
                    }
                    ThemeType.PURPLE -> { isDarkMode, content ->
                        PurpleTheme(
                            isDarkMode,
                            content
                        )
                    }
                    ThemeType.YELLOW -> { isDarkMode, content ->
                        YellowTheme(
                            isDarkMode,
                            content
                        )
                    }
                    ThemeType.BLUE -> { isDarkMode, content ->
                        BlueTheme(
                            isDarkMode,
                            content
                        )
                    }
                    ThemeType.PINK -> { isDarkMode, content ->
                        PinkTheme(
                            isDarkMode,
                            content
                        )
                    }

                }

            themeFunction.invoke(darkMode.value) {
                //OverallView(darkMode, themeType)
                ProvideWindowInsets() {
                    AppMainScreen(this)
                }

            }
//            NavigationDrawerTheme {
//                AppMainScreen(this)
//            }
        }
    }

    private fun createDatabase() {
        val utils = Utils();
        val databaseHandler = DatabaseHandler(this)
        val jsonFileString = utils.getJsonDataFromAsset(applicationContext, "product.json")
        Toast.makeText(applicationContext, "no record save", Toast.LENGTH_LONG).show()
        if (jsonFileString != null) {
            //Log.i("data", jsonFileString)
        }
        val gson = Gson()
        val listPersonType = object : TypeToken<List<ProductAttributes>>() {}.type
        var persons: List<ProductAttributes> = gson.fromJson(jsonFileString, listPersonType)
          val deleteAll = databaseHandler.deleteAll()
        persons.forEachIndexed { idx, person ->
            val status = databaseHandler.addProduct(person)
            /* Log.i("data", " Item:- $idx: \n${person.proccesor}")*/
            if (persons.lastIndexOf(person) == idx) {
                if(status >-1){
                   // var ss= DatabaseHandler(this)
                    Log.e("#########",databaseHandler.getMobileData().toString())
                    Toast.makeText(applicationContext, "record save", Toast.LENGTH_LONG).show()
                }else{
                }

            } else {
                Toast.makeText(
                    applicationContext,
                    "Error........",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}

@ExperimentalStdlibApi
@ExperimentalAnimationApi
@Composable
fun AppMainScreen(
//    darkMode: MutableState<Boolean>,
//                  themeType: MutableState<ThemeType>,
    context: Context) {
    val navController = rememberNavController()
    Surface() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
            val closeDrawer = {
            scope.launch {
                drawerState.close()
            }
            }
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(
                    closeDrawer = {
                        closeDrawer()
                    },
                    Modifier
                   ) { route ->
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(route) {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = RootScreens.Splash_Screen.route
            ) {

                composable(RootScreens.Splash_Screen.route) {
                    SplashScreen(navController = navController)
                }

                composable(DrawerScreens.Home.route) {
                    HomeScreen(
                        openDrawer = {
                            openDrawer()
                        },navController = navController,context
                    )
                }
                composable(DrawerScreens.My_Wishlist
                    .route) {
                    MyWishList(
                        openDrawer = {
                            openDrawer()
                        },navController
                    )
                }
                composable(DrawerScreens.Themes
                    .route) {
                    ThemeScreen(
                        openDrawer = {
                            openDrawer()
                        },navController,context
                    )
                }
                composable(DrawerScreens.Region
                    .route) {
                    RegionScreen(
                        openDrawer = {
                            openDrawer()
                        },navController
                    )
                }
                composable(DrawerScreens.About_Us
                    .route) {
                    AbouUsScreen(
                        openDrawer = {
                            openDrawer()
                        },navController
                    )
                }
                composable(DrawerScreens.Terms_Conditions
                    .route) {
                    TermsAndCondition(
                        openDrawer = {
                            openDrawer()
                        },navController
                    )
                }
                composable(RootScreens.Compare_Screen.route) { backStackEntry ->
                    CompareScreen(
                        navController = navController, context,
                        backStackEntry.arguments?.getString("selectMobile1")!!,
                        backStackEntry.arguments?.getString("selectMobile2")!!,
                        backStackEntry.arguments?.getString("selectMobile3")!!,
                        backStackEntry.arguments?.getString("selectMobile4")!!
                    )
                }
                 composable(RootScreens.Mobile_Comparision.route) { backStackEntry ->
                     MobileComparision(
                        navController = navController,context,
                        backStackEntry.arguments?.getString("selectMobile1")!!,
                        backStackEntry.arguments?.getString("selectMobile2")!!,
                        backStackEntry.arguments?.getString("selectMobile3")!!,
                        backStackEntry.arguments?.getString("selectMobile4")!!
                    )
                }
                composable(RootScreens.Mobile_Detail_Screen.route) { backStackEntry ->
                    MobileDetails(
                        navController = navController,
                        context,
                        backStackEntry.arguments?.getString("mobileid")!!
                    )
                }
                composable(RootScreens.Search_Screen.route) {
                    SearchScreen(
                        navController = navController,context
                    )
                }
                composable(RootScreens.Filter_Screen.route) {
                    FilterScreen(
                        navController = navController,context
                    )
                }
                composable(RootScreens.CompareList_Screen.route) {
//                    CompareListScreen(
//                        navController = navController,context
//                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationDrawerTheme {
      //  AppMainScreen(context)
    }
}