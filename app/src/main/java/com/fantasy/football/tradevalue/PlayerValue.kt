package com.fantasy.football.tradevalue

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fantasy.football.R


@Entity(tableName = "player_values")
data class PlayerValue(
    @PrimaryKey @ColumnInfo(name = "rank") val rank: Int,  //overall rank
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "team") val team: String,
    @ColumnInfo(name = "position") val position: String,
    @ColumnInfo(name = "age") val age: String,
    @ColumnInfo(name = "points") val points: Double
) {


    fun getPoints(str: String): Double {
        return str.toDouble()
    }

    fun getRange(str: String): Int {
        return str.toInt()
    }

    fun getTeamImage(teamName: String): Int {
        when (teamName.lowercase()) {
            "ari" -> return R.drawable.ari
            "atl" -> return R.drawable.atl
            "bal" -> return R.drawable.bal
            "buf" -> return R.drawable.buf

            "car" -> return R.drawable.car
            "chi" -> return R.drawable.chi
            "cin" -> return R.drawable.cin
            "cle" -> return R.drawable.cle

            "dal" -> return R.drawable.dal
            "den" -> return R.drawable.den
            "det" -> return R.drawable.det
            "gb" -> return R.drawable.gb

            "hou" -> return R.drawable.hou
            "ind" -> return R.drawable.ind
            "jax" -> return R.drawable.jax
            "kc" -> return R.drawable.kc

            "lar" -> return R.drawable.lar
            "lac" -> return R.drawable.lac
            "lv" -> return R.drawable.lv
            "mia" -> return R.drawable.mia

            "min" -> return R.drawable.min
            "ne" -> return R.drawable.ne
            "no" -> return R.drawable.no
            "nyg" -> return R.drawable.nyg

            "nyj" -> return R.drawable.nyj
            "phi" -> return R.drawable.phi
            "pit" -> return R.drawable.pit
            "sea" -> return R.drawable.sea

            "sf" -> return R.drawable.sf
            "tb" -> return R.drawable.tb
            "ten" -> return R.drawable.ten
            "was" -> return R.drawable.was


            "nor" -> return R.drawable.no
            "gnb" -> return R.drawable.gb
            "kan" -> return R.drawable.kc
            "lvr" -> return R.drawable.lv

            "tam" -> return R.drawable.tb
            "sfo" -> return R.drawable.sf
            "nwe" -> return R.drawable.ne
            "lvr" -> return R.drawable.lv

            else -> { // Note the block
                return R.drawable.nfl_logo
            }
        }
    }

}




