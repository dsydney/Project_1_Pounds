package com.revature.project1pounds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
            .absolutePadding(left = 24.dp, right = 24.dp, top = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
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
    Text(text = "Daily Calorie Limit: $x")
}

@Composable
fun Sliders() {
    var proteinSliderValue by remember { mutableStateOf(1f) }
    var carbsSliderValue by remember { mutableStateOf(1f) }
    var fatsSliderValue by remember { mutableStateOf(1f) }

    Slider(
        value = proteinSliderValue,
        valueRange = 0f..300f,
        modifier = Modifier.padding(4.dp),
        onValueChange = { newValue ->
            proteinSliderValue = newValue
        }
    )
    Text(
        text = "Protein: ${proteinSliderValue.roundToInt()}",
        modifier = Modifier.padding(4.dp)
    )

    Slider(
        value = carbsSliderValue,
        valueRange = 0f..300f,
        modifier = Modifier.padding(4.dp),
        onValueChange = { newValue ->
            carbsSliderValue = newValue
        }
    )
    Text(
        text = "Carbs: ${carbsSliderValue.roundToInt()}",
        modifier = Modifier.padding(4.dp)
    )
    Slider(
        value = fatsSliderValue,
        valueRange = 0f..200f,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            fatsSliderValue = newValue
        }
    )
    Text(
        text = "Fats: ${fatsSliderValue.roundToInt()}",
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun HealthyHints() {
    Text(text = "Healthy hints:")
    Text(text = "Eat your vegetables")
    Text(text = "After that eat more vegetables")
}



@Preview
@Composable
fun testMacroScreen() {
    MacroScreen()
}