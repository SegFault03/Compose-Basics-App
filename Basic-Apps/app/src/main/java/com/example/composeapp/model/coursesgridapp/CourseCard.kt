package com.example.composeapp.model.coursesgridapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseCard(
    @DrawableRes val imageResID: Int,
    @StringRes val courseNameResID: Int,
    val numberOfCourses: Int
)
