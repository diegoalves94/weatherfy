package com.diego.weatherfyapp.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.diego.weatherfyapp.R
import com.diego.weatherfyapp.adapters.WeatherAdapter
import com.diego.weatherfyapp.api.OpenWeatherApi
import com.diego.weatherfyapp.api.model.WeatherResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapterWeather: WeatherAdapter
    var cities: Array<String> = arrayOf("Curitiba", "London", "New York", "Los Angeles", "Chicago")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }


    /*
    *Set adapter and call the request.
    * */
    private fun init() {
        setWeatherAdapter()
        getWeather()
    }


    /*
    *Get weather info from api.
    * */
    private fun getWeather() {
        //start animation
        frameLoading.visibility = View.VISIBLE
        anim_load.playAnimation()

        cities.forEach { city ->
            try {
                OpenWeatherApi.create(this).getWeather(city, getString(R.string.units), getString(R.string.app_id))
                    .enqueue(object : Callback<WeatherResponse> {
                        override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                            response?.body()?.let { d ->
                                //populate the city list
                                adapterWeather.add(d)

                                //finish animation
                                frameLoading.visibility = View.GONE
                            }
                        }

                        override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                            t?.let {
                                t.printStackTrace()
                            }
                        }
                    })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    /*
    *Set the adapter for the list of cities.
    * */
    @SuppressLint("WrongConstant")
    fun setWeatherAdapter() {
        //set adapter
        adapterWeather = WeatherAdapter(this)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL

        listaCidades.layoutManager = llm
        listaCidades.adapter = adapterWeather
    }

}
