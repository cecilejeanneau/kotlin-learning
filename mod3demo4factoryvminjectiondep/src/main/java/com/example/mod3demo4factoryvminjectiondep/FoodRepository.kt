package com.example.mod3demo4factoryvminjectiondep

class FoodRepository {

    private val foods = listOf(
        "Pizza",
        "Burger",
        "No veget",
        "Tartiflette",
        "Burger aux lasagnes",
    )

    fun getFoods(): List<String> {
        return foods;
    }
}