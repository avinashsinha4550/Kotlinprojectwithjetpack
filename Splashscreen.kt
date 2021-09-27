package com.compare.show.screens


import android.annotation.SuppressLint
import android.graphics.drawable.PaintDrawable
import android.icu.number.Scale
import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
 import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material.Text
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.compare.show.R
import kotlinx.coroutines.delay
import android.graphics.drawable.Animatable as Animatable1

@Composable
fun SplashScreen(navController: NavController)
{
    val scale = remember {
        Animatable(0f)
      
    }
    LaunchedEffect(key1 = true )
    {
scale.animateTo(targetValue = 1f,animationSpec = tween(durationMillis = 500,
easing = {OvershootInterpolator(4f).getInterpolation(it)}))
        delay(2500L)
        navController.navigate("home")
    }

    
   Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()) {
       Image(painter = painterResource(R.drawable.logo), contentDescription ="Logo",modifier =
       Modifier.scale(scale.value))

   }

}