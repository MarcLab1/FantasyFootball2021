package com.fantasy.football.tradevalue

import androidx.room.*

@Dao
interface PlayerValueDao {


    @Query("SELECT * FROM player_values ORDER BY points DESC")
    suspend fun getPlayerValuesPoints(): List<PlayerValue>

    @Query("SELECT * FROM player_values ORDER BY rank ASC")
    suspend fun getPlayerValuesRank(): List<PlayerValue>

    @Query("SELECT * FROM player_values ORDER BY position ASC")
    suspend fun getPlayerValuesPosition(): List<PlayerValue>

    @Query("SELECT * FROM player_values ORDER BY team ASC")
    suspend fun getPlayerValuesTeam(): List<PlayerValue>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg pv: PlayerValue)

    @Delete
    fun delete(pv: PlayerValue)


}