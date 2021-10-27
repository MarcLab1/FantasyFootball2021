package com.fantasy.football

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fantasy.football.bestunownedteam.BestUnownedFragment
import com.fantasy.football.tradevalue.TradeValueFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return BestUnownedFragment()
            }
            1 -> {
               return TradeValueFragment()
            }
            else -> return BestUnownedFragment()
        }
    }

    override fun getItemCount(): Int {
        return numTabs
    }
}