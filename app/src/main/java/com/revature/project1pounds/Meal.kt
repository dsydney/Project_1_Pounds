package com.revature.project1pounds

data class Meal(
    val name: String,
    val carbohydrates: Int,
    val protein: Int,
    val fat: Int,
) {
    val calories: Int = carbohydrates * 4 + protein * 4 + fat * 9

    fun filter(searchTerm: String): Boolean {
        return name.lowercase().startsWith(searchTerm.lowercase())
    }

}