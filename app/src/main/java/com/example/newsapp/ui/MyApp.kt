package com.example.newsapp.ui

import androidx.compose.runtime.Composable
import com.example.newsapp.R
import com.example.newsapp.data.fakeData
import com.example.newsapp.data.headerImageResId
import com.example.newsapp.ui.composables.MyLazyRow

@Composable
fun MyApp() {
    MyLazyRow(articles = fakeData, headerImageResId = headerImageResId)
}