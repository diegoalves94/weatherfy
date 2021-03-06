package com.diego.weatherfyapp.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diego.weatherfyapp.R
import com.diego.weatherfyapp.api.model.Main
import com.diego.weatherfyapp.api.model.Weather
import com.diego.weatherfyapp.api.model.WeatherResponse
import kotlinx.android.synthetic.main.item_weather_card.view.*

class WeatherAdapter (context: Context) : BaseAdapter<WeatherResponse, WeatherAdapter.ViewHolder>(context) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set infos

        holder.nameCity.text = selectorList[position].name

        holder.maxTempeture.text = "${selectorList[position].main.temp_max}°C"

        holder.minTempeture.text = "${selectorList[position].main.temp_min}°C"

        holder.humidity.text = "${selectorList[position].main.humidity}%"

        holder.pressure.text = "${selectorList[position].main.pressure} mb"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.item_weather_card, parent, false)
        val mvh = ViewHolder(v)
        return mvh
    }

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        internal var nameCity: TextView = itemview.cityName_txt
        internal var maxTempeture: TextView = itemview.maxTempeture_txt
        internal var minTempeture: TextView = itemview.minTempeture_txt
        internal var humidity: TextView = itemview.humidity_txt
        internal var pressure: TextView = itemview.pressure_txt
    }
}