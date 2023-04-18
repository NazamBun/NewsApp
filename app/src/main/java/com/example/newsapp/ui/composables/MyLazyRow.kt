package com.example.newsapp.ui.composables

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import com.example.newsapp.R
import com.example.newsapp.model.Article
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.math.roundToInt


@Composable
fun MyLazyRow(articles: List<Article>, headerImageResId: Int) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,

        content = { padding ->
            Box(modifier = Modifier.padding(top = 0.dp)) {
                LazyColumn(
                    modifier = Modifier.padding(padding)
                ) {
                    item {
                        Image(
                            painter = painterResource(id = headerImageResId),
                            contentDescription = "Header Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    items(articles) { article ->
                        ArticleColumn(article = article, headerImageResId = R.drawable.guerre)
                    }

                }
                TransparentTopAppBar(
                    title = {
                        Text(text = "A la une",
                            style = MaterialTheme.typography.h6.copy(fontSize = 20.sp)
                        )
                    },
                    onIconButtonClick = {
                        // Votre code à exécuter lors du clic sur l'icône
                    }
                )
            }
        }
    )
}


@Composable
fun ArticleColumn(
    modifier: Modifier = Modifier,
    article: Article,
    headerImageResId: Int
) {
    val customFont = FontFamily(Font(R.font.oswald))


    Card(
        modifier
            .height(110.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(25))
            .padding(4.dp),
        elevation = 2.dp


    ) {
        Column() {

            Row() {
                Image(
                    painter = painterResource(id = article.imageResId),
                    contentDescription = "",
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .clip(RoundedCornerShape(2)),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.h6,
                        fontFamily = customFont,
                        maxLines = 1,
                    )
                    Text(
                        text = article.description,
                        style = TextStyle(fontSize = 12.sp),
                        maxLines = 2
                    )
                }
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun ArticleRowPreview() {
    ArticleColumn(
        article = Article(
            "Donald Trump face à la justice",
            subtitle = "ddd",
            description = "cddlmjmljljf elfsdjlfkj lfkmskqdlmfkdsl lklmk klklmk df k mlklmdklklmkkmlkl lmkmlkmlkmldkflmkqdsml lkmlkmlklmklmkdlmf lmlkmlksdf ",
            imageResId = com.example.newsapp.R.drawable.trump
        ),
        headerImageResId = R.drawable.trump
    )
}

@Preview(showBackground = true)
@Composable
fun MyLazyRowPreview() {
    val articles = listOf(
        Article(title = "Article 1", description = "Ceci est la description de l'article 1", imageResId = R.drawable.trump, subtitle = "kjjhklhhlhlkhk"),
        Article(title = "Article 2", description = "Ceci est la description de l'article 2", imageResId = R.drawable.spider, subtitle = "kjjhklhhlhlkhk")
    )
    MyLazyRow(articles = articles, headerImageResId = R.drawable.trump)
}