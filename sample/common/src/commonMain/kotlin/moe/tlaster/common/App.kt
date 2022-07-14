package moe.tlaster.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.safearea.SafeArea

@Composable
fun App() {
    MaterialTheme {
        Box {
            Column(
                modifier = Modifier.background(Color.Red).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text("Hello World!")
                Text("not in SafeArea")
            }
            SafeArea {
                Column(
                    modifier = Modifier.background(Color.Cyan).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text("Hello World!")
                    Text("in SafeArea")
                }
            }
        }
    }
}
