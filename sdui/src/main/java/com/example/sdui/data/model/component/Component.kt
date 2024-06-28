package com.example.sdui.data.model.component

import android.os.Parcelable
import com.example.sdui.data.model.enumclass.ComponentContainerStyle
import com.example.sdui.data.model.enumclass.ComponentContentScale
import com.example.sdui.data.model.enumclass.ComponentPositions
import com.example.sdui.data.model.enumclass.ComponentType
import com.example.sdui.data.model.qualifier.RatioQualifier
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Component(
    open val type: ComponentType? = null,
    open val position: ComponentPositions? = null
) : Parcelable {

    data class LazyColumn(
        @Json(name = "type") override val type: ComponentType? = null,
        @Json(name = "position") override val position: ComponentPositions? = null,
        @Json(name = "body") val body: List<Component>? = null,
    ) : Component(
        type,
        position,
    )

    data class Image(
        @Json(name = "type") override val type: ComponentType? = null,
        @Json(name = "url") val url: String? = null,
        @Json(name = "width") val width: Int? = null,
        @Json(name = "height") val height: Int? = null,
        @Json(name = "style") val style: ComponentContainerStyle? = null,
        @Json(name = "ratio") @RatioQualifier val ratio: Float? = null,
        @Json(name = "contentScale") val contentScale: ComponentContentScale? = null,
    ) : Component(
        type,
    )

    data class RowColumn(
        @Json(name = "type") override val type: ComponentType? = null,
        @Json(name = "position") override val position: ComponentPositions? = null,
        @Json(name = "list") val list: List<Component>? = null,
        @Json(name = "width") val width: Int? = null,
        @Json(name = "height") val height: Int? = null,
        @Json(name = "padding") val padding: Int? = null,
        @Json(name = "spacing") val spacing: Int? = null
    ) : Component(
        type,
        position,
    )

    data class Column(
        @Json(name = "type") override val type: ComponentType? = null,
        @Json(name = "position") override val position: ComponentPositions? = null,
        @Json(name = "list") val list: List<Component>? = null,
        @Json(name = "width") val width: Int? = null,
        @Json(name = "height") val height: Int? = null,
        @Json(name = "padding") val padding: Int? = null,
        @Json(name = "spacing") val spacing: Int? = null
    ) : Component(
        type,
        position,
    )

    data class Text(
        @Json(name = "type") override val type: ComponentType? = null,
        @Json(name = "position") override val position: ComponentPositions? = null,
        @Json(name = "text") val text: String? = null,
        @Json(name = "size") val size: Int? = null,
        @Json(name = "color") val hexColor: String? = null,
        @Json(name = "padding") val padding: Int? = null,
        @Json(name = "spacing") val spacing: Int? = null
    ) : Component(
        type,
        position,
    )

    data object Unknown : Component()
}