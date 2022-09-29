package com.iittii.foody.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iittii.foody.FavoFragment
import com.iittii.foody.presentation.quotes.RecipesFragment

class viewpageradaptar(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity) {
    val fragments= arrayOf(RecipesFragment(),FavoFragment())
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}