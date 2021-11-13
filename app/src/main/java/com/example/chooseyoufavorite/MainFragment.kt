package com.example.chooseyoufavorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chooseyoufavorite.databinding.FragmentMainBinding

class MainFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main,container, false)
        return rootView
    }

    companion object{
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}