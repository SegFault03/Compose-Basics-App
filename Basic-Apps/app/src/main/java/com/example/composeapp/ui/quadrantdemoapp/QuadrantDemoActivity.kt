package com.example.composeapp.ui.quadrantdemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class QuadrantDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun QuadrantElement(
    heading: String,
    desc: String,
    bg: Color,
    modifier: Modifier = Modifier
)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = bg)
            .padding(16.dp)
            .fillMaxSize()
    ){
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun QuadrantGrid(modifier: Modifier = Modifier)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Row(
            modifier = Modifier.weight(1f)
        ){
            QuadrantElement(
                heading = "Text composable" ,
                desc = "Displays text and follows the recommended Material Design guidelines." ,
                bg = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantElement(
                heading = "Image composable",
                desc = "Creates a composable that lays out and draws a given Painter class object.",
                bg = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ){
            QuadrantElement(
                heading = "Row composable",
                desc = "A layout composable that places its children in a horizontal sequence.",
                bg = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            QuadrantElement(
                heading = "Column composable",
                desc = "A layout composable that places its children in a vertical sequence.\n",
                bg = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun QuadrantPreview()
{
    ComposeAppTheme {
        QuadrantGrid()
    }
}