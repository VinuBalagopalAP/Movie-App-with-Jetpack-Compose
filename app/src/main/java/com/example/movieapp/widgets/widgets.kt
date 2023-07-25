package com.example.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp),
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
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
