package com.iittii.last

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.iittii.last.adapter.viewpageradaptar
import com.iittii.last.databinding.FragmentRecipesBinding
import com.iittii.last.databinding.FragmentViewPagerBinding
import com.iittii.last.presentation.quotes.RecipeViewModel

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater)

        setupviewpager()

        return binding.root
    }


    private fun setupviewpager() {
        val icones = arrayOf(R.drawable.ic_book, R.drawable.ic_favorite)
        val adaptar = viewpageradaptar(requireActivity())
        binding.pager.adapter = adaptar
        TabLayoutMediator(binding.tap, binding.pager) { tab, position ->
            tab.setIcon(icones[position])
        }.attach()
    }

}