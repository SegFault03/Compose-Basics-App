package com.example.composeapp.model.affirmationsapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ImageCard(
    @DrawableRes val imageResID: Int,
    @StringRes val stringResID: Int
)
