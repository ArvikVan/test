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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                LemonadeApp()
/*                 DiceRollerApp()
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
                }*/
            }
        }
    }
}
@Preview
@Composable
fun LemonPreview() {
    TestTheme() {
        LemonadeApp()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Lemonade", fontWeight = FontWeight.Bold)
            },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ){
        innerPadding ->
        Surface (modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background){
            when(currentStep) {
                1 -> LemonImageTree(
                    textLabel = stringResource(id = R.string.lemon_tree),
                    imageResource = R.drawable.lemon_tree,
                    onImageClick = { currentStep = 2 })
                2 -> LemonImageTree(
                    textLabel = stringResource(id = R.string.lemon),
                    imageResource = R.drawable.lemon_squeeze,
                    onImageClick = { currentStep = 3 })
                3 -> LemonImageTree(
                    textLabel = stringResource(id = R.string.glass_of_lemonade),
                    imageResource = R.drawable.lemon_drink,
                    onImageClick = { currentStep = 4 })
                4 -> LemonImageTree(
                    textLabel = stringResource(id = R.string.empty_glass),
                    imageResource = R.drawable.lemon_restart,
                    onImageClick = { currentStep = 1 })
            }
        }
    }

}
@Composable
fun LemonImageTree(textLabel : String,
                   imageResource : Int,
                   onImageClick: () -> Unit,
                   modifier: Modifier = Modifier
                   ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = onImageClick) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "1"
            )
        }
        Text(
            text = textLabel,
            modifier = Modifier.padding(8.dp)
        )
    }

}

/*

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "1"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
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
}*/
