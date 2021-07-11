package com.example.chooseyoufavorite.View.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chooseyoufavorite.ARG_OBJECT
import com.example.chooseyoufavorite.Models.AppState
import com.example.chooseyoufavorite.Models.CategoryList
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.View.Adapters.CategoryListAdapter
import com.example.chooseyoufavorite.ViewModel.MainViewModel
import com.example.chooseyoufavorite.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()
    private var adapter: CategoryListAdapter? = null
    private var currentCategory: String = "Movie"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val tabNames = resources.getStringArray(R.array.categories)
            binding.recyclerViewMovies.adapter = adapter
            binding.textView.text = ARG_OBJECT
            binding.textView.text = tabNames[getInt(ARG_OBJECT)-1]
            currentCategory = tabNames[getInt(ARG_OBJECT)-1]
            viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
            viewModel.getCinemaList(currentCategory)
        }
    }



    private fun renderData(appState: AppState) = with(binding){
        when (appState) {
            is AppState.Success -> {
                loadingLayout.visibility = View.GONE
                adapter = CategoryListAdapter(object : MainFragment.OnItemViewClickListener {
                    override fun onItemViewClick(category: CategoryList) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(MainFragment.BUNDLE_EXTRA, category)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, MainFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }
                ).apply {
                    setCategory(appState.categoryData)
                }
                recyclerViewMovies.adapter = adapter
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                loadingLayout.visibility = View.GONE
                Snackbar
                    .make(binding.recyclerViewMovies, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getCinemaList("Music") }
                    .show()
            }
        }
    }

    private fun putParcelable(bundleExtra: String, category: CategoryList) {

    }

    interface OnItemViewClickListener {
        fun onItemViewClick(category: CategoryList)
    }

    companion object {
        const val BUNDLE_EXTRA = "category"

        fun newInstance(bundle: Bundle): MainFragment {
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}