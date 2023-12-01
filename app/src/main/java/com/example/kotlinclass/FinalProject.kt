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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class FinalProject: ComponentActivity() {

    lateinit var navController: NavHostController
    val catViewModel: CatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()
            SetupNavGraph(navController = navController, catViewModel = catViewModel)

        }
    }



//    @Composable
//    fun HomePage(){
//        val scrollState = rememberScrollState()
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(0.dp)
//                .background(Color.White),
//        ){
//            Row(
//                modifier = Modifier
//                    .padding(16.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .weight(1f)
//                ) {
//                    Text(
//                        text = "Location",
//                        fontSize = 12.sp,
//                        color = Color.Gray
//                    )
//
//                    Row(
//                        modifier = Modifier
//                            .padding(0.dp, 5.dp)
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.location2),
//                            contentDescription = "location",
//                            modifier = Modifier.size(20.dp)
//                        )
//                        Text(text = "BANGKOK, TH")
//                    }
//
//                }
//
//                Row(
//                    modifier = Modifier
//                ) {
//                    FilledTonalButton(
//                        onClick = { /*TODO*/ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(20.dp)
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.notification),
//                            contentDescription = "download",
//                            modifier = Modifier
//                                .size(20.dp)
//                        )
//
//                    }
//                }
//            }
//
////            Next section
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//                    .height(200.dp),
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.top),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .then(Modifier.clip(RoundedCornerShape(20.dp)))
//
//                )
//            }
//
////            Next section
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = "Categories"
//                )
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(0.dp, 10.dp)
//                        .horizontalScroll(rememberScrollState())
//                ) {
//                    Button(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Cat",
//                            color = Color.White,
//                            fontSize = 16.sp
//                        )
//                    }
//                    Spacer(modifier = Modifier.width(8.dp))
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Dog",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.width(8.dp))
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Crab",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Fish",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Rabbit",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//
//                }
//            }
//
////            Next section
//            Column(
//                modifier = Modifier
//                    .padding(16.dp, 0.dp)
//            ) {
//                Text(
//                    text = "Pets Near You",
//                    fontSize = 16.sp
//                )
//            }
//            Surface(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .verticalScroll(scrollState)
//            ) {
//                Column {
//
//                    Box(
//                        modifier = Modifier
//                            .padding(0.dp, 12.dp)
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .padding(0.dp),
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.cat),
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .width(120.dp)
//                            )
//
//                            Column(
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(20.dp, 0.dp)
//                            ) {
//                                Text(
//                                    modifier = Modifier
//                                        .clickable {
//                                            navController.navigate(route = Screen.Detail.route)
//                                        },
//                                    text = "Cat Breed",
//                                    fontSize = 16.sp
//
//                                )
//                                Row {
//                                    FilledTonalButton(
//                                        onClick = { /* */ },
//                                        modifier = Modifier
//                                            .height(30.dp),
//                                        shape = RoundedCornerShape(5.dp),
//
//                                        ) {
//                                        Text(
//                                            text = "Female",
//                                            color = Color.Gray,
//                                            fontSize = 11.sp
//                                        )
//                                    }
//                                    Spacer(modifier = Modifier.width(8.dp))
//                                    FilledTonalButton(
//                                        onClick = { /* */ },
//                                        modifier = Modifier
//                                            .height(30.dp)
//                                            .wrapContentSize(),
//                                        shape = RoundedCornerShape(5.dp),
//
//                                        ) {
//                                        Text(
//                                            text = "1 year",
//                                            color = Color.Gray,
//                                            fontSize = 11.sp
//                                        )
//                                    }
//                                }
//
//                            }
//                        }
//
//
//                    }
//
//                }
//
//            }
//
//        }
//    }
//
//    @Composable
//    fun New() {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(0.dp)
//                .background(Color.White),
//        ) {
//            Section1()
//            Section2()
//            Categories()
//            Cats(navController = rememberNavController())
//        }
//    }
//
//    @Composable
//    fun Section1() {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//            ) {
//                Text(
//                    text = "Location",
//                    fontSize = 12.sp,
//                    color = Color.Gray
//                )
//
//                Row(
//                    modifier = Modifier
//                        .padding(0.dp, 5.dp)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.location2),
//                        contentDescription = "location",
//                        modifier = Modifier.size(20.dp)
//                    )
//                    Text(text = "BANGKOK, TH")
//                }
//
//            }
//
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
//        }
//
//    }
//
//    @Composable
//    fun Section2() {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .height(200.dp),
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.top),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .then(Modifier.clip(RoundedCornerShape(20.dp)))
//
//            )
//        }
//    }
//
//    @Composable
//    fun Categories() {
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = "Categories"
//                )
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(0.dp, 10.dp)
//                        .horizontalScroll(rememberScrollState())
//                ) {
//                    Button(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Cat",
//                            color = Color.White,
//                            fontSize = 16.sp
//                        )
//                    }
//                    Spacer(modifier = Modifier.width(8.dp))
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Dog",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.width(8.dp))
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Crab",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Fish",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    FilledTonalButton(
//                        onClick = { /* */ },
//                        modifier = Modifier
//                            .wrapContentSize(),
//                        shape = RoundedCornerShape(13.dp),
//
//                        ) {
//                        Text(
//                            text = "Rabbit",
//                            color = Color.Black,
//                            fontSize = 16.sp
//                        )
//                    }
//
//                }
//            }
//    }
//
//
//    @Composable
//    fun Cats(
//        navController: NavController
//    ) {
//        val scrollState = rememberScrollState()
//        Column(
//            modifier = Modifier
//                .padding(16.dp, 0.dp)
//        ) {
//            Text(
//                text = "Pets Near You",
//                fontSize = 16.sp
//            )
//        }
//        Surface(
//            modifier = Modifier
//                .padding(16.dp)
//                .verticalScroll(scrollState)
//        ) {
//            Column {
//
//                Box(
//                    modifier = Modifier
//                        .padding(0.dp, 12.dp)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .padding(0.dp),
////                HorizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.cat),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .width(120.dp)
//                        )
//
//                        Column(
//                            modifier = Modifier
//                                .weight(1f)
//                                .padding(20.dp, 0.dp)
//                        ) {
//                            Text(
//                                modifier = Modifier
//                                    .clickable {
//                                        navController.navigate(route = Screen.Detail.route)
//                                    },
//                                text = "Cat Breed",
//                                fontSize = 16.sp
//
//                            )
//                            Row {
//                                FilledTonalButton(
//                                    onClick = { /* */ },
//                                    modifier = Modifier
//                                        .height(30.dp),
//                                    shape = RoundedCornerShape(5.dp),
//
//                                    ) {
//                                    Text(
//                                        text = "Female",
//                                        color = Color.Gray,
//                                        fontSize = 11.sp
//                                    )
//                                }
//                                Spacer(modifier = Modifier.width(8.dp))
//                                FilledTonalButton(
//                                    onClick = { /* */ },
//                                    modifier = Modifier
//                                        .height(30.dp)
//                                        .wrapContentSize(),
//                                    shape = RoundedCornerShape(5.dp),
//
//                                    ) {
//                                    Text(
//                                        text = "1 year",
//                                        color = Color.Gray,
//                                        fontSize = 11.sp
//                                    )
//                                }
//                            }
//
//                        }
//                    }
//
//
//                }
//
//            }
//
//        }
//    }
//
//
//    @Composable
//    fun Dogs() {
//        val scrollState = rememberScrollState()
//        Column(
//            modifier = Modifier
//                .padding(16.dp, 0.dp)
//        ) {
//            Text(
//                text = "Pets Near You",
//                fontSize = 16.sp
//            )
//        }
//        Surface(
//            modifier = Modifier
//                .padding(16.dp)
//                .verticalScroll(scrollState)
//        ) {
//            Column {
//
//                Box(
//                    modifier = Modifier
//                        .padding(0.dp, 12.dp)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .padding(0.dp),
////                HorizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.cat),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .width(120.dp)
//                        )
//
//                        Column(
//                            modifier = Modifier
//                                .weight(1f)
//                                .padding(20.dp, 0.dp)
//                        ) {
//                            Text(
//                                text = "Dog Name",
//                                fontSize = 16.sp
//                            )
//                            Text(text = "Dog Breed")
//                            Row {
//                                Button(
//                                    onClick = { /* */ },
//                                    modifier = Modifier
//                                        .height(30.dp),
//
//                                    ) {
//                                    Text(
//                                        text = "Female",
//                                        color = Color.White,
//                                        fontSize = 11.sp
//                                    )
//                                }
//                                Spacer(modifier = Modifier.width(8.dp))
//                                Button(
//                                    onClick = { /* */ },
//                                    modifier = Modifier
//                                        .height(30.dp),
//                                    shape = RoundedCornerShape(5.dp),
//
//                                    ) {
//                                    Text(
//                                        text = "1 year",
//                                        color = Color.White,
//                                        fontSize = 11.sp
//                                    )
//                                }
//                            }
//
//                        }
//                    }
//
//
//                }
//
//            }

        }
//    }
//
//}