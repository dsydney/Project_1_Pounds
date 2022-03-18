package com.revature.project1pounds

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun promotionCode(context: Context, code:String)
{
    Toast.makeText(context,"Promo Code: ${code}",Toast.LENGTH_LONG).show()
}
@Composable
fun promotionCard(company:String, promotion:String,code: String,image:Int)
{
    var context= LocalContext.current

    Card(elevation = 20.dp, modifier = Modifier
        .clickable { promotionCode(context = context, code = code) }
        .width(300.dp)
        .wrapContentHeight()
        .padding(15.dp)

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(125.dp),
                contentScale = ContentScale.Fit
            )
            Text(text = company, textAlign = TextAlign.Center, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = promotion, textAlign = TextAlign.Center, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))


        }
    }
}