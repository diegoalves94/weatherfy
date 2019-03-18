package com.diego.weatherfyapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<T,VH: RecyclerView.ViewHolder>(context: Context) : RecyclerView.Adapter<VH>() {
    protected val selectorList: ArrayList<T> = ArrayList()
    protected var inflater: LayoutInflater =  LayoutInflater.from(context)
    var itemOnClick: (T) -> Unit = {_ ->  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return onBindViewHolder(holder,position)
    }

    override fun getItemCount(): Int {
        return selectorList.size
    }

    fun add(selector: T){
        this.selectorList.add(selector)
        notifyItemInserted(this.selectorList.size - 1)
    }

    fun replace(selector: ArrayList<T>){
        this.selectorList.clear()
        this.selectorList.addAll(selector)
        notifyDataSetChanged()
    }

    fun itens():ArrayList<T> {
        return selectorList
    }

    fun addAll(selector: ArrayList<T>){
        this.selectorList.addAll(selector)
        notifyDataSetChanged()
    }

    fun clear(){
        this.selectorList.clear()
        notifyDataSetChanged()
    }

    fun remove(selector: T){
        this.selectorList.remove(selector)
        notifyDataSetChanged()
    }

}