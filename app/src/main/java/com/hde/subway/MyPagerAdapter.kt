package com.hde.subway

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentActivity:FragmentActivity, list:MutableList<String>) : FragmentStateAdapter(fragmentActivity){

    var fragments = ArrayList<Fragment>()

    // TODO: 여기 어댑터 다시 코드 읽기

    init {
        list.forEach {
            fragments.add(Tab1Fragment())
        }
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}
