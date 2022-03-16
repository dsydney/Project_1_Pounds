package com.revature.project1pounds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import com.revature.project1pounds.ui.theme.Project1PoundsTheme
import kotlin.math.roundToLong

class Macros : ComponentActivity() {
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
            CalorieLimit(x = 2000)
            Sliders()
            HealthyHints()

        }

    }
    Row(modifier = Modifier
        .fillMaxSize()
        .paddingFromBaseline(bottom = 0.dp)) {
        TaskBar()
    }

}

@Composable
fun TopBar() {
    TopAppBar() {
        Text(text = "Macros")
    }
}

@Composable
fun CalorieLimit(x:Int) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        Row() {
            Text(text = "Daily Calorie Limit: ",
                style=MaterialTheme.typography.h6)
            Text(text = "$x", color = Color.Red,
                style=MaterialTheme.typography.h6)
        }
    }


}

@Composable
fun Sliders() {
    var proteinSliderValue by remember { mutableStateOf(1f) }
    var carbsSliderValue by remember { mutableStateOf(1f) }
    var fatsSliderValue by remember { mutableStateOf(1f) }
    Column(modifier = Modifier.padding(top = 16.dp)) {
        
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
    var hints = listOf(
        "Healthy eating is a way of life, so it's important to establish routines that are simple and realistic",
        "Whole grains are a very important part of a healthy, balanced diet",
        "Nothing spells health like H-2-O"

    )
    Column(modifier = Modifier
        .padding(top = 20.dp)
        .border(1.dp, Color.LightGray, RectangleShape),
        verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = "Healthy hints:",
            style=MaterialTheme.typography.h5,
            modifier = Modifier.padding(4.dp))
        for(i in hints)
            Text(text = i,
            fontFamily =FontFamily.SansSerif,
            modifier = Modifier.padding(4.dp))

    }

}



@Preview
@Composable
fun testMacroScreen() {
    MacroScreen()
}