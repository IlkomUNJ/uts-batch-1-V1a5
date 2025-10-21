package com.example.uts_mobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uts_mobile.ui.theme.UTS_MobileTheme

@OptIn(ExperimentalMaterial3Api::class)
object DashboardScreen{
    @Composable
    fun SetupLayout(){
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF006569),
                        titleContentColor = Color.White,
                    ),
                    title = { Text("Student Roster") }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {

                        println("FAB Pressed - Go to 3rd Screen")
                    },
                    containerColor = Color(0xFF00C853),
                    contentColor = Color.White
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add New Student")
                }
            },
            containerColor = Color.White,
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Student ID",
                        modifier = Modifier.weight(0.3f),
                        color = Color.DarkGray
                    )
                    Text(
                        text = "Student Name",
                        modifier = Modifier.weight(0.7f),
                        color = Color.DarkGray
                    )
                }

                Text(
                    text = "No students added yet. Press the '+' button to add one.",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 32.dp)
                )


            }
        }
    }

    @Composable
    fun StudentRow(id: String, name: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = id, modifier = Modifier.weight(0.3f))
            Text(text = name, modifier = Modifier.weight(0.7f))
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    UTS_MobileTheme {
        DashboardScreen.SetupLayout()
    }
}