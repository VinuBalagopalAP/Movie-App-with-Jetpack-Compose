package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {

    var expanded by remember{
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(4.dp)
//        .height(130.dp)
        .fillMaxWidth(),

        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        onClick = {
            onItemClick(movie.id)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
//                Icon(
//                    imageVector = Icons.Rounded.AccountBox,
//                    contentDescription = "Movie Image"
//                )

//                Image(painter = rememberAsyncImagePainter(model = movie.images[1]), contentDescription = "Movie Poster")

                AsyncImage(model = movie.images[1], contentDescription = "Movie Poster")
            }
            Column {
                Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.labelMedium)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.labelMedium)

                AnimatedVisibility(visible = expanded) {
                    Column {
//                        Text(text = movie.plot, style = MaterialTheme.typography.bodyMedium)
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp)){
                                append("Plot: ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light
                            )){
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider()
                        Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.labelSmall)
                        Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.labelSmall)

                    }
                }

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded = !expanded },
                    tint = Color.DarkGray
                ) }
        }
    }
}