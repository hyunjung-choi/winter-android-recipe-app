package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.theme.Primary100

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
    iconSizePercent: Float = 1.0f,
    onClick: () -> Unit = {},
) {
    val configuration = LocalConfiguration.current
    val fontScale = configuration.fontScale
    val baseIconSize = 20.dp
    val calculateIconSize = baseIconSize * iconSizePercent * fontScale

    Box(
        modifier = modifier
            .width(40.dp)
            .height(40.dp)
            .background(
                color = Primary100,
                shape = RoundedCornerShape(10.dp),
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier.size(calculateIconSize),
            painter = painterResource(R.drawable.ic_filter),
            contentDescription = "Filter Button",
            tint = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterButtonPreview() {
    FilterButton()
}