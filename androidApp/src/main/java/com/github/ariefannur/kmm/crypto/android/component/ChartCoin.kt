package com.github.ariefannur.kmm.crypto.android.component

import android.graphics.PointF
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.unit.dp

@Composable
fun ChartCoin() {

    var selected by remember {
        mutableStateOf("D")
    }

    val animationProgress = remember {
        Animatable(0f)
    }

    val listButton = listOf("D", "W", "M", "Y")

    Column {
        Row(
            Modifier
                .height(260.dp)
                .fillMaxSize()
        ) {

            val graphData = listOf(
                20.dp.value, 40.dp.value, 30.dp.value, 20.dp.value, 40.dp.value,
            )
            LaunchedEffect(graphData) {
                animationProgress.animateTo(1f, tween(3000))
            }

            Spacer(modifier = Modifier
                .padding(8.dp)
                .aspectRatio(3 / 2f)
                .fillMaxSize()
                .drawWithCache {
                    val path = generatePath(
                        graphData, size, 100.dp.value
                    )
                    val filledPath = Path()
                    filledPath.addPath(path)
                    filledPath.lineTo(size.width, size.height)
                    filledPath.lineTo(0f, size.height)
                    filledPath.close()

                    val brush = Brush.verticalGradient(
                        listOf(
                            Color.Blue.copy(alpha = 0.4f),
                            Color.Transparent
                        )
                    )

                    onDrawBehind {
                        this.drawChartArea()
                        clipRect(right = size.width * animationProgress.value) {
                            drawPath(path, Color.Blue, style = Stroke(2.dp.toPx()))
                            drawPath(filledPath, brush = brush, style = Fill)
                        }
                    }
                })
        }

        val buttonSelected = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        val buttonUnSelected = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listButton.forEach { buttonName ->
                if (selected == buttonName) {
                    Button(onClick = {
                                     selected = buttonName
                    }, shape = MaterialTheme.shapes.medium, colors = buttonSelected) {
                        Text(buttonName)
                    }
                } else {
                    FilledTonalButton(onClick = {
                        selected = buttonName
                    }, shape = MaterialTheme.shapes.medium, colors = buttonUnSelected) {
                        Text(buttonName)
                    }
                }
            }
        }
    }
}

fun generatePath(data: List<Float>, size: Size, maxY: Float): Path {
    val path = Path()

    val verticalLine = data.size
    val verticalSize = size.width / verticalLine

    var previousBalanceX = 0f
    var previousBalanceY = size.height
    

    data.forEachIndexed { i , v ->

        if (i == 0) {
            path.moveTo(0f,
                size.height * (v / maxY)
            )
        }

        val startX = verticalSize * (i+1)
        val y = size.height * (v / maxY)

        val controlPoint1 = PointF((startX + previousBalanceX) / 2f, previousBalanceY)
        val controlPoint2 = PointF((startX + previousBalanceX) / 2f, y)

        path.cubicTo(
            controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y,
            startX, y
        )

        previousBalanceX = startX
        previousBalanceY = y
    }
    return path
}

fun DrawScope.drawChartArea() {
    val colorLine = Color.Cyan

    val barWithPx = 1.dp.toPx()
    drawRect(
        color = colorLine,
        style = Stroke(barWithPx)
    )

    val verticalLine = 5
    val verticalSize = size.width / verticalLine
    repeat(verticalLine) { i ->
        val startX = verticalSize * (i+1)
        drawLine(
            color = colorLine,
            start = Offset(startX, 0f),
            end = Offset(startX, size.height),
            strokeWidth = barWithPx
        )
    }

    val horizontalLine = 4
    val horizontalSize = size.height / horizontalLine
    repeat(horizontalLine) { i ->
        val startY = horizontalSize * (i+1)
        drawLine(
            color = colorLine,
            start = Offset(0f, startY),
            end = Offset(size.width, startY),
            strokeWidth = barWithPx
        )
    }
}