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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme
import com.revature.project1pounds.ui.theme.Red400
import com.revature.project1pounds.ui.theme.Red700

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

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Spacer(Modifier.height(5.dp))

            //Snapshot Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black)

            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(text = "Today: \n\n",
                        fontWeight = FontWeight.Bold)

                    Text(text = "Calories: 2210",
                        fontWeight = FontWeight.Bold)

                    Text(text = "Macros\nProtein: 140g   25%\nCarbohydrates: 210g   38%\nFat: 91g   37%",
                        fontWeight = FontWeight.Bold)

                    Text(text = "Steps: 5283",
                        fontWeight = FontWeight.Bold)

                }
            }

            //Spacer(Modifier.height(10.dp))

            //Macros Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black),


            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(text = "Macros\n\n",
                        fontWeight = FontWeight.Bold)

                    Row() {

                        Column() {

                            Text(
                                "Protein 25%",
                                color = Color.DarkGray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Carbohydrates 38%",
                                color = Color.LightGray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Fat 37%",
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

            //Steps Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black),


                ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(text = "Step Count\n\n",
                        fontWeight = FontWeight.Bold)

                    Row() {

                        Column() {

                            Text(
                                "Steps: 5283\nGoal: 7000",
                                fontWeight = FontWeight.Bold
                            )

                        }

                        Spacer(Modifier.width(20.dp))

                        Canvas(modifier = Modifier.fillMaxSize()) {

                            val canvasWidth = size.width
                            val canvasHeight = size.height

                            drawArc(

                                color = Color.Blue,
                                startAngle = 270f,
                                sweepAngle =272f,
                                useCenter = false,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f),
                                style = Stroke(width = 40f)

                            )

                            drawArc(

                                color = Color.DarkGray,
                                startAngle = 182f,
                                sweepAngle =88f,
                                useCenter = false,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f),
                                style = Stroke(width = 40f)

                            )



                        }
                    }
                }
            }

            //Calories Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black),


                ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(text = "Calories\n\n",
                        fontWeight = FontWeight.Bold)

                    Row() {

                        Column() {

                            Text(
                                "Breakfast: 725 Calories",
                                color = Color.LightGray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Lunch: 816 Calories",
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Dinner: 669 Calories",
                                color = Color.DarkGray,
                                fontWeight = FontWeight.Bold
                            )

                        }

                        Spacer(Modifier.width(20.dp))

                        Canvas(modifier = Modifier.fillMaxSize()) {

                            val canvasWidth = size.width
                            val canvasHeight = size.height

                            drawArc(

                                color = Color.LightGray,
                                startAngle = 0f,
                                sweepAngle =118f,
                                useCenter = true,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f),

                            )

                            drawArc(

                                color = Color.Gray,
                                startAngle = 118f,
                                sweepAngle =133f,
                                useCenter = true,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f),

                            )

                            drawArc(

                                color = Color.DarkGray,
                                startAngle = 251f,
                                sweepAngle =109f,
                                useCenter = true,
                                size = Size(width = canvasWidth * 0.7f, height = canvasWidth * 0.7f),

                            )

                        }
                    }
                }
            }

            Spacer(Modifier.height(100.dp))

        }
    }
}







