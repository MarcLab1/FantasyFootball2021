package com.fantasy.football.bestunownedteam

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val ARG_PAGENO = "pageno"
private const val NUMBER_OF_WEEKS : Int = 17

class WeekFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return NUMBER_OF_WEEKS
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = WeekFragment()

        fragment.arguments = Bundle().apply {
            putInt(ARG_PAGENO, position + 1)
        }
        return fragment
    }
}

