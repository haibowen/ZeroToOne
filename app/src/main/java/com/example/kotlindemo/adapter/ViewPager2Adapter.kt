package com.example.kotlindemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created on 4/3/21
 * Author: hyplo
 * Email: haibowen088@gmail.com
 * Description: show me the code change the world
 */
class ViewPager2Adapter(fa: FragmentActivity,var list: MutableList<Fragment>) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {

        return list.size


    }

    override fun createFragment(position: Int): Fragment {

        return list.get(position)

    }

}