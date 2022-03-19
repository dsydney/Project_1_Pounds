package com.revature.project1pounds.datafile


data class Account(
    var firstName:String,
    var lastName:String,
    var email:String,
    var password:String,
    var fats:Int=0,
    var carbs:Int=0,
    var protein:Int=0,
    var calorieGoal:Int=0,
    var currentCalories:Int=0
)