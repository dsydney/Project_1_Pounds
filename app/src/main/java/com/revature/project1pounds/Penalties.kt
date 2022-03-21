package com.revature.project1pounds

import android.content.Intent
import android.hardware.camera2.params.BlackLevelPattern
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Penalties : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {

                PenaltiesMain()

            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PenaltiesPreview() {
    PenaltiesMain()
}

@ExperimentalMaterialApi
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun PreviewPenalties() {
    PenaltiesMain()
}

@ExperimentalMaterialApi
@Composable
fun PenaltiesMain() {

    val context = LocalContext.current

    Column {

        TopAppBar(title = { Text(text = "Penalties") })

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

                    Row() {

                        Text(text = "March\n\n",
                            fontWeight = FontWeight.Bold)

                        Text(text = "\n     Penalties: $5\n",
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )

                    }
                    //Insert image of a graph here
                    Card(

                        Modifier.height(125.dp),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = DarkGray

                    ) {


                        Row(

                            Modifier.padding(10.dp),

                            ) {

                            Column() {

                                Text(
                                    "Days over budget: 5",
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days on budget: 12",
                                    color = Color.Green,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days under budget: 4",
                                    color = Color.Yellow,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days remaining: 10",
                                    color = Color.LightGray,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Spacer(Modifier.width(20.dp))

                            Canvas(modifier = Modifier.fillMaxSize().padding(10.dp)) {

                                val canvasWidth = size.width
                                val canvasHeight = size.height

                                drawArc(

                                    color = Color.Red,
                                    startAngle = 0f,
                                    sweepAngle = 58f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Green,
                                    startAngle = 58f,
                                    sweepAngle = 139f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Color.Yellow,
                                    startAngle = 197f,
                                    sweepAngle = 46f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Color.LightGray,
                                    startAngle = 243f,
                                    sweepAngle = 117f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                            }
                        }
                    }

                }

            }

            //Feb
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black)

            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Row() {

                        Text(text = "February\n\n",
                            fontWeight = FontWeight.Bold)

                        Text(text = "\n     Penalties: $8\n",
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )

                    }
                    //Insert image of a graph here
                    Card(

                        Modifier.height(125.dp),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = DarkGray

                    ) {


                        Row(

                            Modifier.padding(10.dp),

                            ) {

                            Column() {

                                Text(
                                    "Days over budget: 8",
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days on budget: 14",
                                    color = Color.Green,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days under budget: 6",
                                    color = Color.Yellow,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Spacer(Modifier.width(20.dp))

                            Canvas(modifier = Modifier.fillMaxSize().padding(10.dp)) {

                                val canvasWidth = size.width
                                val canvasHeight = size.height

                                drawArc(

                                    color = Color.Red,
                                    startAngle = 0f,
                                    sweepAngle = 103f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Green,
                                    startAngle = 103f,
                                    sweepAngle = 180f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Color.Yellow,
                                    startAngle = 283f,
                                    sweepAngle = 77f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                            }
                        }
                    }

                }

            }

            //Jan
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 12.dp,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(3.dp, Color.Black)

            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Row() {

                        Text(text = "January\n\n",
                            fontWeight = FontWeight.Bold)

                        Text(text = "\n     Penalties: $12\n",
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )

                    }
                    //Insert image of a graph here
                    Card(

                        Modifier.height(125.dp),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = DarkGray

                    ) {


                        Row(

                            Modifier.padding(10.dp),

                            ) {

                            Column() {

                                Text(
                                    "Days over budget: 12",
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days on budget: 18",
                                    color = Color.Green,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    "Days under budget: 1",
                                    color = Color.Yellow,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Spacer(Modifier.width(20.dp))

                            Canvas(modifier = Modifier.fillMaxSize().padding(10.dp)) {

                                val canvasWidth = size.width
                                val canvasHeight = size.height

                                drawArc(

                                    color = Color.Red,
                                    startAngle = 0f,
                                    sweepAngle = 139f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Green,
                                    startAngle = 139f,
                                    sweepAngle = 209f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                                drawArc(

                                    color = Color.Yellow,
                                    startAngle = 348f,
                                    sweepAngle = 12f,
                                    useCenter = false,
                                    size = Size(
                                        width = canvasWidth * 0.7f,
                                        height = canvasWidth * 0.7f
                                    ),
                                    style = Stroke(width = 40f)

                                )

                            }
                        }
                    }

                }

            }

            Spacer(Modifier.height(100.dp))

        }

    }

}