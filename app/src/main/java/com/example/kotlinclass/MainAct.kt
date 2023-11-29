package com.example.kotlinclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainAct: ComponentActivity() {

    val unsplashViewModel: UnsplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.FetchPhotoDetails("oBp-kWAPFnA")

        setContent {
            ColumnContent()
        }
    }

    @Composable
    fun ColumnContent() {
        Column {
            MyScreenContent()
        }
    }

    @Composable
    fun MyScreenContent() {
        val item = unsplashViewModel.item.observeAsState()


        val customBackgroundColor = Color(0xFF191919)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .background(Color.Black),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.value?.urls?.regular)
                        .build()
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, start = 10.dp)
                ) {
                    Button(
                        onClick = { /* */ },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = "location",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = "Spiderman",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 10.dp, top = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .width(200.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Button(
                        onClick = { /* */ },
                        shape = CircleShape,
                        modifier = Modifier
                            .wrapContentSize()
                            .background(customBackgroundColor, shape = CircleShape),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img4),
                            contentDescription = "Display picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(shape = CircleShape)
                                .padding(end = 0.dp)
                        )
                    }
                    Text(
                        text = "Biel Morro",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Button(
                        onClick = { /* */ },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.download),
                            contentDescription = "download",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Button(
                        onClick = { /* */ },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = "Heart",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Button(
                        onClick = { /* */ },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bookmark),
                            contentDescription = "bookmark",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .width(223.dp)
                        .padding(end = 15.dp)
                ) {
                    Text(
                        text = "Camera",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.value?.exif?.model?:"-",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "Focal Length",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.value?.exif?.focal_length?:"-",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "ISO",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.value?.exif?.iso.toString()?:"-",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )


                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 15.dp)
                ) {
                    Text(
                        text = "Apeture",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.value?.exif?.aperture?:"-",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "Shutter Speed",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.value?.exif?.exposure_time?:"-",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "Dimensions",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.value?.exif?.make?:"-",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    modifier = Modifier
                        .width(120.dp)
                        .padding(end = 15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Views",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "8.8M",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Downloads",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "99.1K",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Likes",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "1.8K",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),

                ) {
                Button(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize()
                        .background(customBackgroundColor, shape = CircleShape),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text(
                        text = "barcelona",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize()
                        .background(customBackgroundColor, shape = CircleShape),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text(
                        text = "spain",
                        color = Color.White,
                        fontSize = 16.sp,
//                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    )
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Similar structure for the last row of buttons or content
            }
        }
    }
}


