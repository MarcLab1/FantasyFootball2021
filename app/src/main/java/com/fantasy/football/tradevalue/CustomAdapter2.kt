package com.fantasy.football.tradevalue

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.fantasy.football.bestunownedteam.MainViewModel
import com.fantasy.football.databinding.ListPlayerValue2Binding
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter2(var playerValues: ArrayList<PlayerValue>) : RecyclerView.Adapter<CustomAdapter2.PlayerValueViewHolder>(),
    Filterable {
    private lateinit var viewModel : MainViewModel
    private var playerValueFilterList = ArrayList<PlayerValue>()

    init {
        playerValueFilterList = playerValues
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    playerValueFilterList = playerValues
                } else {
                    val resultList = ArrayList<PlayerValue>()
                    for (pv in playerValues) {
                        if (pv.name.lowercase().contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(pv)
                        }
                    }
                    playerValueFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = playerValueFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                playerValueFilterList = results?.values as ArrayList<PlayerValue>
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PlayerValueViewHolder
    {   viewModel = MainViewModel()
        return PlayerValueViewHolder(
            ListPlayerValue2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayerValueViewHolder, position: Int) {
        val playerValue: PlayerValue = playerValueFilterList[position]
        holder.bind(playerValue)
    }

    override fun getItemCount() = playerValueFilterList.size


    class PlayerValueViewHolder(private val binding: ListPlayerValue2Binding) : RecyclerView.ViewHolder(binding.root) {

        private val rank = binding.textViewRank
        private val name = binding.textViewName
        private val position = binding.textViewPosition
        private val team = binding.textViewTeam
        private val points = binding.textViewPoints
        private val teamImage = binding.teamImageView

        fun bind(playerValue: PlayerValue) {
            rank.text =  playerValue.rank.toString()
            name.text =  playerValue.name
            team.text =  playerValue.team
            position.text =  playerValue.position
            points.text = playerValue.points.toString()
            teamImage.setBackgroundResource(playerValue.getTeamImage(playerValue.team))
        }
    }
}