package com.diego.weatherfyapp.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.diego.weatherfyapp.R
import com.diego.weatherfyapp.adapters.WeatherAdapter
import com.diego.weatherfyapp.extras.dialogExit
import com.diego.weatherfyapp.extras.toolbarSettings
import kotlinx.android.synthetic.main.activity_main.*

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



        setWeatherAdapter()
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
