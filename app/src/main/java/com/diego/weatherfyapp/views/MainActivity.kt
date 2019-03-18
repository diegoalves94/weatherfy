package com.diego.weatherfyapp.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    //val listWeather: ArrayList<obj> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWeather()
    }

    /*
    *Get weather info from api.
    * */
    private fun getWeather(){
        try {
            OpenWeatherApi.create(this).getWeather("London", getString(R.string.app_id))
                .enqueue(object : Callback<WeatherResponse> {
                    override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                        response?.body()?.let { d->

                            setWeatherAdapter()
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


    /*
    *Set the adapter for the list of cities.
    * */
    @SuppressLint("WrongConstant")
    fun setWeatherAdapter(){
        //cartao lista temp
//        listCausa.add(CausaUcharm("https://storage.googleapis.com/petbacker/images/blog/2017/dog-and-cat-cover.jpg", "cats and dogs", true))
//        listCausa.add(CausaUcharm("https://storage.googleapis.com/petbacker/images/blog/2017/dog-and-cat-cover.jpg", "cats and dogs", false))
//        listCausa.add(CausaUcharm("https://storage.googleapis.com/petbacker/images/blog/2017/dog-and-cat-cover.jpg", "cats and dogs", false))
//        listCausa.add(CausaUcharm("https://storage.googleapis.com/petbacker/images/blog/2017/dog-and-cat-cover.jpg", "cats and dogs", true))

        //set adapter
        adapterWeather = WeatherAdapter(this)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL

       // adapterWeather.addAll(listWeather)

        listaCidades.layoutManager = llm
        listaCidades.adapter = adapterWeather
    }


}
