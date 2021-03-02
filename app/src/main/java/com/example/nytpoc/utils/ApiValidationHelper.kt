package com.example.nytpoc.utils

import retrofit2.Response

const val failedToReachServer = "Couldn't reach the server. Check your internet connection"
const val internalServerError = "Something went wrong, Please try again."

suspend fun <T> apiValidator(call: suspend () -> Response<T>): Resource<T> {
    return try {
        val response = call.invoke()
        if (response.isSuccessful) {
            response.body()?.let {
                return@let Resource.success(it)
            } ?: Resource.error(internalServerError, null)
        } else {
            Resource.error(internalServerError, null)
        }
    } catch (e: Exception) {
        Resource.error(failedToReachServer, null)
    }
}

