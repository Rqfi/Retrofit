package com.example.et

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("people")
    fun getCharacter(): Call<Responses>
}