package com.iittii.last

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iittii.last.databinding.ActivityHomeBinding
import com.iittii.last.presentation.quotes.RecipesFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToRecipeFragment()
    }

    private fun navigateToRecipeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, RecipesFragment())
            .commit()
    }
}