package com.example.happybirthdaycards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdaycards.ui.theme.HappyBirthdayCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithImage(
                        message = stringResource(R.string.happy_birthday_text),
                        nameTo = getString(R.string.name_to),
                        nameFrom = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, nameFrom: String, modifier: Modifier = Modifier, nameTo: String) {
    val completeMessage = "$message $nameTo!"
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = completeMessage, fontSize = 36.sp, modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = nameFrom,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, nameFrom: String, modifier: Modifier = Modifier, nameTo: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image, contentDescription = null, contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, nameFrom = nameFrom, nameTo = nameTo)
    }
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun BirthdayGreetingPreview() {
    HappyBirthdayCardsTheme {
        BirthdayGreetingWithImage(
            message = "Have a Happy Birthday", nameFrom = " - from Cristian", nameTo = "Fanny"
        )
    }
}