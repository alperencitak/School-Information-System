package com.alperencitak.sis.viewcomponent

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ElevatedCardComp(onClick: () -> Unit, text: String) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(36.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}