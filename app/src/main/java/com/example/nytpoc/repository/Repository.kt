package com.example.nytpoc.repository

import com.example.nytpoc.model.ApiResponse
import com.example.nytpoc.model.Results
import com.example.nytpoc.utils.Resource

interface Repository {
    suspend fun getApiResponse(): Resource<ApiResponse<List<Results>>>
}