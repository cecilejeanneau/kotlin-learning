package com.example.mod6demo1datastore

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _colors = MutableStateFlow<List<Color>>(
        listOf(
            Color.Red,
            Color.Cyan,
            Color.Blue,
            Color.Magenta,
            Color.DarkGray
        )
    );
    val colors : StateFlow<List<Color>> = _colors;

    private val _userColor = MutableStateFlow<Color>(Color.White);
    val userColor: StateFlow<Color> = _userColor;

    init {
        getBgColor()
    }

    fun getBgColor(){
        viewModelScope.launch {
            userPreferencesRepository.getBgColor().collect { _userColor.value = it };
        }
    }

    fun setBgColor(color: Color) {
        viewModelScope.launch {
            userPreferencesRepository.saveBgColor(color)
        }
    }

//    factory to create an instance of my viewmodel
//    factory is a singleton
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create (
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY]);
                return SettingsViewModel(UserPreferencesRepository(application.applicationContext)) as T
            }
        }
    }
}