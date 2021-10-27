package com.fantasy.football.bestunownedteam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fantasy.football.databinding.ListPlayer2Binding

class CustomAdapter(var players: ArrayList<Player>) : RecyclerView.Adapter<CustomAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PlayerViewHolder
    {
        return PlayerViewHolder(
            ListPlayer2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player: Player = players[position]
        holder.bind(player)
    }

    override fun getItemCount() = players.size

    class PlayerViewHolder(private val binding: ListPlayer2Binding) : RecyclerView.ViewHolder(binding.root) {

        private val name = binding.textViewName
        private val position = binding.textViewPosition
        private val team = binding.textViewTeam
        private val opponent = binding.textViewOpponent
        private val adpoverall = binding.textViewAdpOverall
        private val adpposition = binding.textViewAdpPosition
        private val adppositionposition = binding.textViewAdpPositionPosition
        private val pointsweekstd = binding.textViewPointsWeekStd
        private val pointsweekppr = binding.textViewPointsWeekPPR
        private val teamImage = binding.teamImageView
        private val colon : String = "):"

        fun bind(player: Player) {
            name.text =  player.name
            position.text =  player.position
            team.text =  player.team
            opponent.text = player.opponent
            adpoverall.text =  player.adpoverall.toString()
            adpposition.text =  player.adpposition.toString()
            adppositionposition.text = player.position.toString() + colon
            pointsweekstd.text =  player.pointsweekstd.toString()
            pointsweekppr.text =  player.pointsweekppr.toString()
            teamImage.setBackgroundResource(player.getTeamImage(player.team))
        }
    }
}