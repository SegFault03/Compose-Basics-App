package com.example.composeapp.ui.lemonademakerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.ui.theme.ComposeAppTheme

class LemonadeMakerApp : ComponentActivity() {
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
fun TitleScreen(modifier: Modifier = Modifier) {                                                    //is only recomposed when numberOfTaps changes. Note that during recomposition, every piece of code is re-executed.
    var numberOfTaps by remember{
        mutableStateOf((1..3).random())
    }
    val getNumberOfTaps: ()->Unit = {
        numberOfTaps = (1..3).random()
    }
    Column(
        modifier = modifier.fillMaxSize()                                                           //fill the available space (takes up the entire screen)
    ){
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier                                                                     //The order of modifiers chained is important as composition takes
                .fillMaxWidth()                                                                     //place in 3 phases: Compose -> Layout -> Drawing
                .background(color = Color(0xFFFFFF00))                                        //Compose phase: The composable functions are represented in a tree like structure with each composable and its children called a layout node
                .padding(8.dp)                                                                      //Layout phase: Determines the size, width, height etc. of each layout node. The layout modifiers (padding, fillMaxSize, etc.) are evaluated first in left to right fashion
        )                                                                                           //Drawing phase: After the size of composables are finalized during the layout phase, the composables are finally rendered to the 2D screen. The drawing modifers
        //such as color, background, etc. are evaluated in right to left fashion.
        LemonImageAndText(maxNumberOfTaps = numberOfTaps, modifier = modifier                       //Here, too first the entire width is taken up -> background color is filled -> padding is applied -> text is rendered.
            .fillMaxSize()
            .wrapContentSize(Alignment.Center), getNumberOfTaps = getNumberOfTaps)                  //Specifies how the column (as a whole) should use the available space
    }
}

@Composable
fun LemonImageAndText(maxNumberOfTaps: Int, modifier: Modifier = Modifier,                          //This function is recomposed each time lemonadeState is changed as is this where it was defined first
                      getNumberOfTaps: ()->Unit)                                                    //or when numberOfTaps changes, as titleScreen forces a recomposition
{
    val maxTaps = 4+maxNumberOfTaps
    var lemonadeState by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier,                                                                        //Specifies how the column elements should use the available space.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            lemonadeState++
            lemonadeState %= maxTaps
            if(lemonadeState==0) getNumberOfTaps()
        }) {
            LemonadeImage(lemonadeState = lemonadeState, maxTaps = maxNumberOfTaps)
        }
        Spacer(modifier = Modifier.height(16.dp))
        BottomText(lemonadeState = lemonadeState, maxTaps = maxNumberOfTaps)
    }
}

@Composable
fun LemonadeImage(lemonadeState: Int, maxTaps: Int, modifier: Modifier = Modifier)
{
    val resID = when(lemonadeState)
    {
        0 -> R.drawable.lemon_tree
        in 1..1+maxTaps -> R.drawable.lemon_squeeze
        maxTaps+2 -> R.drawable.lemon_drink
        maxTaps+3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_squeeze
    }
    Image(
        painter = painterResource(id = resID),
        contentDescription = null
    )
}

@Composable
fun BottomText(lemonadeState: Int, maxTaps: Int, modifier: Modifier = Modifier)
{
    val text = when(lemonadeState)
    {
        0 -> "Tap the tree to select a lemon"
        in 1..1+maxTaps -> "Keep tapping to squeeze the lemon"
        maxTaps+2 -> "Tap to drink the lemonade"
        maxTaps+3 -> "Tap to make a new lemonade"
        else -> "Tap the tree to select a lemon"
    }
    Text(
        text = text+"\nTaps:$lemonadeState\nMaxTaps:$maxTaps",
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(4.dp)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "DefaultPreview"
)
@Composable
fun LemonadeAppPreview() {
    ComposeAppTheme {
        TitleScreen()
    }
}


