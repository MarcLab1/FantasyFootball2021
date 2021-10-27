package com.fantasy.football.tradevalue


//Helper class to convert imported json string columns to Double/Int
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "player_values_json")
data class PlayerValueJSON(@PrimaryKey @ColumnInfo(name = "rank") val rank: String,  //overall rank
                       @ColumnInfo(name = "name") val name: String,
                       @ColumnInfo(name = "team") val team: String,
                       @ColumnInfo(name = "position") val position: String,
                       @ColumnInfo(name = "age") val age: String,
                       @ColumnInfo(name = "points") val points: String
) {

    fun getPoints() : Double
    {
        return this.points.toDouble()
    }

    fun getRank() : Int
    {
        return this.rank.toInt()
    }
/*
    {
        "rank": "20",
        "name": "Alvin Kamara",
        "team": "NOR",
        "position": "RB",
        "age": "26",
        "points": "0.00"
    },

 */

}
