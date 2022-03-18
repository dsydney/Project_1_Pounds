package com.revature.project1pounds

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Calories: ComponentActivity() {
    companion object {
        var meals by mutableStateOf(
            mutableStateListOf<Meal>(
                Meal("chicken",5,15,0),
                Meal("bread",20,0,2),
                Meal("gorp", 50, 50, 50),
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloriesMain()
        }
    }
}

@Composable
fun CaloriesMain() {
    Project1PoundsTheme {
        Scaffold(
            topBar = {
                TopAppBar( title = { Text("Calories") })
            },
            bottomBar = {
                TaskBar()
            },
            content = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    FoodSearch()
                    CalorieProgress(
                        Calories.meals.sumOf { it.calories }.toFloat() / 2000.0f
                    )
                    SavedFoodItems(Calories.meals)
                }
            }
        )
    }
}

@Composable
fun FoodSearch() {
    var name by rememberSaveable { mutableStateOf("") }
    var carb by rememberSaveable { mutableStateOf("") }
    var protein by rememberSaveable { mutableStateOf("") }
    var fat by rememberSaveable { mutableStateOf("") }

    val changeName: (String) -> Unit = { it -> name = it }
    val changeCarb: (String) -> Unit = { it -> carb = it }
    val changeProtein: (String) -> Unit = { it -> protein = it }
    val changeFat: (String) -> Unit = { it -> fat = it }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(.9f),
                value = name,
                onValueChange = changeName,
                label = { Text("What are you eating?") },
                placeholder = { Text("chicken") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Search, "") },
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                value = carb,
                onValueChange = changeCarb,
                modifier = Modifier
                    .requiredWidth(LocalConfiguration.current.screenWidthDp.dp / 4f)
                    .padding(horizontal = 2.dp),
                label = { Text("Carbs") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
            )
            TextField(
                value = protein,
                onValueChange = changeProtein,
                modifier = Modifier
                    .requiredWidth(LocalConfiguration.current.screenWidthDp.dp / 4f)
                    .padding(horizontal = 2.dp),
                label = { Text("Protein") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
            )
            TextField(
                value = fat,
                onValueChange = changeFat,
                modifier = Modifier
                    .requiredWidth(LocalConfiguration.current.screenWidthDp.dp / 4f)
                    .padding(horizontal = 2.dp),
                label = { Text("Fat") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                    Calories.meals.add(Meal(name,carb.toInt(),protein.toInt(),fat.toInt()))
                }
            ) {
                Text("Add to meals")
            }
        }
    }
}

@Composable
fun CalorieProgress(progress: Float = 0.0f) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
//        Text("Today's Calories")
        LinearProgressIndicator(
            progress = if (progress > 1.0f) 1.0f else progress,
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth(0.85f)
                .clip(shape = MaterialTheme.shapes.medium),
            color = progressColor(progress),
            backgroundColor = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
fun progressColor(progress: Float): Color {
    return when {
        progress > 1.0f -> {
            Color.Red
        }
        progress > 0.6f -> {
            Color.Yellow
        }
        else -> {
            Color.Cyan
        }
    }
}

@Composable
fun SavedFoodItems(meals: MutableList<Meal>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Today's food:",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.h6,
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 46.dp)
        ) {
            items(meals) { meal ->
                FoodCard(meal)
            }
        }
    }
}

@Composable
fun FoodCard(meal: Meal) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(2.dp)
    ) {
        Column {
            Text(
                meal.name,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
            ) {
                val textStyleSubtitle2 = MaterialTheme.typography.subtitle2
                var textStyle by remember { mutableStateOf(textStyleSubtitle2) }
                var readyToDraw by remember { mutableStateOf(false) }

                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(
                    text = "${meal.calories} Calories  " +
                            "${meal.carbohydrates}g Carbs  " +
                            "${meal.protein}g Protein  " +
                            "${meal.fat}g Fat",
                    style = textStyle,
                    softWrap = false,
                    maxLines = 1,
                    modifier = Modifier.drawWithContent { if(readyToDraw) drawContent() },
                    onTextLayout = { textLayoutResult ->
                        if(textLayoutResult.didOverflowWidth) {
                            textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
                        } else {
                            readyToDraw = true
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewFoodSearch() {
    Project1PoundsTheme {
        FoodSearch()
    }
}

@Preview
@Composable
fun PreviewCalorieProgress() {
    Project1PoundsTheme {
        Column {
            CalorieProgress(1.5f)
            CalorieProgress(0.75f)
            CalorieProgress(0.4f)
        }
    }
}

@Preview
@Composable
fun PreviewSavedFoodItems() {
    Project1PoundsTheme {
        SavedFoodItems(mutableListOf(
            Meal("chicken",10,50,0),
            Meal("bread",20,0,0),
            Meal("gorp", 100, 100, 100)
        ))
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "Light mode"
)
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark mode"
)
@Composable
fun PreviewFoodCard() {
    Project1PoundsTheme {
        FoodCard(Meal("chicken", 10, 50, 0))
    }
}
