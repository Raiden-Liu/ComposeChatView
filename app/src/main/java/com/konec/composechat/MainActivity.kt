package com.konec.composechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.konec.composechat.ui.theme.ComposeChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeChatTheme {
                Column {
                    ChatNavigationBar(0)
                }
            }
        }
    }
}

@Composable
private fun ChatNavigationBar(selectedIndex:Int) {
    Row {
        TabItem(R.drawable.ic_chat_filled,R.drawable.ic_chat_outlined,selectedIndex,0, "聊天")
        TabItem(R.drawable.ic_contacts_filled,R.drawable.ic_contacts_outlined,selectedIndex,1, "通讯录")
        TabItem(R.drawable.ic_discovery_filled,R.drawable.ic_discovery_outlined,selectedIndex,2, "发现")
        TabItem(R.drawable.ic_me_filled,R.drawable.ic_me_outlined,selectedIndex,3, "我的")
    }
}

@Composable
private fun TabItem(@DrawableRes selectedIconId:Int,@DrawableRes unselectedIconId:Int,currentIndex:Int,itemIndex:Int,title:String) {
    Column {
        Icon(painterResource(if (currentIndex==itemIndex) selectedIconId else unselectedIconId),title)
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatNavigationBarPreview(){
    ChatNavigationBar(3)
}

@Preview(showBackground = true)
@Composable
private fun TabItemPreview(){
    TabItem(R.drawable.ic_chat_filled,R.drawable.ic_chat_outlined,0,0, "聊天")
}
