package com.symbol.brewbrother.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.symbol.brewbrother.R
import com.symbol.brewbrother.model.FragEditBrewViewModel

class FragEditBrew : Fragment() {

    companion object {
        fun newInstance() = FragEditBrew()
    }

    private lateinit var viewModel: FragEditBrewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_edit_brew, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragEditBrewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}