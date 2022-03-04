package com.symbol.brewbrother.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.model.FragEditBrewViewModel
import com.symbol.brewbrother.model.FragEditBrewViewModelFactory
import com.symbol.brewbrother.utility.BrewApplication

class FragEditBrew : Fragment() {

    companion object {
        fun newInstance() = FragEditBrew()
    }


    private val viewModel: FragEditBrewViewModel by viewModels {
        FragEditBrewViewModelFactory((activity?.application as BrewApplication).repository)
    }

    val args: FragEditBrewArgs by navArgs()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_edit_brew, container, false)
        val fabConfirmChanges = view.findViewById<FloatingActionButton>(R.id.fabConfirmChanges)
        val tietBrewName = view.findViewById<TextInputEditText>(R.id.tietBrewName)
        var brew = args.brew

        tietBrewName.setText(brew?.name)
        fabConfirmChanges.setOnClickListener {
            var brewName = tietBrewName.text.toString()
            if(brew != null){
                brew.name = brewName
                viewModel.update(brew)
            }else{
                var brew = Brew(brewName)
                viewModel.insert(brew)
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FragEditBrewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
