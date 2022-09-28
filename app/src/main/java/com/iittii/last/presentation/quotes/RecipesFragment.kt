package com.iittii.last.presentation.quotes

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.iittii.last.R
import com.iittii.last.RecipeDetailsFragment
import com.iittii.last.adapter.OnClickInterface
import com.iittii.last.adapter.RecipesAdapter
import com.iittii.last.databinding.FragmentRecipesBinding
import com.iittii.last.model.Result

class RecipesFragment : Fragment(), SearchView.OnQueryTextListener,
    SearchView.OnCloseListener {

    private lateinit var adaptar: RecipesAdapter
    private lateinit var binding: FragmentRecipesBinding
    private lateinit var viewModel: RecipeViewModel
    private lateinit var searchView: SearchView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(inflater)

        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        initviews()
        observeViewModel()
        setuprv()

        return binding.root
    }

    private fun setuprv() {
//        adaptar=RecipesAdapter(context)
        adaptar = RecipesAdapter(object : OnClickInterface {
            override fun onClick(result: Result) {
                // navigate to recipe details fragment - with result
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.containerB, RecipeDetailsFragment().apply { detail = result })?.addToBackStack(null)?.commit()
            }
        })
        val linearlayoutmanager = LinearLayoutManager(context)
        binding.recipeRv.layoutManager = linearlayoutmanager
        binding.recipeRv.addItemDecoration(
            DividerItemDecoration(
                context,
                linearlayoutmanager.orientation
            )
        )
        binding.recipeRv.adapter = adaptar
    }

    private fun observeViewModel() {
//        viewModel.qoutesLiveData.observe(context){
        viewModel.qoutesLiveData.observe(viewLifecycleOwner) {
            Log.d("TAG", "observeViewModel: $it")
            adaptar.setData(it)
            binding.progressBar.isVisible = false
        }
    }

    private fun initviews() {
        binding.progressBar.isVisible = true
//        ViewModel.getQuotes()
        viewModel.getRecipes()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar_menu, menu)

        val search = menu.findItem(R.id.menu_search)

        searchView = search.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)
        searchView.setOnCloseListener(this)

    }

    private fun searchRecipes(query: String?) {
        query?.let {
            viewModel.getRecipes(it)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchRecipes(query)
        return true
    }


    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }

    override fun onClose(): Boolean {
        searchView.onActionViewCollapsed()
        return true
    }
}