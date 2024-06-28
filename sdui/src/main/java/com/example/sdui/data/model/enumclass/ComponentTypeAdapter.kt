package com.example.sdui.data.model.enumclass

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal object ComponentTypeAdapter {
    @ToJson
    fun toJson(value: ComponentType?): String? = value?.value

    @FromJson
    fun fromJson(value: Any?): ComponentType? = ComponentType.entries.firstOrNull { it.value == value.toString() }
}
