package com.symbol.brewbrother.utility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew

class BrewAdapter : ListAdapter<Brew, BrewAdapter.ViewHolder>(Diff()) {

   // private var brewList = listOf<Brew>()
    private lateinit var listener: OnItemClickListener

    fun getBrewAtPosition(position: Int): Brew {
        return getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brew_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var brew = getItem(position)
        holder.bind(brew)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvBrewName = itemView.findViewById<TextView>(R.id.tvBrewName)
        val tvBrewID = itemView.findViewById<TextView>(R.id.tvBrewDate)

        init {
            itemView.setOnClickListener {
                var brew = getItem(adapterPosition)
                listener.onItemClick(brew)
            }

        }

        fun bind(brew: Brew){
            tvBrewName.text = brew.name
            tvBrewID.text = brew.date
        }


    }

    interface OnItemClickListener{
        fun onItemClick(brew: Brew)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    class Diff: DiffUtil.ItemCallback<Brew>() {
        override fun areItemsTheSame(oldItem: Brew, newItem: Brew): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Brew, newItem: Brew): Boolean {
            return oldItem.name.equals(newItem.name)
        }


    }

}