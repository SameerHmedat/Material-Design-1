package com.example.materialdesign1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.materialdesign1.fragment.FavoritesFragment
import com.example.materialdesign1.fragment.MusicFragment
import com.example.materialdesign1.fragment.PainterFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when (position) {
            0 ->
                FavoritesFragment()
            1 ->
                MusicFragment()
            2 ->
                PainterFragment()
            else ->
                Fragment()

        }
    }
}