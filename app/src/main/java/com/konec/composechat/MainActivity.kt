package com.konec.composechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.Column

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.konec.composechat.ui.theme.ComposeChatTheme
import com.konec.composechat.viewmodel.ChatViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel : ChatViewModel  = viewModel()
            ComposeChatTheme {
                Column {
                    ChatNavigationBar(viewModel.selectTab,onSelected = {
                        viewModel.selectTab = it
                    })
                }
            }
        }
    }
}


