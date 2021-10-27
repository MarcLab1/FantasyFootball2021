package com.fantasy.football.bestunownedteam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fantasy.football.AppDatabase
import kotlinx.coroutines.launch
import com.fantasy.football.databinding.WeekFragmentViewBinding

private const val ARG_PAGENO = "pageno"

class WeekFragment : Fragment() {

    private lateinit var players: ArrayList<Player>
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerview: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var db : AppDatabase
    private var _binding: WeekFragmentViewBinding? = null
    private val binding get() = _binding!!

    //private lateinit var textView1 : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WeekFragmentViewBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(context)

        //textView1 = binding.textView1

        players = arrayListOf()
        viewModel = MainViewModel()

        val observer1 = Observer<List<Player>> { newPlayers ->
            // Update UI
            adapter = CustomAdapter(newPlayers as ArrayList<Player>)
            recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()

           //textView1.text = viewModel.number.value.toString()
        }
        viewModel.players.observe(viewLifecycleOwner, observer1)

        db = AppDatabase.getInstance(requireContext())!!
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arguments?.takeIf { it.containsKey(ARG_PAGENO) }?.apply {
            lifecycleScope.launch { //Main
                //IO
                //db.PlayerDao().populatePlayerUnknowns()
                players = db.PlayerDao().getPlayersWeek(getInt(ARG_PAGENO)) as ArrayList<Player>
                //Main
                viewModel.players.setValue(players)
            }
        }
    }
}