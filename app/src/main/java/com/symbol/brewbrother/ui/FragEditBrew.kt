package com.symbol.brewbrother.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.model.FragEditBrewViewModel
import com.symbol.brewbrother.model.FragEditBrewViewModelFactory
import com.symbol.brewbrother.utility.BrewApplication
import com.symbol.brewbrother.utility.IngredientsAdapter

class FragEditBrew : Fragment() {
    private val TAG = javaClass.simpleName
    val args: FragEditBrewArgs by navArgs()

    companion object {
        fun newInstance() = FragEditBrew()

    }



    private val viewModel: FragEditBrewViewModel by viewModels {
        FragEditBrewViewModelFactory((activity?.application as BrewApplication).repository)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_edit_brew, container, false)
        val fabConfirmChanges = view.findViewById<FloatingActionButton>(R.id.fabConfirmChanges)
        val tietBrewName = view.findViewById<TextInputEditText>(R.id.tietBrewName)
        val tietRemarks = view.findViewById<TextInputEditText>(R.id.tietBrewRemarks)
        val rvIngredients = view.findViewById<RecyclerView>(R.id.rvIngredients)
        val ibtnAddIngredients = view.findViewById<ImageButton>(R.id.ibtnAddIngredient)
        val adapter = IngredientsAdapter()
        rvIngredients.adapter = adapter
        rvIngredients.layoutManager = LinearLayoutManager(activity)


        var brew = args.brew

        tietBrewName.setText(brew?.name)
        tietRemarks.setText(brew?.remarks)
        var brewName = ""
        brew = brew ?: Brew(brewName)
        adapter.submitList(brew.ingredients)


        fabConfirmChanges.setOnClickListener {
            brewName = tietBrewName.text.toString()
            var brewRemarks = tietRemarks.text.toString()
            brew!!.name = brewName
            brew!!.remarks = brewRemarks
            viewModel.insert(brew!!)
        }

        ibtnAddIngredients.setOnClickListener {
            var ingredient =  Brew.Ingredient("test", 1)
            brew?.ingredients?.add(ingredient)
            adapter.notifyDataSetChanged()
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
