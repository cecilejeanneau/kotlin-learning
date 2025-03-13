package com.example.mod7demo1retrofitapi

import com.squareup.moshi.Json

data class WeatherResponse(
    val hourly: HourlyData
)

data class HourlyData(
    val time: List<String>,
    @Json(name="temperature_2m")
    val temperatures: List<Double>
)