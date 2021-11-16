package com.example.chooseyoufavorite.view


import android.os.Bundle
import android.view.View
import com.example.chooseyoufavorite.ViewBindingFragment
import com.example.chooseyoufavorite.databinding.FragmentCategoriesBinding
import com.example.chooseyoufavorite.view.Movies.details.CinemaFragment


class CategoriesFragment : ViewBindingFragment<FragmentCategoriesBinding>(FragmentCategoriesBinding::inflate) {

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        binding.btn1.setOnClickListener {
//            activity?.supportFragmentManager?.apply {
//                beginTransaction()
//                    .add(binding.frameCat, CinemaFragment.newInstance(Bundle().apply {
//                        putParcelable(CinemaFragment.BUNDLE_EXTRA, "220")
//                    }))
//                    .addToBackStack("")
//                    .commitAllowingStateLoss()
//            }
//        }
//    }

    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}