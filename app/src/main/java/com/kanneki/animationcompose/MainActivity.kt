package com.kanneki.animationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.animationcompose.ui.theme.AnimationComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationComposeTheme {
                var editable by remember { mutableStateOf(true) }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AnimatedVisibility(
                        visible = editable,
                        enter = scaleIn(animationSpec = tween(durationMillis = 200)) + fadeIn(
                            animationSpec = tween(durationMillis = 200)
                        ),
                        exit = scaleOut(animationSpec = tween(durationMillis = 200)) + fadeOut(
                            animationSpec = tween(durationMillis = 200)
                        )
                    ) {

                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "home",
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp)
                        )
                    }

                    Button(onClick = { editable = !editable }) {
                        Text(text = "Click Me")
                    }

                }
            }
        }
    }
}

