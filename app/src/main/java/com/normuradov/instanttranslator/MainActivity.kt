package com.normuradov.instanttranslator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.normuradov.instanttranslator.ui.theme.InstantTranslatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstantTranslatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun Greeting(name: String = "Тимур", from: String = "Farrukh") {
    val offset = Offset(5.0f, 10.0f)
    val merriweatherSerifFamily = FontFamily(
        Font(R.font.merriweather_light, FontWeight.Light)
    )
    val LightBlue = Color(0xFF0066FF)
    val Purple = Color(green = 0, blue = 128, red = 128)
    val gradientColors = listOf(Cyan, LightBlue, Purple /*...*/)


    Column {
        Text(
            text = "Привет, $name!",
            fontSize = 36.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(300.dp),
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray, offset = offset, blurRadius = 3f
                ),
                fontFamily = merriweatherSerifFamily
            )
        )
        Text(
            text = "- $from",
            fontSize = 12.sp
        )
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(style = SpanStyle(color = Color.Magenta)) {
                        append("M")
                    }
                    append("y ")
                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("n\n")
                    }
                    append("ame")
                }
            }
        )
        Text("hello ".repeat(50), maxLines = 2)
        Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
        Text(
            text = "Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on. ❤️",
            fontSize = 38.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstantTranslatorTheme {
        Greeting()
    }
}
