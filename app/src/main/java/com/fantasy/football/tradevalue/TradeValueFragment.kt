package com.fantasy.football.tradevalue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fantasy.football.AppDatabase
import com.fantasy.football.R
import com.fantasy.football.bestunownedteam.MainViewModel
import com.fantasy.football.databinding.TradeValueFragmentBinding
import kotlinx.coroutines.launch

class TradeValueFragment : Fragment() {

    private var _binding: TradeValueFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: SearchView
    private lateinit var db: AppDatabase
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: MainViewModel
    private lateinit var playerValues: List<PlayerValue>
    private lateinit var adapter: CustomAdapter2

    //private lateinit var spinnerSortBy: Spinner
    private var searchText: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = TradeValueFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        /*
        spinnerSortBy = binding.spinnerSortBy
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.sort_by_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSortBy.adapter = adapter
        }

        spinnerSortBy.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                lifecycleScope.launch { //Main
                    //IO
                    when (position) {
                        0 -> {
                            playerValues =
                                db.PlayerValueDao().getPlayerValuesPoints() as List<PlayerValue>
                                viewModel.playerValues.setValue(playerValues)
                        }

                        1 -> {
                            playerValues =
                                db.PlayerValueDao().getPlayerValuesRank() as List<PlayerValue>
                                viewModel.playerValues.setValue(playerValues)
                        }

                        2 -> {
                            playerValues =
                                db.PlayerValueDao().getPlayerValuesPosition() as List<PlayerValue>
                                viewModel.playerValues.setValue(playerValues)
                        }
                        3 -> {
                            playerValues =
                                db.PlayerValueDao().getPlayerValuesTeam() as List<PlayerValue>
                                viewModel.playerValues.setValue(playerValues)
                        }

                        else -> {
                            playerValues =
                                db.PlayerValueDao().getPlayerValuesPoints() as List<PlayerValue>
                                viewModel.playerValues.setValue(playerValues)
                        }
                    }
                }
            }
        }
        */

        searchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    searchText = newText
                }
                adapter.filter.filter(newText)
                adapter.notifyDataSetChanged()
                return false
            }
        })

        //This is so horribly hackish.  Fix your crap google!
        val closeButtonId =
            searchView.context.resources.getIdentifier("android:id/search_close_btn", null, null)
        val closeButton = searchView.findViewById<View>(closeButtonId) as ImageView
        closeButton.setOnClickListener {

            searchView.setQuery("", true)
            adapter.filter.filter(" ")
            adapter.notifyDataSetChanged()
        }

        viewModel = MainViewModel()
        db = AppDatabase.getInstance(requireContext())!!
        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch { //Main
            //IO
            playerValues = db.PlayerValueDao().getPlayerValuesPoints() as List<PlayerValue>
            viewModel.playerValues.setValue(playerValues)
        }

        val observer1 = Observer<List<PlayerValue>> { newPlayerValues ->

            adapter = CustomAdapter2(newPlayerValues as ArrayList<PlayerValue>)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        viewModel.playerValues.observe(viewLifecycleOwner, observer1)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}