package com.example.composeapp.ui.affirmationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import com.example.composeapp.R
import com.example.composeapp.data.affirmationsapp.Datasource
import com.example.composeapp.model.affirmationsapp.ImageCard
import com.example.composeapp.ui.affirmationsapp.ui.theme.ComposeAppTheme

class AffirmationAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationApp(modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun AffirmationApp(modifier: Modifier = Modifier){
    val cardList: List<ImageCard> = Datasource().loadDataCards()
    LazyColumn(modifier = modifier){
        items(cardList){
            CardLayout(
                imageCard = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CardLayout(imageCard: ImageCard, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
    ){
        Column {
            Image(
                painter = painterResource(id = imageCard.imageResID),
                contentDescription = stringResource(id = imageCard.stringResID),
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(192.dp)
            )
            Text(
                text = stringResource(id = imageCard.stringResID),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}


@Preview
@Composable
fun DefaultCardPreview(){
    CardLayout(
        imageCard = ImageCard(R.drawable.pic1, R.string.pic1),
        modifier = Modifier.fillMaxWidth()
        )
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DefaultAppPreview(){
     AffirmationApp(
         modifier = Modifier
             .fillMaxSize()
             .padding(horizontal = 8.dp)
     )
}