package com.example.itquiz

data class Question (
    val id: Int,
    val question: String,
    val optionone: String,
    val optiontwo: String,
    val optionthree: String,
    val correctanswer: Int
)
