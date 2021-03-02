package com.example.nytpoc.model

data class ApiResponse<D>(
    val copyright: String,
    val num_results: Int,
    val results: D,
    val status: String
)