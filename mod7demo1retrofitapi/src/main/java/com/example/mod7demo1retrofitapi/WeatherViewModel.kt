package com.example.mod7demo1retrofitapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val _weather = MutableStateFlow<HourlyData?>(null);
    val weather: Flow<HourlyData?> = _weather;

    init {
        fetchWeather();
    }

    fun fetchWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            _weather.value = WeatherApiService.weatherApiService.getWeatherData(
                latitude = 48.04,
                longitude = -1.69,
                current = "temperature_2m,wind_speed_10m",
                hourly = "temperature_2m"
            ).hourly
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create (
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY]);
                return WeatherViewModel() as T
            }
        }
    }

}