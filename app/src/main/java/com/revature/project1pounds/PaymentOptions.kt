package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class PaymentOptions : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@Composable
@ExperimentalMaterialApi

fun paymentScreen()
{
    val context= LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize())
    {
        Image(painter= painterResource(R.drawable.poundswhitebackground), contentDescription = "Pounds logo")
        Spacer(modifier = Modifier.height(15.dp))
        paymentOptionsComponent(text = "Please Choose A Way To Invest In Yourself ")
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { context.startActivity(Intent(context,BankAccountOpt::class.java))  },
            colors= ButtonDefaults.buttonColors(
                backgroundColor = Color(211,26,26)
            ),
            modifier = Modifier
                .padding(2.dp)
                .width(250.dp)
                .height(50.dp)
        )
        {
            Text("Link Bank Account",color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { context.startActivity(Intent(context,CreditCardOpt::class.java))},
            colors= ButtonDefaults.buttonColors(
                backgroundColor = Color(211,26,26)
            ),
            modifier = Modifier
                .padding(2.dp)
                .width(250.dp)
                .height(50.dp)
        )
        {
            Text("Enter Credit Card Information",color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Surface(onClick = {  },
            modifier = Modifier
                .height(50.dp)
                .width(250.dp)
                .padding(2.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(15)
                )
            )
        {

            Image(painter= painterResource(R.drawable.gpay), contentDescription = "Gpay")
        }


    }
}
@Composable
fun paymentOptionsComponent(text:String)

    {
        Text(text,
            style = TextStyle(
                fontSize = 16.sp,
                color= Color.Black,
                fontWeight = FontWeight.Bold
            ),
            modifier= Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }


@Preview(showBackground = true)
@ExperimentalMaterialApi
@Composable
fun DefaultPreview2() {
paymentScreen()
}