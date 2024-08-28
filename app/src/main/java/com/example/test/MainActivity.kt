package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color(126364)
                ) {
                    BusinessCard()
//                    ComposeQuadrantApp()
//                    TaskCompletedScreen()
//                    Greeting(firstText = stringResource(R.string.first_text_message),
//                        secondText = stringResource(R.string.second_text_message),
//                        thirdText = stringResource(R.string.third_text_message),
//                        modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}
@Composable
fun BusinessCard() {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        ){
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Inside,
                alignment = Alignment.CenterStart,
                alpha = 0.9F,
            )
        }
        ComposableFirstCard(
            fullName = stringResource(id = R.string.full_name),
            title = stringResource(id = R.string.title),
            modifier = Modifier.padding(8.dp));
    }
    Row (verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
        ComposableSecondCard()
    }

}

@Composable
fun Greeting(firstText: String, secondText: String, thirdText : String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box (modifier) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = image, contentDescription = null,
                contentScale = ContentScale.FillWidth,
                alpha = 0.9F)
            Text(
                text = firstText,
                textAlign = TextAlign.Justify,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = secondText,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = thirdText,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}
@Composable
fun TaskCompletedScreen() {
    Box {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            val image = painterResource(R.drawable.ic_task_completed)
            Image(painter = image, contentDescription = null,
                contentScale = ContentScale.FillWidth,
                alpha = 0.9F)
            Text(
                text = stringResource(R.string.task_completed_message),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
            Text(
                text = stringResource(R.string.task_completed_nice_work_message),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}
@Composable
private fun ComposableFirstCard(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = fullName,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = title,
            textAlign = TextAlign.Left,
            fontSize = 12.sp
        )
    }
}
@Composable
private fun ComposableSecondCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(Icons.Rounded.Call, contentDescription = "Localized description")
            Text(
                text = stringResource(id = R.string.title),
                textAlign = TextAlign.Left,
                fontSize = 12.sp
            )
        }
        Row {
            Icon(Icons.Rounded.AccountCircle, contentDescription = "Localized description")
            Text(
                text = stringResource(id = R.string.title),
                textAlign = TextAlign.Left,
                fontSize = 12.sp
            )
        }
        Row {
            Icon(Icons.Rounded.Create, contentDescription = "Localized description")
            Text(
                text = stringResource(id = R.string.title),
                textAlign = TextAlign.Left,
                fontSize = 12.sp
            )
        }
    }
}