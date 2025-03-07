package com.example.tpvm.vm

import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import com.example.tpvm.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DiceViewModel : ViewModel() {
    //    need to listen for the only var that will change at every action
    private val _totalRolls = MutableStateFlow<Int>(0);

    //    val totalRolls: StateFlow<Int> = _totalRolls;
    val totalRolls = _totalRolls.asStateFlow();

    var totalDicesLeft = 0;
    var totalDicesRight = 0;
    var totalRollsLeft = 0;
    var totalRollsRight = 0;

    private val _dices = listOf(
        (R.drawable.d1),
        (R.drawable.d2),
        (R.drawable.d3),
        (R.drawable.d4),
        (R.drawable.d5),
        (R.drawable.d6)
    );

//    val currentRoll = (1..6).random();

    //    initialize a default random value
    private val _dice = MutableStateFlow(_dices.random());
    val dice = _dice.asStateFlow();

    fun leftRound() {
        _totalRolls.value++;
        totalRollsLeft++;

        _dice.value = _dices.random();

        //        TODO: refactor this when in an other function DRY
        when (_dice.value) {
            R.drawable.d1 -> totalDicesLeft++;
            R.drawable.d2 -> totalDicesLeft += 2;
            R.drawable.d3 -> totalDicesLeft += 3;
            R.drawable.d4 -> totalDicesLeft += 4;
            R.drawable.d5 -> totalDicesLeft += 5;
            R.drawable.d6 -> totalDicesLeft += 6;
        }
    }

    fun rightRound() {
        _totalRolls.value++;
        totalRollsRight++;

//        change the dice image value randomly
        _dice.value = _dices.random();

        //        TODO: refactor this when in an other function DRY
        when (_dice.value) {
            (R.drawable.d1) -> totalDicesRight++;
            (R.drawable.d2) -> totalDicesRight += 2;
            (R.drawable.d3) -> totalDicesRight += 3;
            (R.drawable.d4) -> totalDicesRight += 4;
            (R.drawable.d5) -> totalDicesRight += 5;
            (R.drawable.d6) -> totalDicesRight += 6;
        }
    }

    fun reset() {
        totalDicesLeft = 0;
        totalDicesRight = 0;
        totalRollsRight = 0;
        totalRollsLeft = 0;
        _totalRolls.value = 0;
    }
}