package com.revature.project1pounds

import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Promotions : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@Composable
fun promotionsScreen()
{
    TaskBar()
    Column(modifier=Modifier.verticalScroll(rememberScrollState()),horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row {
            addCard()
            addCard()
        }
        Row {
            addCard()
            addCard()
        }
        Row {
            addCard()
            addCard()
        }
        Row {
            addCard()
            addCard()
        }
        Row {
            addCard()
            addCard()
        }
    }
}
@Composable
fun addCard()
{
    //Image(painter = painterResource(id=R.drawable.gpay))
}
