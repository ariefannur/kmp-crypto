package com.github.ariefannur.kmm.crypto.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
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
import com.github.ariefannur.kmm.crypto.model.Coin
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun DetailCoinScreen(coin: Coin) {

    MaterialTheme () {
        Scaffold { innerPadding ->
            Surface {
                Column(
                    Modifier.padding(innerPadding)
                        .verticalScroll(rememberScrollState())
                ) {
                    Row(Modifier.padding(16.dp)) {
//                        Box should be image
                        Box(modifier = Modifier.size(40.dp)) {
                            KamelImage(asyncPainterResource(data = coin.imgLogo), contentDescription = "img-detail")
                        }
                        Column(modifier = Modifier.padding(start = 12.dp)) {
                            Text("\$${coin.price}", style = MaterialTheme.typography.h5)
                            Text(
                                text = "${if (coin.percentage < 0) "↘" else "↗"} ${coin.percentage}", style = MaterialTheme.typography.body1
                            )
                        }
                    }

                    ChartCoinUI()
                    ButtonActionUI()
                    BottomDetailCoinUI(coin)
                }
            }
        }
    }
}

val graphDatas = listOf (

    listOf(20.dp.value, 40.dp.value, 30.dp.value, 20.dp.value, 40.dp.value),
    listOf(70.dp.value, 50.dp.value, 60.dp.value, 30.dp.value, 40.dp.value),
    listOf(50.dp.value, 60.dp.value, 70.dp.value, 70.dp.value, 80.dp.value),
    listOf(80.dp.value, 70.dp.value, 60.dp.value, 40.dp.value, 50.dp.value),

)


@Composable
fun ChartCoinUI() {

    var selected by remember {
        mutableStateOf("D")
    }

    val animationProgress = remember {
        Animatable(0f)
    }

    var graphData by remember {
        mutableStateOf(graphDatas.random())
    }

    val listButton = listOf("D", "W", "M", "Y")

    Column {
        Row(
            Modifier
                .height(260.dp)
                .fillMaxSize()
        ) {
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

        val buttonSelected = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)
        val buttonUnSelected = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listButton.forEach { buttonName ->
                if (selected == buttonName) {
                    Button(onClick = {
                        graphData = graphDatas.random()
                        selected = buttonName
                    }, shape = MaterialTheme.shapes.medium, colors = buttonSelected) {
                        Text(buttonName)
                    }
                } else {
                    Button(onClick = {
                        graphData = graphDatas.random()
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

data class PointF(val x: Float, val y: Float)

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

@Composable
fun ButtonActionUI() {
    Row (modifier = Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(top = 50.dp, start = 16.dp, end = 16.dp)
        , Arrangement.SpaceAround){
        Column (verticalArrangement = Arrangement.Center){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "")
            }
            Text("Share")
        }
        Column (verticalArrangement = Arrangement.Center){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
            Text("Exchange")
        }
        Column (verticalArrangement = Arrangement.Center){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Send, contentDescription = "")
            }
            Text("Receive")
        }
    }
}

@Composable
fun BottomDetailCoinUI(coin: Coin) {
    Column (modifier = Modifier
        .padding(top = 25.dp , start = 16.dp, end = 16.dp)
    ) {
        Text("In Wallet", style = MaterialTheme.typography.body1, modifier = Modifier.padding(bottom = 16.dp))
        Row {
            Text(text = "${coin.price}", style = MaterialTheme.typography.subtitle1)
            Text(text = coin.symbol, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "\$${coin.move24}", style = MaterialTheme.typography.body1)
        }
        Row (modifier = Modifier.fillMaxWidth().padding(top =16.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {}, modifier = Modifier.weight(1f).padding(end = 16.dp).height(48.dp), shape = MaterialTheme.shapes.medium) {
                Text(text = "Buy")
            }
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary), modifier = Modifier.weight(1f).height(48.dp), shape = MaterialTheme.shapes.medium) {
                Text(text = "Sell")
            }
        }
    }
}