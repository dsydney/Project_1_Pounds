package com.revature.project1pounds

import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {

                Main()

            }
        }
    }
}

@Composable
fun TaskBar() {

    val context = LocalContext.current

    Row() {

        Button(modifier = Modifier.fillMaxWidth(0.2f),
            onClick = {
            context.startActivity(Intent(context, Macros::class.java))
        }) {
            Text(text = "Macros", fontSize = 9.sp)
        }

        Button(modifier = Modifier.fillMaxWidth(0.25f),
            onClick = {
            context.startActivity(Intent(context, Calories::class.java))
        }) {
            Text(text = "Calories", fontSize = 8.sp)
        }

        Button(modifier = Modifier.fillMaxWidth(0.33333f),
            onClick = {
            context.startActivity(Intent(context, Progress::class.java))
        }) {
            Text(text = "Progress", fontSize = 7.sp)
        }

        Button(modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
            context.startActivity(Intent(context, Penalties::class.java))
        }) {
            Text(text = "Penalties", fontSize = 6.sp)
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
            context.startActivity(Intent(context, Promotions::class.java))
        }) {
            Text(text = "Promos", fontSize = 8.sp)
        }

    }

}

@Composable
fun Main() {

    val context = LocalContext.current

    Column {

        TopAppBar(title = {Text(text = "Home")})

        Button(onClick = {
            context.startActivity(Intent(context, Progress::class.java))
        }) {
            Text(text = "Today's Progress")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Penalties::class.java))
        }) {
            Text(text = "Penalties")
        }

    }

}