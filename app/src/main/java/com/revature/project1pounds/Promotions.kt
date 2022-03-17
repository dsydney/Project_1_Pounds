package com.revature.project1pounds

import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.project1pounds.ui.theme.Project1PoundsTheme
import java.time.format.TextStyle

class Promotions : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1PoundsTheme() {
                promotionsScreen()
            }

        }
    }
}
@Composable
fun promotionsScreen() {

Column {

    TaskBar()

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally)
    {

        item {


            Image(
                painter = painterResource(R.drawable.poundswhitebackgroundjustletters),
                modifier = Modifier.padding(40.dp),
                contentDescription = "Pounds logo letters",

                )

            Spacer(modifier = Modifier.height(15.dp))
        }
        items(promotionsList) { promotion ->
            promotionCard(promotion.company, promotion.promotion, promotion.code, promotion.image)
        }
        item { Spacer(modifier = Modifier.height(100.dp)) }

    }
}

}


@Preview
@Composable
fun previewPromo(){
    promotionsScreen()
}