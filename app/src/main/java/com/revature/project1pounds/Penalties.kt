package com.revature.project1pounds

import android.content.Intent
import android.hardware.camera2.params.BlackLevelPattern
import android.icu.text.CaseMap
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme

class Penalties : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme {

                PenaltiesMain()

            }
        }
    }
}

@Preview
@Composable
fun PenaltiesPreview() {
    PenaltiesMain()
}

@Composable
fun PenaltiesMain() {

    val context = LocalContext.current

    Column {

        TopAppBar(title = { Text(text = "Penalties")})

        TaskBar()

        Card(modifier = Modifier
            .fillMaxWidth()
            .border(3.dp, Black)
            .padding(10.dp)
        ) {
            
            Column {

                Text(text = "Monthly Progress: -$34")

                //Insert image of a graph here
                val painter = painterResource(id = R.drawable.__bfuktr4h4mzmy5uhuez_za)
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

        Card(modifier = Modifier
            .fillMaxWidth()
            .border(3.dp, Black)
            .padding(10.dp)
        ) {

            Column {

                Text(text = "Annual Progress: -$112")

                //Insert image of a graph here
                val painter = painterResource(id = R.drawable.ierbv)
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

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {

        Button(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        }) {
            Text(text = "Home")
        }

    }

}