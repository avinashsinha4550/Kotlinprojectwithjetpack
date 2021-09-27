package com.compare.show

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.foundation.Clickable
import com.compare.show.theme.JetpackComposeMaterialTheme
import com.compare.show.ui.theme.NavigationDrawerTheme
import com.example.jetpackcomposematerial.ui.components.LargeSpacer

sealed class DrawerScreens(val title: String, val route: String, val icon: Int) {
    object Home : DrawerScreens("Home", "home", R.drawable.ic_baseline_home_24)
    object My_Wishlist : DrawerScreens("My Wishlist", "my_wishlist", R.drawable.my_wishlist)
    object Themes : DrawerScreens("Themes", "themes", R.drawable.theme)
    object Region : DrawerScreens("Region", "region", R.drawable.region)
    object About_Us : DrawerScreens("About Us", "about_us", R.drawable.about_us)
    object Terms_Conditions :
        DrawerScreens("Terms & Conditions", "terms_conditions", R.drawable.terms)
}

sealed class RootScreens(val title: String, val route: String, val icon: Int) {
    object Splash_Screen : RootScreens("Splash", "splash", R.drawable.ic_baseline_home_24)

    //    object Main_Screen : RootScreens("Splash", "splash", R.drawable.ic_baseline_home_24)
    object Compare_Screen :
        RootScreens("Select Products", "compare/{selectMobile1}/{selectMobile2}/{selectMobile3}/{selectMobile4}", R.drawable.ic_baseline_home_24)

    object Search_Screen : RootScreens("Search Products", "search", R.drawable.ic_baseline_home_24)
    object Filter_Screen : RootScreens("Filter Products", "filter", R.drawable.ic_baseline_home_24)
    object CompareList_Screen :
        RootScreens("Compare List", "comparelist", R.drawable.ic_baseline_home_24)
    object Mobile_Detail_Screen :
        RootScreens("Mobile Detail", "mobiledetails/{mobileid}", R.drawable.ic_baseline_home_24)

    object Mobile_Comparision :
        RootScreens("Compare Details", "comparedetails/{selectMobile1}/{selectMobile2}/{selectMobile3}/{selectMobile4}", R.drawable.ic_baseline_home_24)

}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.My_Wishlist,
    DrawerScreens.Themes,
    DrawerScreens.Region,
    DrawerScreens.About_Us,
    DrawerScreens.Terms_Conditions
)

@Composable
fun Drawer(
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier.background(color = JetpackComposeMaterialTheme.colors.onPrimary)
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Row(
            modifier = Modifier
//

                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
//                .align(alignment = CenterVertically)
            // .wrapContentSize(Center)
        ) {

            Icon(
              //  tint = JetpackComposeMaterialTheme.colors.onPrimary,
                painter = painterResource(R.drawable.ic_baseline_close_24),
                contentDescription = "", modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            closeDrawer()

                        }
                    )
            )
            Spacer(modifier = Modifier.width(30.dp))
            Image (
                modifier = Modifier
                    .height(45.dp)
                    .width(200.dp)
                    .padding(end = 30.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = "App icon"
            )

        }
        LargeSpacer()
        LazyColumn() {
            item {
                screens.forEach { screen ->

                    Row(
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Icon(
                          //  tint = JetpackComposeMaterialTheme.colors.onPrimary,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            painter = painterResource(screen.icon),
                            contentDescription = "Menu icon"
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = screen.title,
                            fontSize = 18.sp,
                        //    color=JetpackComposeMaterialTheme.colors.onPrimary,
                            //style = MaterialTheme.typography.h6,
                            modifier = Modifier.clickable {
                                onDestinationClicked(screen.route)
                            }
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))
            }
        }
    }
}
@Preview
@Composable
fun DrawerPreview() {
    NavigationDrawerTheme {
        // Drawer {}
    }
}