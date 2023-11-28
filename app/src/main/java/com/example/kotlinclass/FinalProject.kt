package com.example.kotlinclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

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
        Banner()
    }
}

@Composable
fun Banner(){

}