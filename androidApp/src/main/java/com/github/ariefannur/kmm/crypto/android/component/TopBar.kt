package com.github.ariefannur.kmm.crypto.android.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.ariefannur.kmm.crypto.android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(isDarkMode: Boolean = false, onChangeMode: (Boolean) -> Unit = {}) {
    var menuExpanded by rememberSaveable { mutableStateOf(false) }

    Row (
        modifier = Modifier.height(80.dp)
    ){
        Image(
            painter = painterResource(R.drawable.avatar_1),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(1.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)
        )
        Spacer(modifier = Modifier.weight(1f).fillMaxHeight())
        IconButton(
            modifier = Modifier.padding(16.dp),
            onClick = { menuExpanded = !menuExpanded }
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Localized description"
            )
        }
    }
    /*TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.tertiary,
        ),
        navigationIcon = {

        },
        actions = {
            IconButton(onClick = { menuExpanded = !menuExpanded }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Localized description"
                )
            }
            DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = !menuExpanded }) {
                DropdownMenuItem(text = {
                    Text(text = stringResource(if (isDarkMode) R.string.light_mode else R.string.dark_mode))
                }, onClick = {
                    menuExpanded = !menuExpanded
                    onChangeMode.invoke(!isDarkMode)
                })
            }
        },
        title = {}
    )*/
}