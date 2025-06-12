package com.konec.composechat

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.konec.composechat.ui.theme.ComposeChatTheme
import com.konec.composechat.viewmodel.ChatViewModel

@Composable
    fun ChatNavigationBar(selectedIndex:Int,onSelected:(Int)-> Unit) {
        Row(Modifier.background(ComposeChatTheme.colors.bottomBar)) {
            TabItem(R.drawable.ic_chat_filled,R.drawable.ic_chat_outlined,
                selectedIndex,0, "聊天",onSelected,
                Modifier.weight(1f),)
            TabItem(R.drawable.ic_contacts_filled,R.drawable
                .ic_contacts_outlined,selectedIndex,1, "通讯录",onSelected,Modifier.weight(1f))
            TabItem(R.drawable.ic_discovery_filled,R.drawable.ic_discovery_outlined,selectedIndex,2, "发现",onSelected,Modifier.weight(1f))
            TabItem(R.drawable.ic_me_filled,R.drawable.ic_me_outlined,selectedIndex,3, "我的",onSelected,Modifier.weight(1f))
        }
    }

    @Composable
    private fun TabItem(@DrawableRes selectedIconId:Int, @DrawableRes
    unselectedIconId:Int, currentIndex:Int, itemIndex:Int, title:String, onSelected: (Int) -> Unit,
                        modifier: Modifier= Modifier) {
        Column(modifier.padding(top = 10.dp,bottom = 6.dp).clickable{
            onSelected(itemIndex)
        },
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(painterResource(if (currentIndex==itemIndex) selectedIconId else unselectedIconId),title,
                Modifier.size(24.dp), tint = if (currentIndex==itemIndex) ComposeChatTheme.colors.iconCurrent
                else ComposeChatTheme.colors.icon)
            Text(title, fontSize = 11.sp, color = if (currentIndex==itemIndex) ComposeChatTheme
                .colors.iconCurrent else ComposeChatTheme.colors.icon)
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun ChatNavigationBarPreview(){
        var selectTab by remember { mutableIntStateOf(0) }
        ComposeChatTheme(ComposeChatTheme.Theme.Dark){
            ChatNavigationBar(selectTab, onSelected = {
                selectTab = it
            })
        }

    }


