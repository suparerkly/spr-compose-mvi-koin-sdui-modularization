package com.example.features.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.features.R

@Composable
fun SettingScreen() {
    LazyColumn(contentPadding = PaddingValues(top = 30.dp)) {
        items(5) { list ->
            Row(modifier = Modifier.padding(15.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    modifier = Modifier
                        .size(20.dp),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.padding(start = 20.dp))
                Text("test")
            }
        }
    }
}