package com.example.talkwithme.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talkwithme.data.TabData
import com.example.talkwithme.data.tabs
import com.example.talkwithme.ui.theme.Green
import com.example.talkwithme.ui.theme.TalkWithMeTheme
import com.example.talkwithme.ui.theme.White
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabBarComponent(
     pagerState: PagerState,
     onTabSelected: (Int) -> Unit
) {
     val tabTitles = tabs.map { it.title }

     var selectedIndex by remember { mutableStateOf(0) }

     TabRow(
          selectedTabIndex = selectedIndex,
          modifier = Modifier.fillMaxWidth(),
          containerColor = Green,
          contentColor = Color.LightGray,
          indicator = { tabPositions ->
               TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    height = 4.dp,
                    color = White
               )
          }
     ) {
          tabs.forEachIndexed { index, tabData ->
               Tab(
                    selected = selectedIndex == index,
                    onClick = {
                         selectedIndex = index
                         onTabSelected(index)
                    },
                    text = { TabContent(tabData = tabData) }
               )
          }
     }

     // Synchronize tab selection with pager state
     LaunchedEffect(pagerState) {
          snapshotFlow { pagerState.currentPage }
               .collectLatest { page ->
                    selectedIndex = page
               }
     }
}

@Composable
fun TabContent(tabData: TabData) {
     if (tabData.unreadCount == null) {
          TabTitle(title = tabData.title)
     } else {
          TabWithUnreadCount(tabData = tabData)
     }
}

@Composable
fun TabTitle(title: String) {
     Text(
          text = title,
          style = TextStyle(
               fontSize = 16.sp
          )
     )
}

@Composable
fun TabWithUnreadCount(tabData: TabData) {
     Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
     ) {
          TabTitle(title = tabData.title)

          tabData.unreadCount?.also { unreadCount ->
               Text(
                    text = unreadCount.toString(),
                    modifier = Modifier
                         .padding(4.dp)
                         .size(16.dp)
                         .clip(CircleShape)
                         .background(MaterialTheme.colorScheme.background),
                    style = TextStyle(
                         color = MaterialTheme.colorScheme.primary,
                         textAlign = TextAlign.Center,
                         fontSize = 12.sp
                    )
               )
          }
     }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabBarComponentPreview() {
     TalkWithMeTheme {
          // Correctly instantiate PagerState for preview
          val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })
          TabBarComponent(
               pagerState = pagerState,
               onTabSelected = {}
          )
     }
}
