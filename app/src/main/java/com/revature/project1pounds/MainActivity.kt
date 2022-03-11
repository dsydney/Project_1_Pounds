package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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

        Button(onClick = {
            context.startActivity(Intent(context, Macros::class.java))
        }) {
            Text(text = "Macros")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Calories::class.java))
        }) {
            Text(text = "Calories")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Progress::class.java))
        }) {
            Text(text = "Progress")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Penalties::class.java))
        }) {
            Text(text = "Penalties")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Promotions::class.java))
        }) {
            Text(text = "Promotions")
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