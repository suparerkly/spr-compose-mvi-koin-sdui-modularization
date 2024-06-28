package com.example.sdui.utils.extentions

import com.example.sdui.data.model.component.Component
import com.example.sdui.utils.MoshiUtil
import com.squareup.moshi.JsonDataException

fun String?.fromJsonComponent(): Component? {
    if (this == null) {
        return null
    }

    return try {
        MoshiUtil.getMoshi().adapter(Component::class.java).fromJson(this)
    } catch (e: JsonDataException) {
        null
    } catch (e: Throwable) {
        null
    }
}
