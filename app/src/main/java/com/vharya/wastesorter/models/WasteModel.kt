package com.vharya.wastesorter.models

class WasteModel(
    val wasteId: Long,
    var name: String,
    var image: Int,
    var categoryId: Int,
    var categoryName: String
)