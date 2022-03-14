package com.revature.project1pounds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class BankAccountOpt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            bankAccountInfo()
        }
    }
}

@Composable
fun bankAccountInfo()
{
    Column(modifier=Modifier.verticalScroll(rememberScrollState()),horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter= painterResource(R.drawable.poundswhitebackground),modifier=Modifier.padding(20.dp), contentDescription = "Pounds logo")
        accountComponent(text ="Please enter your account number" )
        accountNumberFieldComponent("Account Number")
        
        accountComponent(text = "Re-enter your account number")
        accountNumberFieldComponent("Account Number")
        
        accountComponent(text = "Please enter your routing number")
        accountNumberFieldComponent(entry = "Routing Number")
        
        accountComponent(text = "Please enter bank name")
        banknameField(entry = "Bank Name")

        accountComponent(text = "Choose type: Checking or Savings")
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { /*TODO*/ },
                colors=ButtonDefaults.buttonColors(
                    backgroundColor = Color(211,26,26)),
                modifier = Modifier
                    .padding(2.dp)
                    .width(110.dp)
            )
            {
                Text("Checking",color=Color.White)
            }
            Button(onClick = { /*TODO*/ },
                colors=ButtonDefaults.buttonColors(
                    backgroundColor = Color(211,26,26)),
                    modifier = Modifier
                        .padding(2.dp)
                        .width(110.dp)
                )
            {
                Text("Savings",color=Color.White)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { /*TODO*/ },
            colors=ButtonDefaults.buttonColors(
                backgroundColor = Color(211,26,26)),
            modifier = Modifier
                .padding(2.dp)
                .width(110.dp)
        )
        {
            Text("Next",color=Color.White)
        }
        Spacer(modifier = Modifier.height(250.dp))

    }
}
@Composable
fun accountComponent(text:String)
{
    Text(text,
        style = TextStyle(
                fontSize = 16.sp,
                color=Color.Black,
                fontWeight = FontWeight.Bold
            ),
        modifier= Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
        )
}

@Composable
fun accountNumberFieldComponent(entry:String)
{
    Surface(color= Color.White,modifier= Modifier
        .padding(5.dp)
        .fillMaxWidth())
    {
        var text by remember{ mutableStateOf(TextFieldValue(entry))}
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
fun banknameField(entry:String)
{
    Surface(color= Color.White,modifier= Modifier
        .padding(5.dp)
        .fillMaxWidth())
    {
        var text by remember{ mutableStateOf(TextFieldValue(entry))}
        TextField(
            
            value =text,
            onValueChange = {
                text=it
            },
            modifier = Modifier.padding(7.dp),
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
bankAccountInfo()
}