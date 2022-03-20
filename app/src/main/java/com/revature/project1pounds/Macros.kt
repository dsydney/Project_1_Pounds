package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.datafile.Account
import com.revature.project1pounds.datafile.accountList
import kotlin.math.roundToInt
import com.revature.project1pounds.ui.theme.Project1PoundsTheme
import androidx.compose.runtime.saveable.rememberSaveable as rememberSavable

class Macros() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {
                MacroScreen()
            }
        }
    }
}

@Composable
fun MacroScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        Column(modifier = Modifier
            .fillMaxSize()
            .absolutePadding(left = 24.dp, right = 24.dp, top = 20.dp, bottom = 20.dp)
            ) {
            Sliders()
            HealthyHints()
        }
    }
    Row(modifier = Modifier
        .fillMaxSize()
        .paddingFromBaseline(bottom = 0.dp)) {
       // TaskBar()
    }
}

@Composable
fun TopBar() {
    TopAppBar() {
        Text(text = "Macros")
    }
}

fun CalorieLimit(protein:Float, fats:Float, carbs:Float) : Int {
    return  ((protein.toInt()*4)+(fats.toInt()*9)+(carbs.toInt()*4))
}

@Composable
fun Sliders() {
    val context = LocalContext.current
    var proteinSliderValue by rememberSavable { mutableStateOf(accountList.getValue(activeUser).protein?.toFloat()) }
    var carbsSliderValue by rememberSavable { mutableStateOf(accountList.getValue(activeUser).carbs?.toFloat()) }
    var fatsSliderValue by rememberSavable { mutableStateOf(accountList.getValue(activeUser).fats?.toFloat()) }

    Column(modifier = Modifier.padding(top = 8.dp)) {
        Row() {
            Text(text = "Daily Calorie Goal: ",
                style=MaterialTheme.typography.h6,
                color=Color.Red,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.SansSerif)
            Text(text = "${CalorieLimit(proteinSliderValue,fatsSliderValue,carbsSliderValue)} ",
                color = Color(0xff3aa62e),
                style=MaterialTheme.typography.h6)
            
             Column(modifier = Modifier.fillMaxWidth(),
             horizontalAlignment = Alignment.End) {
                 Button(onClick = {
                     accountList.getValue(activeUser).carbs = carbsSliderValue.toInt()
                     accountList.getValue(activeUser).protein = proteinSliderValue.toInt()
                     accountList.getValue(activeUser).fats = fatsSliderValue.toInt()
                     accountList.getValue(activeUser).calorieGoal = CalorieLimit(proteinSliderValue,fatsSliderValue,carbsSliderValue)
                     Toast.makeText(context, "Saved changes", Toast.LENGTH_SHORT).show()
                     context.startActivity(Intent(context, Calories::class.java))
                 }) {
                     Text(text = "Save",
                     modifier = Modifier.padding(1.dp))

                 }
             }
        }
    }

    Text(text = "Protein: ${proteinSliderValue.roundToInt()}",
        color = Color.Blue,
        modifier = Modifier.padding(top = 16.dp)
    )
    Slider(
        value = proteinSliderValue,
        valueRange = 0f..300f,
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.LightGray,
            thumbColor = Color.Blue),
        modifier = Modifier.padding(4.dp),
        onValueChange = { newValue ->
            proteinSliderValue = newValue
        }
    )

    Text(
        text = "Carbs: ${carbsSliderValue.roundToInt()}",
        color = Color.Red,
        modifier = Modifier.padding(top = 8.dp)
    )
    Slider(
        value = carbsSliderValue,
        valueRange = 0f..300f,
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Red,
            inactiveTrackColor = Color.LightGray,
            thumbColor = Color.Red),
        modifier = Modifier.padding(4.dp),
        onValueChange = { newValue ->
            carbsSliderValue = newValue
        }
    )

    Text(
        text = "Fats: ${fatsSliderValue.roundToInt()}",
        color = Color(0xffc9c422.toInt()),
        modifier = Modifier.padding(top = 8.dp)
    )
    Slider(
        value = fatsSliderValue,
        valueRange = 0f..200f,
        colors = SliderDefaults.colors(
            activeTrackColor = Color(0xffc9c422.toInt()),
            inactiveTrackColor = Color.LightGray,
            thumbColor = Color(0xffc9c422.toInt())),
        modifier = Modifier.padding(4.dp),
        onValueChange = { newValue ->
            fatsSliderValue = newValue
        }
    )
}

@Composable
fun HealthyHints() {
    val hints = listOf(
        "Healthy eating is a way of life, so it's important to establish routines that are simple and realistic",
        "Whole grains are a very important part of a healthy, balanced diet",
        "Nothing spells health like H-2-O! Drinking water significantly effects energy levels and brain function"
    )
    Card(
        modifier = Modifier
            .absolutePadding(top = 16.dp, bottom = 10.dp, left = 10.dp, right = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        for (i in hints) {
            Row(modifier = Modifier.absolutePadding(top = 16.dp, bottom = 16.dp, left = 8.dp, right = 16.dp),
                verticalAlignment = Alignment.CenterVertically) {

                Column() {

                    for (i in hints) {
                        Row() {
                            Image(
                                painter = painterResource(R.drawable.lightbulbicon_ccexpress),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(8.dp),
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                text = i,
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TestMacroScreen() {
    //MacroScreen()
}