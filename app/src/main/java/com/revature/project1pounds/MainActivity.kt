package com.revature.project1pounds

import android.content.Intent
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.datafile.Account
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

@ExperimentalMaterialApi
class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {

                //Main()
                BottomNavBar()

            }
        }
    }
}
/*
@Preview
@Composable
fun Preview() {
    TaskBar()
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskBar() {
    val context = LocalContext.current
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
    ) {
        BottomNavigation()
        {
            var selectedItem by remember { mutableStateOf(0) }
            val items = listOf(
                "Macros",
                "Calories",
                "Progress",
                "Penalties",
                "Promos"
            )
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    label = { Text(text = item) },
                    icon = { Icon(Icons.Filled.Info, "") },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        context.startActivity(
                            Intent(
                                context,
                                when (item) {
                                    "Macros"    -> Macros(profile)::class.java
                                    "Calories"  -> Calories(profile)::class.java
                                    "Progress"  -> Progress(profile)::class.java
                                    "Penalties" -> Penalties(profile)::class.java
                                    "Promos"    -> Promotions(profile)::class.java
                                    else        -> MainActivity(profile)::class.java
                                }
                            )
                        )
                    }
                )
            }
        }
    }
}
*/

@ExperimentalMaterialApi
@Composable
fun Main() {

    val context = LocalContext.current

    Column {

        TopAppBar(title = {Text(text = "Home - Pounds App")})

        Button(onClick = {
            context.startActivity(Intent(context, Progress::class.java))
        }) {
            Text(text = "Today's Progress")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Penalties::class.java))
        }) {
            Text(text = "Penalties")
        }

        Button(onClick = {
            context.startActivity(Intent(context, PaymentOptions::class.java))
        }) {
            Text(text = "PaymentOptions")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Promotions::class.java))
        }) {
            Text(text = "Promotions")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Macros::class.java))
        }) {
            Text(text = "Macros")
        }

        Button(onClick = {
            context.startActivity(Intent(context, BankAccountOpt::class.java))
        }) {
            Text(text = "Bank account info")
        }

        Button(onClick = {
            context.startActivity(Intent(context, CreditCardOpt::class.java))
        }) {
            Text(text = "Credit Card info")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Calories::class.java))
        }) {
            Text(text = "Calories")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Login::class.java))
        }) {
            Text(text = "Login")
        }

        Button(onClick = {
            context.startActivity(Intent(context, Meal::class.java))
        }) {
            Text(text = "Meal")
        }

    }

}