package com.symbol.brewbrother.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.model.FragBrewListViewModel
import com.symbol.brewbrother.model.FragBrewListViewModelFactory
import com.symbol.brewbrother.utility.BrewApplication
import com.symbol.brewbrother.utility.BrewAdapter

class FragBrewList : Fragment() {
    private val TAG = javaClass.simpleName

    companion object {
        fun newInstance() = FragBrewList()
    }

    private val viewModel: FragBrewListViewModel by viewModels {
        FragBrewListViewModelFactory((activity?.application as BrewApplication).repository)

    }

    val args: Bundle? = arguments


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_brew_list, container, false)
        val rvBrewList = view.findViewById<RecyclerView>(R.id.rvBrewList)
        val fabAddNewBrew = view.findViewById<FloatingActionButton>(R.id.fabAddNewBrew)
        val adapter = BrewAdapter()

        rvBrewList.adapter = adapter
        rvBrewList.layoutManager = LinearLayoutManager(activity)
        rvItemEditOnClick(adapter)
        itemTouchHelper(adapter, rvBrewList)



        viewModel.allBrews.observe(this){
            brewList -> brewList.let {
            adapter.submitList(brewList)
            Log.d("$TAG - onCreateView:", "${brewList.size}")
            }
        }

        fabAddNewBrew.setOnClickListener {
           val action = FragBrewListDirections.actionFragBrewListToFragEditBrew(null)
            findNavController().navigate(action)
        }

        return view
    }

    private fun rvItemEditOnClick(adapter: BrewAdapter){
        adapter.setOnItemClickListener(object: BrewAdapter.OnItemClickListener{
            override fun onItemClick(brew: Brew) {
                Log.d(ContentValues.TAG, "VH: ${brew.name}")
                val action =  FragBrewListDirections.actionFragBrewListToFragEditBrew(brew)
                findNavController().navigate(action)
            }

        })
    }

    private fun itemTouchHelper(adapter: BrewAdapter, rvBrewList: RecyclerView){
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.delete(adapter.getBrewAtPosition(viewHolder.adapterPosition))
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(rvBrewList)
    }

}
