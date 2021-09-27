package com.example.jetpackcomposematerial.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
//import com.compare.show.AppMainScreen
import com.compare.show.MainRoot
import com.compare.show.screens.HomeScreen
import com.compare.show.screens.SplashScreen
import com.compare.show.theme.JetpackComposeMaterialTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun OverallView(
    darkMode: MutableState<Boolean>,
    themeType: MutableState<ThemeType>,context:Context
) {
    ProvideWindowInsets {
        Column {
            Scaffold(
//                modifier = Modifier.weight(1f),
                topBar = { MyTopAppBar(themeType.value) },
//                isFloatingActionButtonDocked = true,
//                floatingActionButton = { MyFloatingButton() }
            ) {
                Surface(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(
                            JetpackComposeMaterialTheme.paddings.largePadding
                        )
                    ) {
                        SettingView(darkMode = darkMode, themeType = themeType, context = context)
                        val navController = rememberNavController()
//                        ThememeItem()
                       // AppMainScreen()
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .background(color = JetpackComposeMaterialTheme.colors.primaryVariant)
                    .fillMaxWidth()
                    .navigationBarsPadding()
            )
        }
    }
}
@Composable
fun MyTopAppBar(
    theme: ThemeType
) {
    Column {
        Spacer(
            modifier = Modifier
              //  .background(color = JetpackComposeMaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .statusBarsPadding()
        )
        TopAppBar(
            title = { Text(theme.name) },
            backgroundColor = JetpackComposeMaterialTheme.colors.primary
        )
    }
}

@Composable
fun MyFloatingButton() {
    val scope = rememberCoroutineScope()
    FloatingActionButton(onClick = {
    }) {
        Text("X")
    }
}
