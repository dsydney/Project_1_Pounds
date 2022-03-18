package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Registration : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            registrationPage()
        }
    }
}
@ExperimentalMaterialApi
@Composable
fun registrationPage()
{
    val context = LocalContext.current

    Column(modifier=Modifier.verticalScroll(rememberScrollState()),horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter= painterResource(R.drawable.poundswhitebackground),modifier=Modifier.padding(20.dp), contentDescription = "Pounds logo")
        accountComponent(text ="Please enter your Email " )
        registrationField("Email")

        accountComponent(text = "Please enter a Password")
        registrationField(entry = "Password")

        accountComponent(text = "Please enter your first name")
        registrationField(entry = "First Name")

        accountComponent(text = "Please enter your last name")
        registrationField(entry = "Last Name")

        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { context.startActivity(Intent(context, PaymentOptions::class.java))},
            colors= ButtonDefaults.buttonColors(
                backgroundColor = Color(211,26,26)
            ),
            modifier = Modifier
                .padding(2.dp)
                .width(110.dp)
        )
        {
            Text("Next", color = Color.White)
        }
        Spacer(modifier = Modifier.height(250.dp))

    }
}

@Composable
fun registrationField(entry:String)
{
    Surface(color= Color.White,modifier= Modifier
        .padding(5.dp)
        .fillMaxWidth())
    {
        var text by remember{ mutableStateOf(TextFieldValue(entry)) }
        TextField(

            value =text,
            onValueChange = {
                text=it
            },
            modifier = Modifier.padding(7.dp),
        )
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun regPreview()
{
    registrationPage()
}