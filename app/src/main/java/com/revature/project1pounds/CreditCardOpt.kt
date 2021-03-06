package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.datafile.Account
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

var goodCreditNumber=false

@ExperimentalMaterialApi
class CreditCardOpt() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            cardInfo()

        }
    }
}

@ExperimentalMaterialApi
@Composable
fun cardInfo()
{
    val context = LocalContext.current

    Column(modifier=Modifier.verticalScroll(rememberScrollState()),horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter= painterResource(R.drawable.poundswhitebackground),modifier=Modifier.padding(20.dp), contentDescription = "Pounds logo")
        accountComponent(text ="Please enter you card number" )
        cardNumberFieldComponent("Card Number")

        cardComponent(text = "Please enter your CCV")
        cardFieldComponent(entry = "CCV")

        cardComponent(text = "Please enter card holders name")
        cardField(entry = "Name")

        cardComponent(text = "Choose type: Credit or Debit")
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { /*TODO*/ },
                colors= ButtonDefaults.buttonColors(
                    backgroundColor = Color(211,26,26)
                ),
                modifier = Modifier
                    .padding(2.dp)
                    .width(110.dp)
            )
            {
                Text("Credit",color = Color.White)
            }
            Button(onClick = { /*TODO*/ },
                colors= ButtonDefaults.buttonColors(
                    backgroundColor = Color(211,26,26)
                ),
                modifier = Modifier
                    .padding(2.dp)
                    .width(110.dp)
            )
            {
                Text("Debit",color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            if(goodCreditNumber){
            context.startActivity(Intent(context, MainActivity()::class.java))}},
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
fun cardComponent(text:String)
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

@Composable
fun cardFieldComponent(entry:String)
{
    Surface(color= Color.White,modifier= Modifier
        .padding(5.dp)
        .fillMaxWidth())
    {
        var text by remember{ mutableStateOf(TextFieldValue(entry)) }
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ,value =text,
            onValueChange = {
                text=it
            },
            modifier = Modifier.padding(7.dp),
        )
    }
}
@Composable
fun cardNumberFieldComponent(entry:String)
{
    Surface(color= Color.White,modifier= Modifier
        .padding(5.dp)
        .fillMaxWidth())
    {
        var text by remember{ mutableStateOf(TextFieldValue(entry)) }
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ,value =text,
            onValueChange = {
                text=it
            },
            modifier = Modifier.padding(7.dp),
            label = {
                if(checkCreditCardNumberLength(text.text))
                {
                    Text(text = "Card Number")
                }
                else{
                    Text(text = "Card number should be 16 digits")
                }
            }

        )
        goodCreditNumber = checkCreditCardNumberLength(text.text)
    }
}
@Composable
fun cardField(entry:String)
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
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun cardPreview() {
    cardInfo()
}

fun checkCreditCardNumberLength(number:String)=number.length==16
