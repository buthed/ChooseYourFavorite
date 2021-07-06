package com.example.chooseyoufavorite

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : FragmentActivity() {

    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


//    private val tabNames1: Array<String> = arrayOf(
//        "Первый",
//        "Второй",
//    )

    private val tabNumbers: Array<Int> = arrayOf(
        R.drawable.icon_movie_category,
        R.drawable.icon_music_category
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabNames = resources.getStringArray(R.array.categories)
//        val tabNumbers1 = resources.getIntArray(R.array.categories_icons)
        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
            tab.setIcon(tabNumbers[position])
        }.attach()
    }


}