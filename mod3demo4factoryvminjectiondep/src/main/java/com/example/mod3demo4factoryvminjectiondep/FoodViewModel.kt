package com.example.mod3demo4factoryvminjectiondep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FoodViewModel(
//    primary constructor
    private val _foodRepository: FoodRepository
) : ViewModel() {

    private val _foods = MutableStateFlow<List<String>>(emptyList());
//    polymorphism between StatefFlow and MutableStateFlow
    var foods : StateFlow<List<String>> = _foods.asStateFlow();

//    callback au chargement viewmodel
    init {
        _foods.value = _foodRepository.getFoods();
    }

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras -> application context, where's the DB for example
//                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
//                val savedStateHandle = extras.createSavedStateHandle()

                return FoodViewModel(
//                    instance of FoodRepository
                    FoodRepository(),
                ) as T
            }
        }
    }
}