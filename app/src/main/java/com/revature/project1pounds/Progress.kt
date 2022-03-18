package com.revature.project1pounds

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

@Preview
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PreviewProgress() {
    ProgressMain()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProgressMain() {

    val context = LocalContext.current

    Column {

        TopAppBar(title = { Text(text = "Daily Progress") })

        Canvas(modifier = Modifier.fillMaxWidth()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.Blue,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = size.minDimension / 4
            )
        }

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Spacer(Modifier.height(5.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black)

            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(text = "Calories: 2210")

                    Text(text = "Macros\nProtein: 140g   25%\nCarbohydrates: 210g   38%\nFat: 91g   37%")

                    Text(text = "Steps: 5283")

                }
            }

            Spacer(Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black),


            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(text = "Today")

                    Row() {

                        Column() {

                            Text(
                                "Protein",
                                color = Color.DarkGray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Carbohydrates",
                                color = Color.LightGray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Fat",
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(Modifier.width(10.dp))

                        Canvas(modifier = Modifier.fillMaxSize()) {

                            val canvasWidth = size.width
                            val canvasHeight = size.height

                            drawArc(

                                color = Color.DarkGray,
                                startAngle = 0f,
                                sweepAngle = 90f,
                                useCenter = true,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f)

                            )

                            drawArc(

                                color = Color.LightGray,
                                startAngle = 90f,
                                sweepAngle = 136.8f,
                                useCenter = true,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f)

                            )

                            drawArc(

                                color = Color.Gray,
                                startAngle = 226.8f,
                                sweepAngle = 133.2f,
                                useCenter = true,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f)

                            )

                        }
                    }
                }
            }

            Spacer(Modifier.height(100.dp))

        }
    }
}
