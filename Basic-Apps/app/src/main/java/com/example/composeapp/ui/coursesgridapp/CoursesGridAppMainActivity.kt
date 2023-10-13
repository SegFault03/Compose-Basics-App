package com.example.composeapp.ui.coursesgridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import com.example.composeapp.data.coursesgridapp.DataSourceSingleton
import com.example.composeapp.data.coursesgridapp.Datasource
import com.example.composeapp.model.coursesgridapp.CourseCard
import com.example.composeapp.ui.coursesgridapp.ui.theme.ComposeAppTheme

class CoursesGridAppMainActivity : ComponentActivity() {
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
fun CourseGridAppUsingLazyGrid(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ){
       items(DataSourceSingleton.topics){
           CourseCard(courseInfo = it)
       }
    }
}


@Composable
fun CourseGridAppUsingLazyColumn(modifier: Modifier = Modifier){
    val courseList: List<List<CourseCard>> = Datasource().loadDataForLazyColumn()
    LazyColumn(
        modifier = modifier
    ){
        items(courseList){
            CourseRow(
                first = it[0],
                second = it[1],
                Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun CourseRow(first: CourseCard, second: CourseCard, modifier: Modifier = Modifier){
    Row(
        modifier = modifier.padding(4.dp)
    ){
        CourseCard(courseInfo = first, modifier = Modifier.weight(0.5f))
        CourseCard(courseInfo = second, modifier = Modifier.weight(0.5f))
    }
}


@Composable
fun CourseCard(courseInfo: CourseCard, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(4.dp)
            .height(72.dp)
    ){
        Row(
            verticalAlignment = Alignment.Bottom
        ){
            Image(
                painter = painterResource(id = courseInfo.imageResID),
                contentDescription = stringResource(id = courseInfo.courseNameResID),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(96.dp)
                    .weight(0.3f)
            )
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 8.dp),
            ) {
                Text(
                    text = stringResource(id = courseInfo.courseNameResID),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .wrapContentSize(Alignment.TopStart)
                        .padding(bottom = 8.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .align(Alignment.Start)
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_grain_24),
                        contentDescription = null
                    )
                    Text(
                        text = "${courseInfo.numberOfCourses}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CoursesGridAppPreview(){
    ComposeAppTheme {
        CourseGridAppUsingLazyGrid(modifier = Modifier.fillMaxSize())
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CoursesGridAppPreviewUsingLazyColumn(){
    ComposeAppTheme {
        CourseGridAppUsingLazyColumn(modifier = Modifier.fillMaxSize())
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CardRowPreview() {
    val first = CourseCard(
        R.drawable.architecture,
        R.string.topic1,
        123
    )
    val second = CourseCard(
        R.drawable.tech,
        R.string.topic14,
        123
    )
    ComposeAppTheme {
        CourseRow(
            first,
            second,
            Modifier.fillMaxWidth()
        )
    }
}


@Preview
@Composable
fun CardPreview() {
    ComposeAppTheme {
            CourseCard(
                courseInfo = CourseCard(
                    R.drawable.architecture,
                    R.string.topic1,
                    123
                )
            )
    }
}