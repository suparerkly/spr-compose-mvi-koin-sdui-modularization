package com.example.sdui.data.model.adapter

import com.example.sdui.data.model.qualifier.RatioQualifier
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal object RatioQualifierAdapter {
    @ToJson
    fun toJson(
        @RatioQualifier value: Float?,
    ): String? {
        if (value == null) {
            return null
        }

        return value.toString()
    }

    @FromJson
    @RatioQualifier
    fun fromJson(value: String?): Float? {
        if (value == null) {
            return null
        }

        val isRatio = Regex("""\b\d+:\d+\b""").matches(value.toString())
        return if (isRatio) {
            val list = value.split(":")
            list[0].toFloat() / list[1].toFloat()
        } else {
            null
        }
    }
}
