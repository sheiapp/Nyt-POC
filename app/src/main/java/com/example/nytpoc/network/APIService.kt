package com.example.nytpoc.network


import com.example.nytpoc.model.ApiResponse
import com.example.nytpoc.model.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {

    @GET("{section}/1.json?api-key=Zdie6yIOJDMopbnlAnmJ3Q45S2piAQkr")
    suspend fun getMostPopularApiResponse(@Path("section") section: String): Response<ApiResponse<List<Results>>>

}