package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Progress : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {
                
                ProgressMain()
                
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProgressMain() {

    val context = LocalContext.current

    Column {
        
        TopAppBar(title = {Text(text = "Daily Progress")})

        //TaskBar()

        Card(modifier = Modifier
            .fillMaxWidth()
            .border(3.dp, Color.Black)
            .padding(10.dp)
        ) {

            Column {

                Text(text = "Calories: 2100")

                Text(text = "Macros\nProtein: 5g   44%\nCarbohydrates: 76g   38%\nFat: 17g   18%")

                Text(text = "Steps: 5283")

                //Insert image of a graph here
                val painter = painterResource(id = R.drawable.macrospiechart)
                val description = "Bar Chart"
                Box (modifier = Modifier
                    .fillMaxWidth()
                ) {

                    Image(
                        painter = painter,
                        contentDescription = description,
                        contentScale = ContentScale.FillWidth
                    )

                }

            }

        }

        //BottomNavBar()

    }
    
}