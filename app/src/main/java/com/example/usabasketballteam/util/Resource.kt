package com.example.usabasketballteam.util

import java.lang.Exception

/*
class is a generic sealed class with the possible response types
 */

sealed class Resource<out T> (
    val data: T? = null,
    val message: String? = null
    ) {
    // pass object of this Loading
    // class, just before making an api call
    class Loading<out T> : Resource<T>()

    // We'll wrap our data in this 'Success'
    // class in case of success response from api
    class Success<T>(data: T) : Resource<T>(data = data)

    //data class Success<out T>(val data: T): Resource<T>()
    // We'll pass error message wrapped in this 'Error'
    // class to the UI in case of failure response
    class Error<T>(errorMessage: String) : Resource<T>(message = errorMessage)
    data class Failure(val exception: Exception) : Resource<Nothing>()
}