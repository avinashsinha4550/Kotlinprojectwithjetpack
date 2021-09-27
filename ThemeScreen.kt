package com.compare.show.screens


import android.content.Context
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.ui.res.colorResource
import com.compare.show.R
import com.compare.show.TopBar
import com.compare.show.theme.JetpackComposeMaterialTheme
import com.example.jetpackcomposematerial.ui.components.OverallView
import com.example.jetpackcomposematerial.ui.components.ThemeType
import com.example.jetpackcomposematerial.ui.theme.*
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun ThemeScreen(openDrawer: () -> Unit,navController: NavController,context: Context) {
    val darkMode = remember { mutableStateOf(false) }
    val themeType = remember { mutableStateOf(ThemeType.RED) }

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
    ProvideWindowInsets() {
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
                                        .weight(4f)
                                    ,                                textAlign = TextAlign.Center,
                                    text = "Theme Screen",
                                    color = androidx.compose.ui.graphics.Color.White,
                                )

                            }

                            Spacer(modifier = Modifier.width(180.dp))

                        },
                        backgroundColor = JetpackComposeMaterialTheme.colors.primary,
                       // modifier = Modifier.weight(1f)
//                    backgroundColor = androidx.compose.ui.res.colorResource(id = R.color.red_700),
                        // contentColor = androidx.compose.ui.graphics.Color.White
                    )

                })
            {
                Column(
                    modifier = Modifier.padding(50.dp)
                ) {
//                Spacer(modifier = Modifier.height(20.dp))
                    // ThememeItem()

                        OverallView(darkMode, themeType,context)
                    }

                }

            }

      //  }
    }
}


}