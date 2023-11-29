package com.example.kotlinclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class FinalProject: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            New()
        }
    }
}

@Composable
fun New() {
    Column {
        Section1()
        Section2()
    }
}

@Composable
fun Section1(){
        Row {
            Column {
                Text(text = "Location")
                Text(text = "BANGKOK, TH")
            }

            Row {
                Button(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = "download",
                        modifier = Modifier.size(30.dp)
                    )

                }
            }
        }

}

@Composable
fun Section2() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun Categories() {
    Column {
        Text(
            text = "Categories")


    }
}
