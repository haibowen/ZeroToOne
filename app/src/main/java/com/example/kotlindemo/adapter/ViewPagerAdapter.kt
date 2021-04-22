package com.example.kotlindemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    lateinit var titls: List<String>
    lateinit var viewPagerFragment: List<Fragment>
    override fun getItem(position: Int): Fragment {
        return viewPagerFragment[position]
    }

    override fun getCount(): Int {
        return viewPagerFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titls[position]
    }

    fun setTitles(titles: List<String>) {
        this.titls = titles
    }

    fun setFragment(viewPagerFragment: List<Fragment>) {
        this.viewPagerFragment = viewPagerFragment
    }
}