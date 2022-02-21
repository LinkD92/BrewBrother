package com.symbol.brewbrother.utility

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew

class BrewRvAdapter: ListAdapter<Brew, BrewRvAdapter.ViewHolder>(BrewCompare()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var brew = getItem(position)
        holder.tvBrewName.text = brew.name
    }



    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        val tvBrewName = item.findViewById<TextView>(R.id.tvBrewName)

        companion object{
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.brew_rv_item, parent, false)
                return ViewHolder(view)
            }
        }

    }

    class BrewCompare: DiffUtil.ItemCallback<Brew>(){
        override fun areItemsTheSame(oldItem: Brew, newItem: Brew): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Brew, newItem: Brew): Boolean {
            return oldItem.name == newItem.name
        }
    }



}