package com.symbol.brewbrother.ui

import android.content.ContentValues
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.model.FragBrewListViewModel
import com.symbol.brewbrother.model.FragBrewListViewModelFactory
import com.symbol.brewbrother.utility.BrewApplication
import com.symbol.brewbrother.utility.BrewRvAdapter

class FragBrewList : Fragment() {

    companion object {
        fun newInstance() = FragBrewList()
    }

    private val viewModel: FragBrewListViewModel by viewModels {
        FragBrewListViewModelFactory((activity?.application as BrewApplication).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_brew_list, container, false)
        val rvBrewList = view.findViewById<RecyclerView>(R.id.rvBrewList)
        val fabAddNewBrew = view.findViewById<FloatingActionButton>(R.id.fabAddNewBrew)
        val adapter = BrewRvAdapter()
        rvBrewList.adapter = adapter
        rvBrewList.layoutManager = LinearLayoutManager(activity)

        viewModel.allBrews.observe(this){
                brewList -> brewList.let {
            adapter.submitList(it)
            }
        }

        fabAddNewBrew.setOnClickListener {
            val action = FragBrewListDirections.actionFragBrewListToFragEditBrew()
            findNavController().navigate(action)
//            var i = 0
//            var brew = Brew("Brew no dupa 8")
//            viewModel.insert(brew)
//            i++
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        val viewModel: FragBrewListViewModel by viewModels {
//            FragBrewListViewModelFactory((activity?.application as BrewApplication).repository)
        }

}