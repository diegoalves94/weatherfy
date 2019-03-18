package com.diego.weatherfyapp.api

import android.content.Context
import com.diego.weatherfyapp.api.model.WeatherResponse
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface OpenWeatherApi {

    @GET("weather")
    fun getWeather(@Query("q") q:String, @Query("appid") appid:String): Call<WeatherResponse>

    /**
     * Companion object for the factory
     */
    companion object Factory {

        val URL = "https://api.openweathermap.org/data/2.5/"

        fun create(context: Context): OpenWeatherApi {

            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val headintercepter = Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")

                try {
                    val response = chain.proceed(request.build())

                    when(response.code()){
                        200-> return@Interceptor response
                        201-> return@Interceptor response
                        400-> return@Interceptor response
                        401-> return@Interceptor response
                        404-> return@Interceptor response
                        500-> return@Interceptor response
                        else-> return@Interceptor response
                    }

                }catch (x:Throwable){
                    throw x
                }
            }

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(6000, TimeUnit.MILLISECONDS)
                .readTimeout((1000 * 60).toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout((1000 * 60).toLong(), TimeUnit.MILLISECONDS)
                .addInterceptor(logInterceptor)
                .addInterceptor(headintercepter)
                .build()


            val gson = GsonBuilder()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(OpenWeatherApi::class.java)
        }
    }
}