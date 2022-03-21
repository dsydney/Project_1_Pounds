package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.getSelectedText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.datafile.Account
import com.revature.project1pounds.datafile.accountList
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

var tempEmail:String=""
var tempPassword:String=""
var tempName:String=""
var tempLastname:String=""
var passingProfile:Account? = null
var blankAccount: Account= Account("","","","")
var goodLogin=false

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
        emailField("Email")

        accountComponent(text = "Please enter a Password")
        passwordField(entry = "Password")

        accountComponent(text = "Please enter your first name")
        firstnameField(entry = "First Name")

        accountComponent(text = "Please enter your last name")
        lastNameField(entry = "Last Name")

        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            if(goodLogin){
                passingProfile=Account(tempName, tempLastname, tempEmail, tempPassword)
                accountList.put(tempEmail, passingProfile!!)
                activeUser= passingProfile!!.email
            context.startActivity(Intent(context, PaymentOptions()::class.java))}
                         },
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
fun emailField(entry:String)
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
        tempEmail=text.text
    }

}
@Composable
fun passwordField(entry:String)
{
    Surface(color= Color.White,modifier= Modifier
        .padding(5.dp)
        .fillMaxWidth())
    {
        var text by remember{ mutableStateOf(TextFieldValue(entry)) }
        TextField(

            value =text,
            label = {
                    if (checkPasswordLength(text.text)){
                         Text(text="Password")
                    }else{
                        Text(text="Password must be between 8-12 characters")
                    }
            },
            onValueChange = {
                text=it
            },
            modifier = Modifier.padding(7.dp),

        )
        if(checkPasswordLength(text.text)) {
            tempPassword = text.text
            goodLogin=true
        }else{
            goodLogin=false
        }

    }
}
@Composable
fun firstnameField(entry:String)
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
        tempName=text.text
    }
}
@Composable
fun lastNameField(entry:String)
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
        tempLastname=text.text
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun regPreview()
{
    registrationPage()
}
fun checkPasswordLength(password:String):Boolean{
    return password.length in 8..12
}



