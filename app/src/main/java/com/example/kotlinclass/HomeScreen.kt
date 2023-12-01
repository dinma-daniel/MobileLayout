package com.example.kotlinclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.kotlinclass.api.CatProvider
import com.example.kotlinclass.data.CatItem
import com.example.kotlinclass.data.CatResult


class Details: ComponentActivity() {

    private val catViewModel: CatViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        catViewModel.fetchCats()

        setContent {

            Res()
        }
    }

    @Composable
    fun Res() {
        HomeScreen(
            navController = rememberNavController(),
            catViewModel = catViewModel
        )

    }


}
@Composable
fun HomeScreen(
    navController: NavController,
    catViewModel: CatViewModel
) {

    val scrollState = rememberScrollState()
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
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Location",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Row(
                    modifier = Modifier
                        .padding(0.dp, 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.location2),
                        contentDescription = "location",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(text = "BANGKOK, TH")
                }

            }

            Row(
                modifier = Modifier
            ) {
                FilledTonalButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = "download",
                        modifier = Modifier
                            .size(20.dp)
                    )

                }
            }
        }

//            Next section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(200.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.top),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .then(Modifier.clip(RoundedCornerShape(20.dp)))

            )
        }

//            Next section
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Categories"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                Button(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(13.dp),

                    ) {
                    Text(
                        text = "Cat",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                FilledTonalButton(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(13.dp),

                    ) {
                    Text(
                        text = "Dog",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))
                FilledTonalButton(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(13.dp),

                    ) {
                    Text(
                        text = "Crab",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))

                FilledTonalButton(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(13.dp),

                    ) {
                    Text(
                        text = "Fish",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                FilledTonalButton(
                    onClick = { /* */ },
                    modifier = Modifier
                        .wrapContentSize(),
                    shape = RoundedCornerShape(13.dp),

                    ) {
                    Text(
                        text = "Rabbit",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }

            }
        }

//            Next section
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp)
        ) {
            Text(
                text = "Pets Near You",
                fontSize = 16.sp
            )
        }
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Column {
                val catImages = catViewModel.items.observeAsState(emptyList())

                LazyColumn {
                    items(catImages.value) {
                            image ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(120.dp)
                                .padding(8.dp)
                                .clip(RoundedCornerShape(16.dp))
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                val paint = rememberAsyncImagePainter(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(image.image_link)
                                        .build()
                                )

                                Image(
                                    painter = paint,
                                    contentDescription = "cats",
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(text = image.name)
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(0.dp, 12.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(route = Screen.Detail.route)
                        },
                ) {
                    Row(
                        modifier = Modifier
                            .padding(0.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cat),
                            contentDescription = null,
                            modifier = Modifier
                                .width(120.dp)
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(20.dp, 0.dp)
                        ) {
                            Text(
                                text = "Cat Breed",
                                fontSize = 16.sp

                            )
                            Row {
                                FilledTonalButton(
                                    onClick = { /* */ },
                                    modifier = Modifier
                                        .height(30.dp),
                                    shape = RoundedCornerShape(5.dp),

                                    ) {
                                    Text(
                                        text = "Female",
                                        color = Color.Gray,
                                        fontSize = 11.sp
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                FilledTonalButton(
                                    onClick = { /* */ },
                                    modifier = Modifier
                                        .height(30.dp)
                                        .wrapContentSize(),
                                    shape = RoundedCornerShape(5.dp),

                                    ) {
                                    Text(
                                        text = "1 year",
                                        color = Color.Gray,
                                        fontSize = 11.sp
                                    )
                                }
                            }

                        }
                    }


                }

            }

        }

    }
}
