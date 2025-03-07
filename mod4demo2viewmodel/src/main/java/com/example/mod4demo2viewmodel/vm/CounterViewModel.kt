package com.example.mod4demo2viewmodel.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {
//    inférence de type, il le sait tout seul que c'est <Int> pas besoin de le rajouter
    private val _counter = MutableStateFlow<Int>(0);
//    la vue doit lire, pas changer la valeur sinon call modèle et getter setters
//    que le VM qui peut modifier lui-même ses données de sa MutableStateFlow
//    val counter : StateFlow<Int> = _counter;
    val counter = _counter.asStateFlow();

    var nbPlus = 0;
    var nbMoins = 0;

    fun incrementCounter(){
        _counter.value++;
//        _counter.value = _counter.value.inc();
        nbPlus++
    }
    fun decrementCounter(){
        _counter.value--;
//        _counter.value = _counter.value.dec();
//        _counter.value = _counter.value.minus(1);
        nbMoins++
    }
}