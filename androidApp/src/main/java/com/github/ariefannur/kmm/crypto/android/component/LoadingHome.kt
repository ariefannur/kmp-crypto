package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingHome() {

    LazyColumn {
        item {
            Column (modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier
                    .padding(bottom = 8.dp)
                    .background(shimmerBrush())
                    .width(200.dp)
                    .height(30.dp)
                    .padding(top = 20.dp)
                )

                Box(modifier = Modifier
                    .padding(bottom = 4.dp)
                    .background(shimmerBrush())
                    .width(150.dp)
                    .height(10.dp))
                Box(modifier = Modifier
                    .padding(bottom = 4.dp)
                    .background(shimmerBrush())
                    .width(150.dp)
                    .height(10.dp))
            }
        }

        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
        items(5) {
            Row (modifier = Modifier.padding(16.dp)){
                Box(modifier = Modifier
                    .padding(end = 12.dp)
                    .background(shimmerBrush())
                    .width(48.dp)
                    .height(48.dp))
                Column {
                    Box(
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .background(shimmerBrush())
                            .width(100.dp)
                            .height(15.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .background(shimmerBrush())
                            .width(100.dp)
                            .height(10.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .background(shimmerBrush())
                        .width(80.dp)
                        .height(14.dp)
                )

            }
        }
    }




}

@Composable
fun shimmerBrush(targetValue:Float = 1000f): Brush {

        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.5f),
            Color.LightGray.copy(alpha = 0.1f),
            Color.LightGray.copy(alpha = 0.5f),
        )

        val transition = rememberInfiniteTransition(label = "")
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(600), repeatMode = RepeatMode.Reverse
            ), label = ""
        )
       return Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )

}