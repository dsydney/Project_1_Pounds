package com.revature.project1pounds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt
import com.revature.project1pounds.ui.theme.Project1PoundsTheme
import androidx.compose.runtime.saveable.rememberSaveable as rememberSavable
import kotlin.math.roundToLong
import androidx.compose.runtime.saveable.rememberSaveable as rememberSaveable1

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


fun CalorieLimit(protein:Float, fats:Float, carbs:Float) : Int {
    return  protein.toInt()*4+fats.toInt()*9+carbs.toInt()*4
}


@Composable
fun Sliders() {
    var proteinSliderValue by rememberSavable { mutableStateOf(1f) }
    var carbsSliderValue by rememberSavable { mutableStateOf(1f) }
    var fatsSliderValue by rememberSavable { mutableStateOf(1f) }

    Column(modifier = Modifier.padding(top = 8.dp)) {
        Row() {
            Text(text = "Daily Calorie Goal: ",
                style=MaterialTheme.typography.h6)
            Text(text = "${CalorieLimit(proteinSliderValue,fatsSliderValue,carbsSliderValue)} ",
                color = Color.Red,
                style=MaterialTheme.typography.h6)
        }
    }
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
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Healthy hints:",
                style=MaterialTheme.typography.h5,
                modifier = Modifier.padding(start = 16.dp, top = 10.dp))
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {

            Image(
                painter = painterResource(R.drawable.lightbulbicon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
            Column(Modifier.padding(8.dp)) {
                for (i in hints) {
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
//    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        Text(text = "Healthy hints:",
//            style=MaterialTheme.typography.h5,
//            modifier = Modifier.padding(start = 16.dp, top = 10.dp))
//        for (i in hints) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(vertical = 25.dp),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//                Text(
//                    text = i,
//                    fontFamily = FontFamily.SansSerif,
//                    modifier = Modifier.padding(4.dp)
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        }
//
//    }





@Preview
@Composable
fun testMacroScreen() {
    MacroScreen()
}