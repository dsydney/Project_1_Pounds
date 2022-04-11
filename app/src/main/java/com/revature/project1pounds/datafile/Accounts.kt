package com.revature.project1pounds.datafile



val accountList:MutableMap<String,Account> = mutableMapOf(
    "david@gmail.com" to Account("David",
        "Sydney",
        "david@gmail.com",
        "sydney",
        currentCalories = 0,
        fats= 100,
        carbs = 120,
        protein = 201,
        calorieGoal = 2167
        ),

    "jonathan@gmail.com" to Account("Jonathan",
        "Castaneda",
        "jonathan@gmail.com",
        "castaneda",
        currentCalories = 0,
        fats= 110,
        carbs = 96,
        protein = 206,
        calorieGoal = 2185),
    "michael@gmail.com" to Account("Michael",
        "Adams",
        "michael@gmail.com",
        "adams",
        currentCalories = 0,
        fats= 140,
        carbs = 240,
        protein = 192,
        calorieGoal = 2984),
    "brandon@gmail.com" to Account("Brandon",
        "Tate",
        "brandon@gmail.com",
        "tate",
        currentCalories = 0,
        fats= 121,
        carbs = 135,
        protein = 214,
        calorieGoal = 2468)
)



