package com.example.composeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class ModifierBehaviourDemoActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ComposeAppTheme {

            }
        }
    }
}

@Composable
fun RootLayout(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .padding(8.dp)                                                  //Penultimate border -> Red
            .border(4.dp, Color.Red)
            .padding(8.dp)                                                  //Middle layer -> Black border
            .border(4.dp, Color.Black)
            .padding(8.dp)                                                 //Innermost border -> No border
            .border(4.dp, Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text="This is a demo",
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, Color.Green)                                  //outer Text container->green border
                .padding(8.dp)
                .border(4.dp, Color.Red)                                    //actual container containing content
        )
        Text(
            text = "This is the second text",
            modifier = Modifier
                .padding(16.dp)
                .border(4.dp, Color.Black)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview()
{
    ComposeAppTheme {
        RootLayout(modifier = Modifier.fillMaxSize()
            .padding(8.dp)
            .border(4.dp, Color.Magenta))           //outermost border fills max width -> Magenta border
    }
}