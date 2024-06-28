package com.example.core.model.sdui

data class SduiModel(
    val id: String? = "",
    val pattern: String? = "",
    val body: Body? = null
)

data class Body(
    val type: String? = "",
    val url: String? = "",
    val ratio: String? = ""
)



data class ImageSdui(
    val url: String? = "",
    val ratio: String? = ""
)
