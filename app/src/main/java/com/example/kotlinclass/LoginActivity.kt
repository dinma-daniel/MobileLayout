package com.example.kotlinclass

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val username = remember { mutableStateOf(value = "") }
            val password = remember { mutableStateOf(value = "") }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = username.value,
                    onValueChange = { text -> username.value = text },
                    label = { Text("Enter your email") },
                    )

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { text -> password.value = text },
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text("Enter your password") })


                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )

                Row {
                    Button(onClick = {
                        Firebase.auth.createUserWithEmailAndPassword(
                            username.value,
                            password.value
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                startActivity(Intent(this@LoginActivity, FinalProject::class.java))
                                finish()
                            }
                            else {
                                Toast.makeText(this@LoginActivity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }) {
                        Text(text = "Register")

                    }
                    Spacer(
                        modifier = Modifier
                            .width(8.dp)
                    )

                    Button(onClick = {
                        Firebase.auth.signInWithEmailAndPassword(
                            username.value,
                            password.value
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                startActivity(Intent(this@LoginActivity, FinalProject::class.java))
                                finish()
                            }
                            else {
                                Toast.makeText(this@LoginActivity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }) {
                        Text(text = "Login")
                    }

                }
            }
        }
    }
}