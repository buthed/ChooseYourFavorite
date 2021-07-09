package com.example.chooseyoufavorite.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chooseyoufavorite.Models.AppState
import com.example.chooseyoufavorite.Models.CategoryList
import com.example.chooseyoufavorite.R
import com.example.chooseyoufavorite.View.Adapters.CategoryListAdapter
import com.example.chooseyoufavorite.ViewModel.MovieViewModel
import com.example.chooseyoufavorite.databinding.FragmentMoviesBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MovieViewModel by viewModel()
    private var adapter: CategoryListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewMovies.adapter = adapter
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getCinemaList()
    }

    private fun renderData(appState: AppState) = with(binding){
        when (appState) {
            is AppState.Success -> {
                loadingLayout.visibility = View.GONE
                adapter = CategoryListAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(category: CategoryList) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(MoviesFragment.BUNDLE_EXTRA, category)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, MoviesFragment.newInstance(bundle))
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
                    .setAction("Reload") { viewModel.getCinemaList() }
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

        fun newInstance(bundle: Bundle): MoviesFragment {
            val fragment = MoviesFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}
