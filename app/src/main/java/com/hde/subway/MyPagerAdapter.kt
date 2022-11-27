package com.hde.subway

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentActivity:FragmentActivity, list:MutableList<String>) : FragmentStateAdapter(fragmentActivity){

    var fragments = ArrayList<Fragment>()

    init {
        list.forEach {
            fragments.add(Tab1Fragment(it))
        }
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}
