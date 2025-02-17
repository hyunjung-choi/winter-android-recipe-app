package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.theme.Black
import com.surivalcoding.composerecipeapp.ui.theme.Gray4
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsRegularTypography
import com.surivalcoding.composerecipeapp.ui.theme.Primary80

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    val isFocused = remember { mutableStateOf(false) }
    val borderColor = if (isFocused.value) Primary80 else Gray4
    val textColor = if (value.isNotEmpty()) Black else Gray4

    BasicTextField(
        modifier = modifier
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        value = value,
        onValueChange = onValueChange,
        textStyle = PoppinsRegularTypography.bodyLarge.copy(
            color = textColor,
            fontSize = 11.sp
        ),
        singleLine = true,
        cursorBrush = SolidColor(Color.Black),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, MaterialTheme.shapes.small)
                    .border(1.5.dp, borderColor, MaterialTheme.shapes.small)
                    .padding(horizontal = 10.dp, vertical = 12.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "Search",
                        tint = Gray4,
                    )
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = "Search recipe",
                                style = PoppinsRegularTypography.bodySmall.copy(color = Gray4),
                            )
                        }
                        innerTextField()
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchFieldPreview() {
    val textState = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        // Default
        SearchField(
            modifier = Modifier,
            value = textState.value,
            onValueChange = { textState.value = it },
        )

        // Focused
        SearchField(
            modifier = Modifier,
            value = textState.value,
            onValueChange = { textState.value = it },
        )
    }
}