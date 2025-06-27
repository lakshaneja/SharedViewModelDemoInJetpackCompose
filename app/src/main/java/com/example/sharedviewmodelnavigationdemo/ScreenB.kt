package com.example.sharedviewmodelnavigationdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sharedviewmodelnavigationdemo.ui.MyViewModel

@Composable
fun ScreenB(vm: MyViewModel,event:()-> Unit) {
    val data by vm.sharedStateFlow.collectAsState()
    Column(Modifier.fillMaxSize(),Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = data, onValueChange = { vm.updateFlow(it) })
        Button(onClick = event) { Text("Submit") }
    }
}