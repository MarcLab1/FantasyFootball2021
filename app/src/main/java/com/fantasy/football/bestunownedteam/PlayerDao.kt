package com.fantasy.football.bestunownedteam

import androidx.room.*

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players")
    suspend fun getPlayers(): List<Player>

   // @Query("SELECT * FROM players WHERE weeknumber LIKE :weeknumber ORDER BY id ASC")
    @Query("SELECT * FROM players WHERE weeknumber LIKE :weeknumber")
    suspend fun getPlayersWeek(weeknumber:Int): List<Player>

    @Query("SELECT * FROM players WHERE name LIKE :name")
    fun getPlayer(name: String): Player

    @Query("SELECT COUNT(name) FROM players")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg todo: Player)

    @Delete
    fun delete(player: Player)

    @Query("DELETE FROM players")
    suspend fun deleteAll();

    @Update
    fun updatePlayer(vararg player: Player)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun populatePlayerUnknowns()
    {
        deleteAll()
        //week 1
        /*
        insert(Player(0,"Tyrod Taylor",  1, "HOU", "JAX","QB", 23.6, 23.6, "347", "35"))
        insert(Player(0,"JaMycal Hasty",  1, "SF","DET", "RB", 6.7, 8.7, "101", "97"))
        insert(Player(0,"Cordarrelle Patterson",  1, "ATL", "PHI","RB", 7.7, 8.7, "263", "88"))
        insert(Player(0,"Zach Pascal",  1, "IND", "SEA","WR", 16.3, 20.3, "394", "137"))
        insert(Player(0,"Van Jefferson Jr.", 1,  "LAR", "CHI","WR", 14.0, 16.0, "322", "96"))
        insert(Player(0,"Deonte Harris",  1, "NO", "GB","WR", 13.2, 15.2, "389", "128"))
        insert(Player(0,"David Njoku", 1,  "CLE", "KC", "TE",7.6, 10.6, "327", "45"))
        insert(Player(0,"Philadelphia Eagles", 1,  "PHI", "ATL","DST", 10.0, 10.0, "341", "25"))
        insert(Player(0,"Joey Slye", 1,  "SF", "JAX","K", 14.0, 14.0, "312", "33"))
            */
        //week 1
        insert(Player("Tyrod Taylor",  1, "HOU", "JAX","QB", 23.6, 23.6, "347", "35"))
        insert(Player("JaMycal Hasty",  1, "SF","DET", "RB", 6.7, 8.7, "101", "97"))
        insert(Player("Cordarrelle Patterson",  1, "ATL", "PHI","RB", 7.7, 8.7, "263", "88"))
        insert(Player("Zach Pascal",  1, "IND", "SEA","WR", 16.3, 20.3, "394", "137"))
        insert(Player("Van Jefferson Jr.", 1,  "LAR", "CHI","WR", 14.0, 16.0, "322", "96"))
        insert(Player("Deonte Harris",  1, "NO", "GB","WR", 13.2, 15.2, "389", "128"))
        insert(Player("David Njoku", 1,  "CLE", "KC", "TE",7.6, 10.6, "327", "45"))
        insert(Player("Philadelphia Eagles", 1,  "PHI", "ATL","DST", 10.0, 10.0, "341", "25"))
        insert(Player("Joey Slye", 1,  "SF", "JAX","K", 14.0, 14.0, "312", "33"))
        //week 2
        insert(Player("Taylor Heinicke",  2, "WAS", "NYG","QB", 21.0, 21.0, "470", "?"))
        insert(Player("Demetric Felton",  2, "CLE","HOU", "RB", 11.1, 13.1, "454", "?"))
        insert(Player("Andy Janovich",  2, "CLE", "HOU","RB", 6.0, 6.0, "?", "?"))
        insert(Player("Freddie Swain",  2, "SEA", "TEN","WR", 16.0, 21.0, "?", "194"))
        insert(Player("K.J. Osborn", 2,  "MIN", "ARI", "WR",15.1, 24.5, "?", "152"))
        insert(Player("Quintez Cephus", 2,  "DET", "GB","WR", 12.3, 16.3, "?", "117"))
        insert(Player("Maxx Williams",  2, "ARI", "MIN","TE", 9.4, 16.4, "?", "76"))
        insert(Player("Jacksonville Jaguars", 2,  "JAX", "DEN","DST", 9.0, 9.0, "294", "22"))
        insert(Player("Graham Gano", 2,  "NYG", "WAS","K", 22.0, 22.0, "347", "18"))

        //week 3
        insert(Player("Jacoby Brissett",  3, "MIA", "LV","QB", 20.3, 20.3, "482", "133"))
        insert(Player("Kyle Juszczyk",  3, "SF","GB", "RB", 11.1, 15.1, "341", "78"))
        insert(Player("Jeremy McNichols",  3, "TEN", "IND","RB", 7.6, 8.6, "467", "118"))
        insert(Player("DeSean Jackson",  3, "LAR", "TB","WR", 18.0, 21.0, "295", "91"))
        insert(Player("Kendrick Bourne", 3,  "NE", "NO", "WR",15.6, 21.6, "369", "98"))
        insert(Player("Dalton Schultz",  3, "DAL", "PHI","TE", 20.0, 26.0, "277", "33"))
        insert(Player("Tyler Conklin", 3,  "MIN", "SEA","TE", 13.0, 20.0, "359", "40"))
        insert(Player("Cincinnati Bengals", 3,  "CIN", "PIT","DST", 12.0, 12.0, "407", "31"))
        insert(Player("Greg Joseph", 3,  "MIN", "SEA","K", 13.0, 13.0, "464", "59"))

        //week 4
        insert(Player("Taysom Hill",  4, "NO", "NYG","QB", 16.8, 17.7, "262", "32"))
        insert(Player("Alex Collins",  4, "SEA","SF", "RB", 13.8, 15.8, "334", "92"))
        insert(Player("Jeremy McNichols",  4, "TEN", "NYJ","RB", 8.5, 16.5, "467", "118"))
        insert(Player("Kalif Raymond",  4, "DET", "CHI","WR", 16.6, 19.6, "278", "?"))
        insert(Player("Van Jefferson Jr.", 4,  "LAR", "ARI","WR", 15.0, 21.0, "322", "96"))
        insert(Player("C.J. Uzomah",  4, "CIN", "JAX","TE", 21.5, 26.5, "367", "42"))
        insert(Player("Mo Alie-Cox", 4,  "IND", "MIA","TE", 16.2, 19.2, "41", "368"))
        insert(Player("New York Jets", 4,  "NYJ", "TEN","DST", 7.0, 7.0, "372", "28"))
        insert(Player("Randy Bullock", 4,  "TEN", "NYJ","K", 12.0, 12.0, "362", "35"))

        //week 5
        insert(Player("Davis Mills",  5, "HOU", "NE","QB", 24.7, 24.7, "472", "131"))
        insert(Player("Ty Johnson",  5, "NYJ","ATL", "RB", 9.4, 11.4, "222", "64"))
        insert(Player("Kyle Juszczyk",  5, "SF","ARI", "RB", 3.5, 6.5, "341", "78"))
        insert(Player("Chris Moore",  5, "HOU", "NE","WR", 16.9, 21.9, "?", "?"))
        insert(Player("Chris Conley", 5,  "HOU", "NE", "WR",12.4, 15.4, "387", "124"))
        insert(Player("David Njoku",  5, "CLE", "LAC","TE", 20.9, 27.9, "327", "45"))
        insert(Player("Donald Parham Jr.", 5,  "LAC", "CLE","TE", 10.9, 12.9, "323", "36"))
        insert(Player("Philadelphia Eagles", 5,  "PHI", "CAR","DST", 12.0, 12.0, "341", "25"))
        insert(Player("Zane Gonzalez", 5,  "CAR", "PHI","K", 14.0, 14.0, "?", "72"))
    }
}