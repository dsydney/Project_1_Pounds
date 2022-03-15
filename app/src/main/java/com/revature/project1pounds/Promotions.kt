package com.revature.project1pounds

import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme
import java.time.format.TextStyle

class Promotions : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            promotionsScreen()
        }
    }
}
@Composable
fun promotionsScreen() {

    Column(modifier=Modifier.verticalScroll(rememberScrollState()),horizontalAlignment = Alignment.CenterHorizontally)
    {
        TaskBar()
        Image(painter= painterResource(R.drawable.poundswhitebackgroundjustletters),modifier=Modifier.padding(40.dp), contentDescription = "Pounds logo letters")
        Row {
            addCard()
            addCard2()
        }
        Row {
            addCard()
            addCard2()
        }
        Row {
            addCard()
            addCard2()
        }
        Row {
            addCard()
            addCard2()
        }
}
}

@Composable
fun addCard()
{
        Surface(modifier = Modifier
            .size(180.dp)
            .padding(20.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(15)
            )

                )
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.seatgeek),
                    contentDescription = "Seatgeek",
                    modifier = Modifier.size(100.dp)
                )
                Text(text = "5$ off next Ticket Purchase", textAlign = TextAlign.Center, fontSize = 10.sp)
                Text(text = "Code: POUNDS",textAlign = TextAlign.Center, fontSize = 15.sp)
            }
        }
}
@Composable
fun addCard2()
{
    Surface(modifier = Modifier
        .size(180.dp)
        .padding(20.dp)
        .border(
            width = 1.dp,
            color = Color.Black,
            shape = RoundedCornerShape(15)
        )

    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.hellofresh),
                contentDescription = "hellofresh",
                modifier = Modifier.size(100.dp)
            )
            Text(text = "20$ off next meal order", textAlign = TextAlign.Center, fontSize = 10.sp)
            Text(text = "Code: POUNDS",textAlign = TextAlign.Center, fontSize = 15.sp)
        }
    }
}
@Preview
@Composable
fun previewPromo(){
    promotionsScreen()
}