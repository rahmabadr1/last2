package com.iittii.last.presentation.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.iittii.last.adapter.RecipesAdapter
import com.iittii.last.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {
    private lateinit var adaptar:RecipesAdapter
    private lateinit var binding: FragmentRecipesBinding
    private lateinit var viewModel: QutoseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(inflater)
        viewModel=ViewModelProvider(this)[QutoseViewModel::class.java]
        initviews()
        observeViewModel()
        setuprv()

        return binding.root
    }

    private fun setuprv() {
        adaptar=RecipesAdapter(context)
        val linearlayoutmanager=LinearLayoutManager(context)
       binding.recipeRv.layoutManager =linearlayoutmanager
        binding.recipeRv.addItemDecoration(DividerItemDecoration(context,linearlayoutmanager.orientation))
        binding.recipeRv.adapter=adaptar
    }

    private fun observeViewModel() {
        viewModel.qoutesLiveData.observe(context){
            adaptar.setData(it)
        }
    }

    private fun initviews() {
        ViewModel.getQuotes()
    }
}