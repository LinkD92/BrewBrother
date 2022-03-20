package com.symbol.brewbrother.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.model.FragEditBrewViewModel
import com.symbol.brewbrother.model.FragEditBrewViewModelFactory
import com.symbol.brewbrother.utility.BrewApplication

class FragEditBrew : Fragment() {
    private val TAG = javaClass.simpleName

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
        val tietRemarks = view.findViewById<TextInputEditText>(R.id.tietBrewRemarks)
        var brew = args.brew
        tietBrewName.setText(brew?.name)
        tietRemarks.setText(brew?.remarks)

        fabConfirmChanges.setOnClickListener {
            var brewName = tietBrewName.text.toString()
            var brewRemarks = tietRemarks.text.toString()
            brew = brew ?: Brew(brewName)
            brew!!.name = brewName
            brew!!.remarks = brewRemarks
            viewModel.insert(brew!!)

        }


        return view
    }



}
