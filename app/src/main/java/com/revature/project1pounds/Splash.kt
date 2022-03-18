package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Splash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {
                // A surface container using the 'background' color from the theme
                StartupSplash()
            }
        }
    }
}

@Composable
fun StartupSplash() {
    val context = LocalContext.current
    Crossfade(targetState = context) { context ->
        Box(modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = { context.startActivity(Intent(context, Login::class.java)) })
            .background(MaterialTheme.colors.primary))

            Image(
            painter = painterResource(R.drawable.poundsrightcolor),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
        )
            
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Project1PoundsTheme {
        StartupSplash()
    }
}
