package com.konec.composechat.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {
    var selectTab by mutableIntStateOf(0) //使用mutable包裹，值改变了才会被监听，页面才会刷新
}