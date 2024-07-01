package com.example.sdui.data.model.enumclass

enum class ComponentType(
    val value: String,
) {
    IMAGE("Image"),
    LazyColumn("LazyColumn"),
    LazyRow("LazyRow"),
    RowColumn("RowColumn"),
    Column("Column"),
    Text("Text"),
    Button("Button"),
    HorizontalPager("HorizontalPager"),
    Spacer("Spacer")

}