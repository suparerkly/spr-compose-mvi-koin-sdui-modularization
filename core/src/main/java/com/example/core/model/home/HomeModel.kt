package com.example.core.model.home

data class HomeModel(
    var home: Home? = null
)

data class Home(
    var type: String? = "",
    var data: List<dataResult>? = null
)

data class dataResult(
    var type_data: String? = "",
    var title: String? = "",
    var img: List<String>? = null
)