package com.example.talkwithme.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.talkwithme.data.chatlist
import com.example.talkwithme.data.tabs
import com.example.talkwithme.ui.components.AppBarComponent
import com.example.talkwithme.ui.components.TabBarComponent
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    Column {
        AppBarComponent()
        TabBarComponent(
            pagerState = pagerState,
            onTabSelected = { page ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(page)
                }
            }
        )

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            when (page) {
                0 -> ChatScreen(chatlist)
                1 -> StatusScreen()
                2 -> CallsScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}