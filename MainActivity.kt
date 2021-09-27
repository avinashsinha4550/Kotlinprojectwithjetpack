package com.compare.show
import android.app.Person
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import com.example.jetpackcomposematerial.ui.components.OverallView
import com.example.jetpackcomposematerial.ui.components.ThemeType
import com.example.jetpackcomposematerial.ui.components.ThemeType.*
import com.example.jetpackcomposematerial.ui.theme.BlueTheme
import com.example.jetpackcomposematerial.ui.theme.PinkTheme
import com.example.jetpackcomposematerial.ui.theme.PurpleTheme
import com.example.jetpackcomposematerial.ui.theme.YellowTheme
import com.example.jetpackcomposematerial.ui.theme.RedTheme
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import com.sqlitekotline.Utils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
         setContent {
            val darkMode = remember { mutableStateOf(false) }
            val themeType = remember { mutableStateOf(PURPLE) }

            val themeFunction: @Composable (
                isDarkMode: Boolean, content: @Composable () -> Unit
            ) -> Unit =
                when (themeType.value) {
                    PURPLE -> { isDarkMode, content -> PurpleTheme(isDarkMode, content) }
                    YELLOW -> { isDarkMode, content -> YellowTheme(isDarkMode, content) }
                    BLUE -> { isDarkMode, content -> BlueTheme(isDarkMode, content) }
                    PINK -> { isDarkMode, content -> PinkTheme(isDarkMode, content) }
                    ThemeType.RED -> { isDarkMode, content -> RedTheme(isDarkMode, content) }

                }

            themeFunction.invoke(darkMode.value) {
                OverallView(darkMode, themeType,this)
            }
        }
    }

}
