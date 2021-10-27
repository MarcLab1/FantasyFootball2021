package com.fantasy.football.bestunownedteam

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fantasy.football.tradevalue.PlayerValue

class MainViewModel : ViewModel {

    public lateinit var players : MutableLiveData<List<Player>>
    public lateinit var playerValues : MutableLiveData<List<PlayerValue>>
    //public lateinit var number :  MutableLiveData<String>

    public constructor()
    {
        players = MutableLiveData<List<Player>>()
        playerValues = MutableLiveData<List<PlayerValue>>()
        //number = MutableLiveData<String> ("5555")
    }

}