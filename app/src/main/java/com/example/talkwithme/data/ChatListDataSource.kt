package com.example.talkwithme.data

import com.example.talkwithme.domain.ChatListDataObject
import com.example.talkwithme.domain.Message
import com.example.talkwithme.domain.MessageDeliveryStatus
import com.example.talkwithme.domain.MessageType

val chatlist = listOf(
    ChatListDataObject(
        chatId = 1,
        message = Message(
            content = "Good morning",
            timeStamp = "27/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = null
        ),
        userName = "Sagar"
    ),

    ChatListDataObject(
        chatId = 3,
        message = Message(
            content = "Hey, how are you?",
            timeStamp = "26/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.SENT,
            unreadCount = 2
        ),
        userName = "Alice"
    ),
    ChatListDataObject(
        chatId = 4,
        message = Message(
            content = "Let's meet at 5 PM",
            timeStamp = "25/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ,
            unreadCount = 1
        ),
        userName = "Bob"
    ),
    ChatListDataObject(
        chatId = 5,
        message = Message(
            content = "Did you finish the report?",
            timeStamp = "24/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = 5
        ),
        userName = "Charlie"
    ),
    ChatListDataObject(
        chatId = 6,
        message = Message(
            content = "Call me when you're free",
            timeStamp = "23/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.SENT,
            unreadCount = 3
        ),
        userName = "David"
    ),
    ChatListDataObject(
        chatId = 7,
        message = Message(
            content = "Happy Birthday!",
            timeStamp = "22/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ,
            unreadCount = null
        ),
        userName = "Eva"
    ),
    ChatListDataObject(
        chatId = 8,
        message = Message(
            content = "Check your email",
            timeStamp = "21/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = 7
        ),
        userName = "Frank"
    ),
    ChatListDataObject(
        chatId = 9,
        message = Message(
            content = "Meeting at 3 PM",
            timeStamp = "20/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ,
            unreadCount = 4
        ),
        userName = "Grace"
    ),
    ChatListDataObject(
        chatId = 10,
        message = Message(
            content = "Are you coming to the party?",
            timeStamp = "19/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.SENT,
            unreadCount = 8
        ),
        userName = "Hannah"
    ),
    ChatListDataObject(
        chatId = 11,
        message = Message(
            content = "Thank you!",
            timeStamp = "18/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = null
        ),
        userName = "Ian"
    ),
    ChatListDataObject(
        chatId = 12,
        message = Message(
            content = "Can we reschedule?",
            timeStamp = "17/02/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ,
            unreadCount = 1
        ),
        userName = "Judy"
    )
)
