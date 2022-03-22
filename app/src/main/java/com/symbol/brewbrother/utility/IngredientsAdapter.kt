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

class IngredientsAdapter : ListAdapter<Brew.Ingredient, IngredientsAdapter.ViewHolder>(Diff()) {
    private val TAG = javaClass.simpleName



    // private var brewList = listOf<Brew>()
    private lateinit var listener: OnItemClickListener

    fun getIngredientPosition(position: Int): Brew.Ingredient {
        return getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ingredient = getItem(position)
        holder.bind(ingredient)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val amount = itemView.findViewById<TextView>(R.id.tvAmount)

        init {
            itemView.setOnClickListener {
                var ingredient = getItem(adapterPosition)
                listener.onItemClick(ingredient)
            }

        }

        fun bind(ingredient: Brew.Ingredient){
            name.text = ingredient.name
            amount.text = ingredient.amount.toString()
        }


    }

    interface OnItemClickListener{
        fun onItemClick(ingredient: Brew.Ingredient)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    class Diff: DiffUtil.ItemCallback<Brew.Ingredient>() {
        override fun areItemsTheSame(oldItem: Brew.Ingredient, newItem: Brew.Ingredient): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Brew.Ingredient, newItem: Brew.Ingredient): Boolean {
            return oldItem.name.equals(newItem.name)
        }


    }

}