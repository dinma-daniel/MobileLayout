package com.example.kotlinclass

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("RememberReturnType")
@Composable
fun Details(onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            FilledTonalButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentSize(),
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "download",
                    modifier = Modifier
                        .size(20.dp)
                )

            }

//            Row(
//                modifier = Modifier
//            ) {
//                FilledTonalButton(
//                    onClick = { /*TODO*/ },
//                    modifier = Modifier
//                        .wrapContentSize(),
//                    shape = RoundedCornerShape(20.dp)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.notification),
//                        contentDescription = "download",
//                        modifier = Modifier
//                            .size(20.dp)
//                    )
//
//                }
//            }
        }

//            Next section

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(200.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .then(Modifier.clip(RoundedCornerShape(20.dp)))

            )
        }

//        Next section
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Cat Breed"
        )
        Box(
            modifier = Modifier
                .padding(16.dp, 12.dp)
                .background(
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .height(70.dp),

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(text = "Owners Name: Jeff Bezos")
                Text(text = "Owner's Number: 080-0905-0024")
            }


        }

//        Next  section

        val openDialog = remember { mutableStateOf(false)}
        Button(
            onClick = {
                openDialog.value = true
            },
            modifier = Modifier
                .padding(16.dp)
                .height(70.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(13.dp),

            ) {
            Text(
                text = "Adopt Me",
                color = Color.White,
                fontSize = 16.sp
            )


        }

        if (openDialog.value) {

            AlertDialog(
                onDismissRequest = onDismiss,
                title = {
                    Text(text = "Confirmation")
                },
                text = {
                    Text(text = "Please conform that you want to Adopt this pet")
                },
                confirmButton = {
                    Button(onClick = { openDialog.value = false }) {
                        Text(text = "Confirm")

                    }
                },
                        dismissButton = {
                    Button(onClick = { openDialog.value = false }) {
                        Text(text = "Cancel")

                    }
                }

            )
        }
    }


    }



@Composable
@Preview(showBackground = true)
fun DetailsPreview(){
    Details {
    }
}