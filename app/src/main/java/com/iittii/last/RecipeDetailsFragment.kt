package com.iittii.last

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iittii.last.databinding.FragmentDetailsBinding
import com.iittii.last.model.Result

class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        details()
        return binding.root
    }

    private fun details() {
        arguments?.let {
        val detail= it.getString("result","")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(result: Result) =
            RecipeDetailsFragment().apply {
                arguments?.apply {
                    putString("result", result.toString())

                }
            }
    }
     }
