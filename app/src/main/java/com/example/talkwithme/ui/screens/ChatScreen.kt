package com.example.talkwithme.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.talkwithme.data.chatlist
import com.example.talkwithme.domain.ChatListDataObject
import com.example.talkwithme.ui.components.UserDetails
import com.example.talkwithme.ui.components.UserImage

@Composable
fun ChatScreen(chatlist: List<ChatListDataObject>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(com.example.talkwithme.data.chatlist){ chatData->
            ChatlistItem(chatData)

        }
    }
}
@Composable
fun  ChatlistItem(chatData: ChatListDataObject) {
    Row ( modifier =  Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ){

        UserImage(chatData.userImage)
        UserDetails(chatData)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatsScreenPreview(){
    ChatScreen(chatlist)
}