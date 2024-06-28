package com.example.sdui.utils

import com.example.sdui.data.model.adapter.RatioQualifierAdapter
import com.example.sdui.data.model.component.Component
import com.example.sdui.data.model.enumclass.ComponentType
import com.example.sdui.data.model.enumclass.ComponentTypeAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiUtil {
    fun getMoshi(): Moshi {
        val componentAdapter =
            PolymorphicJsonAdapterFactory
                .of(Component::class.java, "type")
                .withSubtype(Component.LazyColumn::class.java, ComponentType.LazyColumn.value)
                .withSubtype(Component.Image::class.java, ComponentType.IMAGE.value)
                .withSubtype(Component.Column::class.java, ComponentType.Column.value)
                .withSubtype(Component.RowColumn::class.java, ComponentType.RowColumn.value)
                .withSubtype(Component.Text::class.java, ComponentType.Text.value)
                .withDefaultValue(Component.Unknown)

        return Moshi
            .Builder()
            .add(componentAdapter)
            .add(ComponentTypeAdapter)
            .add(RatioQualifierAdapter)
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}
