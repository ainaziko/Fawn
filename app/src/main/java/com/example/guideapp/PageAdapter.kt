package com.example.guideapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                RestaurantFragment()
            }
            1 -> {
                CinemaFragment()
            }
            2 -> {
                MallFragment()
            }
            3 ->{
                ParksFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}