package com.iittii.foody

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.iittii.foody.adapter.viewpageradaptar
import com.iittii.foody.databinding.ActivityHomeBinding
import com.iittii.foody.presentation.quotes.RecipesFragment



class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
         setupviewpager()
        navigateToRecipeFragment()
    }

    private fun setupviewpager() {
        val titels = arrayOf("Recipes","Favorites")
        val icones = arrayOf(R.drawable.book,R.drawable.ic_favorite)
        val adaptar =viewpageradaptar(this)
        binding.pager.adapter=adaptar
        TabLayoutMediator(binding.tap , binding.pager){ tab ,position ->
            tab.text = titels[position]
            tab.setIcon(icones[position])
        }.attach()
    }


    private fun navigateToRecipeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.containerB, RecipesFragment())
            .commit()
    }
}