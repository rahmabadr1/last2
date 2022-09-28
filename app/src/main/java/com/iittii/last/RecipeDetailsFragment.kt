package com.iittii.last

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iittii.last.databinding.FragmentDetailsBinding
import com.iittii.last.model.Result
import com.iittii.last.util.Constants
import com.squareup.picasso.Picasso

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
        val detail= it.get("result") as Result
            Picasso.get().load(detail.image).into(binding.mainImageView)
            binding.titleTv.text=detail.title
            binding.likesTextView.text= detail.aggregateLikes.toString()
            binding.clockTextView.text=detail.readyInMinutes.toString()



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
