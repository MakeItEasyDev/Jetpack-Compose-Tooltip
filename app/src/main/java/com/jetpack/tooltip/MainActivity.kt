package com.jetpack.tooltip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetpack.tooltip.ui.theme.TooltipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TooltipTheme {
                val flag = remember { mutableStateOf(false) }
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Compose Tooltip",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Button(
                                onClick = {
                                    flag.value = true
                                }
                            ) {
                                Text(
                                    text = "Tooltip Click"
                                )
                            }
                            if (flag.value) {
                                Tooltip("Tooltip")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Tooltip(text: String) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(PaddingValues(start = 12.dp))
                    .background(
                        color = Color.Green,
                        shape = TriangleEdge()
                    )
                    .width(10.dp)
                    .height(10.dp)
            ) {

            }

            Row(
                modifier = Modifier
                    .background(
                        color = Color.Green,
                        shape = RoundedCornerShape(3.dp)
                    )
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}




























