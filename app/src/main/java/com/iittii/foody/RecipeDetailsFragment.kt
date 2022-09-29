package com.iittii.foody

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.iittii.foody.databinding.FragmentDetailsBinding
import com.iittii.foody.model.Result
import com.squareup.picasso.Picasso
import org.jsoup.Jsoup

class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    lateinit var detail: Result

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        details()

        return binding.root
    }

    private fun details() {
        Picasso.get().load(detail.image).into(binding.mainImageView)
        binding.titleTv.text = detail.title
        binding.likesTextView.text = detail.aggregateLikes.toString()
        binding.clockTextView.text = detail.readyInMinutes.toString()

        binding.summaryTv.text = Jsoup.parse(detail.summary).text()

        if (detail.vegetarian) {
            binding.vegetarianIv.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.vegetarianTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
        if (detail.vegan) {
            binding.veganIv.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.veganTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
        if (detail.glutenFree) {
            binding.glutenFreeIv.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.glutenFreeTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
        if (detail.dairyFree) { binding.diaryFreeIv.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.diaryFreeTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
        if (detail.veryHealthy) {
            binding.healthyIv.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.healthyTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
        if (detail.cheap) {
            binding.cheapIv.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
            binding.cheapTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
    }
}
