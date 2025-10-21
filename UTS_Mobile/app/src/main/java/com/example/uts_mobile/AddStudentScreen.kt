package com.example.uts_mobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uts_mobile.ui.theme.UTS_MobileTheme

@OptIn(ExperimentalMaterial3Api::class)
object AddStudentScreen {
    @Composable
    fun SetupLayout(){
        var studentId by remember { mutableStateOf("") }
        var studentName by remember { mutableStateOf("") }
        var studentPhone by remember { mutableStateOf("") }
        var studentAddress by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF006569),
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    title = { Text("Add New Student") },

                    navigationIcon = {
                        IconButton(onClick = {
                            println("Back button pressed - returning to Dashboard")
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },
            containerColor = Color.White,
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                OutlinedTextField(
                    value = studentId,
                    onValueChange = { studentId = it },
                    label = { Text("Student ID") },
                    placeholder = { Text("1313623039") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF006569),
                        unfocusedContainerColor = Color.White,
                    )
                )

                OutlinedTextField(
                    value = studentName,
                    onValueChange = { studentName = it },
                    label = { Text("Student Name") },
                    placeholder = { Text("Muhammad Vlas") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF006569),
                        unfocusedContainerColor = Color.White,
                    )
                )

                OutlinedTextField(
                    value = studentPhone,
                    onValueChange = { studentPhone = it },
                    label = { Text("Phone Number") },
                    placeholder = { Text("0859598xxxxx") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF006569),
                        unfocusedContainerColor = Color.White,
                    )
                )

                OutlinedTextField(
                    value = studentAddress,
                    onValueChange = { studentAddress = it },
                    label = { Text("Address") },
                    placeholder = { Text("JL Tebet Timur....") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF006569),
                        unfocusedContainerColor = Color.White,
                    )
                )

                Button(
                    onClick = {
                        println("Registering Student:")
                        println("ID: $studentId, Name: $studentName, Phone: $studentPhone, Address: $studentAddress")

                        println("Navigation: Returning to Dashboard")
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853))
                ) {
                    Text("Register Student")
                }
            }
        }
    }
}

@Preview
@Composable
fun AddStudentScreenPreview(){
    UTS_MobileTheme {
        AddStudentScreen.SetupLayout()
    }
}