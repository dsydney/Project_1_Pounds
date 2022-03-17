package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.revature.project1pounds.ui.theme.Project1PoundsTheme




class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}


@Composable
fun LoginScreen() {

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xffebeadd))
        .padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Welcome()
        Email()
        Password()
        SignInButton()
        RegisterButton()
//            Row {
//                Logo()
//            }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffebeadd)))
    }

}



@Composable
fun Welcome() {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Pounds",
            style=MaterialTheme.typography.h1,
            fontFamily = FontFamily.Cursive,
            color = Color(0xffe31a10.toInt()))
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Email() {
    val emailState = remember{ mutableStateOf(TextFieldValue())}     //keeps track of cursor
    val focusManager = LocalFocusManager.current
    TextField(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        value = emailState.value,
        onValueChange = { emailState.value = it},
        label = { Text(text = "Email")},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color(0xff586ae0),
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Email))
}

@Composable
fun Password() {
    val passwordState = remember{ mutableStateOf(TextFieldValue())}
    val showPassword = remember { mutableStateOf(false)}
    val focusManager = LocalFocusManager.current
    TextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = passwordState.value,
        onValueChange = { passwordState.value = it},
        label = { Text(text = "Password")},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color(0xff586ae0)
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
        visualTransformation = if (showPassword.value){
            VisualTransformation.None  //keep dots
        } else {
            PasswordVisualTransformation()   //show password
        },
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "Hide Password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "Show Password"
                    )
                }
            }
        }
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInButton() {
    val context = LocalContext.current
    //val focusManager = LocalFocusManager.current
    Button(
        onClick = {
            Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
            context.startActivity(Intent(context, Progress::class.java))
        },
        modifier = Modifier
            .absolutePadding(top = 30.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xff586ae0)
        )) {
        Text("Login")
    }
}

@Composable
fun RegisterButton() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Registering new user", Toast.LENGTH_LONG).show()
            context.startActivity(Intent(context, PaymentOptions::class.java))
        },
        modifier = Modifier
            .absolutePadding(top = 8.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray
        )) {
        Text("Register")
    }
}

//@Composable
//fun Logo() {
//    Box(modifier = Modifier.fillMaxWidth()) {
//        Image(
//            painter = painterResource(R.drawable.pounds), contentDescription = "Logo",
//            modifier = Modifier
//                .clip(CircleShape)   //adjust img size and made a circle
//                .padding(16.dp)
//        )
//    }
//
//}


@Preview
@Composable
fun testLogin() {
    LoginScreen()
}
