package com.example.composeapp.data.coursesgridapp

import com.example.composeapp.R
import com.example.composeapp.model.coursesgridapp.CourseCard

class Datasource {
    fun loadDataForLazyColumn(): List<List<CourseCard>>{
        val courseList: List<List<CourseCard>> = listOf(
            listOf(
                CourseCard(
                    R.drawable.architecture,
                    R.string.topic1,
                    58
                ),
                CourseCard(
                    R.drawable.crafts,
                    R.string.topic2,
                    121
                )
            ),
            listOf(
                CourseCard(
                    R.drawable.business,
                    R.string.topic3,
                    78
                ),
                CourseCard(
                    R.drawable.culinary,
                    R.string.topic4,
                    118
                )
            ),
            listOf(
                CourseCard(
                    R.drawable.design,
                    R.string.topic5,
                    423
                ),
                CourseCard(
                    R.drawable.fashion,
                    R.string.topic6,
                    92
                )
            ),
            listOf(
                CourseCard(
                    R.drawable.film,
                    R.string.topic7,
                    165
                ),
                CourseCard(
                    R.drawable.gaming,
                    R.string.topic8,
                    164
                )
            ),
            listOf(
                CourseCard(
                    R.drawable.drawing,
                    R.string.topic9,
                    326
                ),
                CourseCard(
                    R.drawable.lifestyle,
                    R.string.topic10,
                    305
                )
            ),
            listOf(
                CourseCard(
                    R.drawable.music,
                    R.string.topic11,
                    212
                ),
                CourseCard(
                    R.drawable.painting,
                    R.string.topic12,
                    172
                )
            ),
            listOf(
                CourseCard(
                    R.drawable.photography,
                    R.string.topic13,
                    321
                ),
                CourseCard(
                    R.drawable.tech,
                    R.string.topic14,
                    118
                )
            )
        )
        return courseList
    }
}

object DataSourceSingleton {
    val topics = listOf(
        CourseCard(
            R.drawable.architecture,
            R.string.topic1,
            58
        ),
        CourseCard(
            R.drawable.crafts,
            R.string.topic2,
            121
        ),
        CourseCard(
            R.drawable.business,
            R.string.topic3,
            78
        ),
        CourseCard(
            R.drawable.culinary,
            R.string.topic4,
            118
        ),
        CourseCard(
            R.drawable.design,
            R.string.topic5,
            423
        ),
        CourseCard(
            R.drawable.fashion,
            R.string.topic6,
            92
        ),
        CourseCard(
            R.drawable.film,
            R.string.topic7,
            165
        ),
        CourseCard(
            R.drawable.gaming,
            R.string.topic8,
            164
        ),
        CourseCard(
            R.drawable.drawing,
            R.string.topic9,
            326
        ),
        CourseCard(
            R.drawable.lifestyle,
            R.string.topic10,
            305
        ),
        CourseCard(
            R.drawable.music,
            R.string.topic11,
            212
        ),
        CourseCard(
            R.drawable.painting,
            R.string.topic12,
            172
        ),
        CourseCard(
            R.drawable.photography,
            R.string.topic13,
            321
        ),
        CourseCard(
            R.drawable.tech,
            R.string.topic14,
            118
        )
    )
}