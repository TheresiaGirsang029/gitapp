package com.dicoding.gitapp.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.gitapp.ui.fragment.FragmentFollowers
import com.dicoding.gitapp.ui.fragment.FragmentFollowing

class AdapterPager (activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position){
            0 -> fragment = FragmentFollowers()
            1 -> fragment = FragmentFollowing()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}