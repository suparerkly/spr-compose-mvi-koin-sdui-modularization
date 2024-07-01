package com.example.sdui.ui.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sdui.data.model.component.Component
import com.example.sdui.ui.map.modifier.mapFontWeight
import com.example.sdui.utils.dialog.MinimalDialog

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    component: Component.Button
) {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        MinimalDialog { showDialog.value = false }
    }

    when (component.buttonStyle) {
        "Button" -> {
            Button(
                onClick = {

                },
                modifier = modifier
                    .padding(component.padding?.dp ?: 0.dp)
                    .fillMaxWidth(component.fillWeightStyle?.toFloat() ?: 0f)

            ) {
                Text(
                    component.text ?: "",
                    modifier = modifier
                        .padding(component.padding?.dp ?: 0.dp),
                    fontSize = component.size?.sp ?: 10.sp,
                    fontWeight = component.fontWeight?.mapFontWeight(),
                    fontStyle = if (component.fontStyle == true) FontStyle.Italic else FontStyle.Normal,
                    color = Color(
                        android.graphics.Color.parseColor(
                            component.hexColor ?: "#888888"
                        )
                    )
                )
            }
        }

        "Filled" -> {
            FilledTonalButton(
                onClick = {

                },
                modifier = modifier
                    .padding(component.padding?.dp ?: 0.dp)
                    .fillMaxWidth(component.fillWeightStyle?.toFloat() ?: 0f)

            ) {
                Text(
                    component.text ?: "",
                    modifier = modifier
                        .padding(component.padding?.dp ?: 0.dp),
                    fontSize = component.size?.sp ?: 10.sp,
                    fontWeight = component.fontWeight?.mapFontWeight(),
                    fontStyle = if (component.fontStyle == true) FontStyle.Italic else FontStyle.Normal,
                    color = Color(
                        android.graphics.Color.parseColor(
                            component.hexColor ?: "#888888"
                        )
                    )
                )
            }
        }

        "OUTLINED" -> {
            OutlinedButton(
                onClick = {
                    showDialog.value = true
                },
                modifier = modifier
                    .padding(component.padding?.dp ?: 0.dp)
                    .fillMaxWidth(component.fillWeightStyle?.toFloat() ?: 0f)

            ) {
                Text(
                    component.text ?: "",
                    modifier = modifier
                        .padding(component.padding?.dp ?: 0.dp),
                    fontSize = component.size?.sp ?: 10.sp,
                    fontWeight = component.fontWeight?.mapFontWeight(),
                    fontStyle = if (component.fontStyle == true) FontStyle.Italic else FontStyle.Normal,
                    color = Color(
                        android.graphics.Color.parseColor(
                            component.hexColor ?: "#888888"
                        )
                    )
                )
            }
        }

        "ELEVATED" -> {
            ElevatedButton(
                onClick = {

                },
                modifier = modifier
                    .padding(component.padding?.dp ?: 0.dp)
                    .fillMaxWidth(component.fillWeightStyle?.toFloat() ?: 0f)
            ) {
                Text(
                    component.text ?: "",
                    modifier = modifier
                        .padding(component.padding?.dp ?: 0.dp),
                    fontSize = component.size?.sp ?: 10.sp,
                    fontWeight = component.fontWeight?.mapFontWeight(),
                    fontStyle = if (component.fontStyle == true) FontStyle.Italic else FontStyle.Normal,
                    color = Color(
                        android.graphics.Color.parseColor(
                            component.hexColor ?: "#888888"
                        )
                    )
                )
            }
        }

        "TEXTBUTTON" -> {
            val openAlertDialog = remember { mutableStateOf(false) }
            TextButton(
                onClick = {

                },
                modifier = modifier
                    .padding(component.padding?.dp ?: 0.dp)
                    .fillMaxWidth(component.fillWeightStyle?.toFloat() ?: 0f)
            ) {
                Text(
                    component.text ?: "",
                    modifier = modifier
                        .padding(component.padding?.dp ?: 0.dp),
                    fontSize = component.size?.sp ?: 10.sp,
                    fontWeight = component.fontWeight?.mapFontWeight(),
                    fontStyle = if (component.fontStyle == true) FontStyle.Italic else FontStyle.Normal,
                    color = Color(
                        android.graphics.Color.parseColor(
                            component.hexColor ?: "#888888"
                        )
                    )
                )
            }
        }
    }
}
