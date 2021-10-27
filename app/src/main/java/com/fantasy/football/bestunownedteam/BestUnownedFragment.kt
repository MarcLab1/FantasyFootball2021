package com.fantasy.football.bestunownedteam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.fantasy.football.databinding.BestUnownedFragmentBinding

import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch

class BestUnownedFragment : Fragment() {

    private lateinit var weekFragmentAdapter: WeekFragmentAdapter
    private lateinit var viewPager: ViewPager2

    private var _binding: BestUnownedFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = BestUnownedFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        weekFragmentAdapter = WeekFragmentAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = weekFragmentAdapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Week ${(position + 1)}"
        }.attach()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}