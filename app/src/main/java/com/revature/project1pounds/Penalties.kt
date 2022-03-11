package com.revature.project1pounds

import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Penalties : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {

                PenaltiesMain()

            }
        }
    }
}

@Composable
fun PenaltiesMain() {

    val context = LocalContext.current

    Column {

        TopAppBar(title = { Text(text = "Penalties")})

        TaskBar()

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {

        Button(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        }) {
            Text(text = "Home")
        }

    }

}