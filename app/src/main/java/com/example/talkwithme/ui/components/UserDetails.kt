package com.example.talkwithme.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.talkwithme.domain.ChatListDataObject

@Composable
fun UserDetails(chatData: ChatListDataObject) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        MessageHeader(chatData)
        Spacer(modifier = Modifier.height(4.dp))
        MessageSubSection(chatData)
    }
}

@Composable
fun MessageHeader(chatData: ChatListDataObject) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = chatData.userName,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = chatData.message.timeStamp,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
        )
    }
}

@Composable
fun MessageSubSection(chatData: ChatListDataObject) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = chatData.message.content,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(2f)
        )

        chatData.message.unreadCount?.let { unreadCount ->
            if (unreadCount > 0) {
                Text(
                    text = unreadCount.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
