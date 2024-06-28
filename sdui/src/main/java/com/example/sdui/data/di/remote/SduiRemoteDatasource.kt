package com.example.sdui.data.di.remote

import com.example.sdui.data.model.component.Component

interface SduiRemoteDatasource {
    suspend fun getSdui(url: String?): Component
}