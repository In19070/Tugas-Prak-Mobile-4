package com.paulina.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.paulina.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtDisplayLayout()
                }
            }
        }
    }
}

@Composable
fun ArtDisplayLayout() {
    var currentIndex by remember { mutableStateOf(0) }
    val images = listOf(R.drawable.luffy, R.drawable.zoro) // Tambahkan gambar Anda di sini
    val titles = listOf("Sailing Under the Bridge", "Title of Next Art") // Sesuaikan judul
    val authors = listOf("Kat Kuan (2017)", "Author of Next Art") // Sesuaikan penulis

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicText(text = titles[currentIndex], style = MaterialTheme.typography.titleLarge)
        BasicText(text = authors[currentIndex], style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                enabled = currentIndex > 0
            ) {
                BasicText(text = "Previous")
            }

            Button(
                onClick = {
                    if (currentIndex < images.size - 1) currentIndex++
                },
                enabled = currentIndex < images.size - 1
            ) {
                BasicText(text = "Next")
            }
        }
    }
}