package com.fantasy.football

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fantasy.football.bestunownedteam.Player
import com.fantasy.football.bestunownedteam.PlayerDao
import com.fantasy.football.tradevalue.PlayerValue
import com.fantasy.football.tradevalue.PlayerValueDao

@Database(
    entities = [Player::class, PlayerValue::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun PlayerDao(): PlayerDao
    abstract fun PlayerValueDao(): PlayerValueDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "players.db")
            .createFromAsset("databases/players.db") //preloaded data from assets folder
            .fallbackToDestructiveMigration()
            .build()

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }

}