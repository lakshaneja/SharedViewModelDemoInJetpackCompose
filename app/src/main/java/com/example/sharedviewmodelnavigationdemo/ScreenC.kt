package com.example.sharedviewmodelnavigationdemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenC(modifier: Modifier = Modifier, text: String) {
    Box(Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center) {
        Text(fontSize = 20.sp, text = text, color = Color.Blue, modifier = Modifier.padding(10.dp))
    }
}