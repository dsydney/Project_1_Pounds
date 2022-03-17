package com.revature.project1pounds

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Calories: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var meals by remember { mutableStateOf(mutableListOf<Meal>(
                Meal("chicken",5,15,0),
                Meal("bread",20,0,2),
                Meal("gorp", 50, 50, 50),
                Meal("chicken",5,15,0),
                Meal("bread",20,0,2),
                Meal("gorp", 50, 50, 50),
                Meal("chicken",5,15,0),
                Meal("bread",20,0,2),
                Meal("gorp", 50, 50, 50),
                Meal("chicken",5,15,0),
                Meal("bread",20,0,2),
                Meal("gorp", 50, 50, 50),
            )) }
            Project1PoundsTheme {
                Scaffold(
                    topBar = {
                        TopAppBar {
                            Text(
                                text ="Calories",
                            )
                        }
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
                                meals.sumOf { it.calories }.toFloat() / 2000.0f
                            )
                            SavedFoodItems(meals)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun FoodSearch() {
    // reference: https://proandroiddev.com/jetpack-compose-auto-complete-search-bar-853023856f0f
    // https://stackoverflow.com/questions/58840019/jetpack-compose-ui-how-to-create-searchview
    var (value, onValueChange) = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(.9f),
            value = value,
            onValueChange = onValueChange,
            label = { Text("What are you eating?") },
            placeholder = { Text("chicken") },
//            textStyle = MaterialTheme.typography.subtitle1,
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Search, "") },
            trailingIcon = {
                IconButton(onClick = { /* Add item to meals */ }) { Icons.Filled.Add }
            },
            // keyboard actions?
        )
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
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.h6,
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(32.dp)
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
                fontSize = 24.sp,
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

@Composable
fun BottomTaskBar() {
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
                                    "Macros"    -> Macros::class.java
                                    "Calories"  -> Calories::class.java
                                    "Progress"  -> Progress::class.java
                                    "Penalties" -> Penalties::class.java
                                    "Promos"    -> Promotions::class.java
                                    else        -> MainActivity::class.java
                                }
                            )
                        )
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
