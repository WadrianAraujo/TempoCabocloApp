package com.wax.tempocabocloapp.network.api

import com.wax.tempocabocloapp.data.RemoteLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    companion object{
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY = "379bb2cbadba42e4a1e10806242607"
    }

    @GET("search.json")
    suspend fun searchLocation(
        @Query("key") key: String = API_KEY,
        @Query("q") query: String
    ): Response<List<RemoteLocation>>
}