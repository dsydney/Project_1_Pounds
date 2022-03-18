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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
import com.revature.project1pounds.datafile.Account
import com.revature.project1pounds.datafile.accountList

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
        .fillMaxSize()
        //.background()
        .padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Welcome()
        EmailPassword()
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

@OptIn(ExperimentalComposeUiApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun EmailPassword() {
    val password = rememberSaveable() { mutableStateOf("") }
    val showPassword = remember { mutableStateOf(false) }
    val email = rememberSaveable() { mutableStateOf("") }
    var message = remember() { mutableStateOf("")  }//keeps track of cursor
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    //Email text field
    TextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = email.value,
        onValueChange = { email.value = it },
        label = { Text(text = "Email") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color(0xff586ae0),
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        )
    )

    //Password text field
    TextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text(text = "Password") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color(0xff586ae0)
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (showPassword.value) {
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
    Column(modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${message.value}", color = Color.Red)
    }

    //login button
    Button(
        onClick = {
            if(loginSuccessful(email.value,password.value)) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                //Need to go to MainActivity so that the bottom nav bar is present, otherwise, you get
                // stuck on Progress with no way to navigate.
                context.startActivity(Intent(context, MainActivity(accountList.getValue(email))::class.java))
            } else {
                message.value = "Invalid username/password"
            }
                  },
        modifier = Modifier
            .absolutePadding(top = 16.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xff586ae0)
        )
    )
    {
        Text("Login")
    }
    RegisterButton()
}



fun loginSuccessful(user:String, pass:String): Boolean {

    var userSuccessful:Boolean = false
    var passSuccessful:Boolean = false
//    val users = listOf<String>("brandon@gmail.com", "michael@gmail.com", "david@gmail.com", "jonathan@gmail.com","f")
//    val passwords = listOf<String>("tate", "adams", "sydney", "castaneda", "f")

    if ((accountList.containsKey(user)))
        userSuccessful = true

    var i  = accountList.getValue(user)

    if (i.password.equals(pass))
        passSuccessful = true

    if(userSuccessful&&passSuccessful) {return true} else {return false}
}


@Composable
fun RegisterButton() {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(Intent(context, Registration::class.java))
        },
        modifier = Modifier
            .absolutePadding(top = 4.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray
        )) {
        Text("Register")
    }
}




@Preview
@Composable
fun testLogin() {
    LoginScreen()
}
