package com.example.newsapp.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TransparentTopAppBar(title: @Composable () -> Unit, onIconButtonClick: () -> Unit) {

    TopAppBar(
        modifier = Modifier
            .height(80.dp),
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 0.dp,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, bottom = 8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
                    ){
                IconButton(onClick = onIconButtonClick) {
                    Icon(Icons.Default.Menu, contentDescription = "")
                }
                Spacer(Modifier.width(8.dp))
                title()
            }
        }
    }
}
