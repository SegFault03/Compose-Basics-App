package com.example.composeapp.data.affirmationsapp
import com.example.composeapp.R
import com.example.composeapp.model.affirmationsapp.ImageCard
class Datasource {
    fun loadDataCards(): List<ImageCard>{
        val imageCardsList: List<ImageCard> = listOf(
            ImageCard(R.drawable.pic1, R.string.pic1),
            ImageCard(R.drawable.pic2, R.string.pic2),
            ImageCard(R.drawable.pic3, R.string.pic3),
            ImageCard(R.drawable.pic4, R.string.pic4),
            ImageCard(R.drawable.pic5, R.string.pic5)
        )
        return imageCardsList
    }
}