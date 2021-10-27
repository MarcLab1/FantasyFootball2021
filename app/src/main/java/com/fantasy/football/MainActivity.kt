package com.fantasy.football

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.fantasy.football.bestunownedteam.BestUnownedFragment
import com.fantasy.football.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var tabViewPager2: ViewPager2
    //private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //prepopulates the db, don't need to keep the reference around
        AppDatabase.getInstance(this)
        //db = AppDatabase.getInstance(this)!!

        tabLayout = binding.tabLayout
        val numTabs : Int = 2
        val adapter : TabsPagerAdapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numTabs)
        tabViewPager2 = binding.tabViewPager2
        tabViewPager2.adapter = adapter
        tabViewPager2.setUserInputEnabled(false) //don't allow the user to swipe the main viewpager2

        TabLayoutMediator(tabLayout, tabViewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = resources.getString(R.string.best_unowned_team)
                    //tab.setIcon(R.drawable.nfl_logo)
                }
                1 -> {
                    tab.text = resources.getString(R.string.trade_value)
                    //tab.setIcon(R.drawable.nfl_logo)
                }
                else ->  tab.text = resources.getString(R.string.where_am_i)
            }
        }.attach()

        /*
        I only run this the first time to load the db from the json file
        lifecycleScope.launch {
            populateDbPlayerValues()
        }
        */

    }

    /*
    suspend fun populateDbPlayerValues(): Unit {
        val jsonFileString = getJsonDataFromAsset(applicationContext, "json/playervalues.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

        val gson = Gson()
        val mylist = object : TypeToken<List<PlayerValueJSON>>() {}.type

        var players: List<PlayerValueJSON> = gson.fromJson(jsonFileString, mylist)
        players.forEach { pvj ->
            db.PlayerValueDao()
                .insert(PlayerValue(pvj.getRank() , pvj.name, pvj.team, pvj.position, pvj.age, pvj.getPoints()))
        }
    }
    */
}


