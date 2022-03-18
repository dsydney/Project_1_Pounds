package com.revature.project1pounds.datafile

data class Account(
    var firstName:String,
    var lastName:String,
    var email:String,
    var password:String,
    var fats:Int?=null,
    var carbs:Int?=null,
    var protein:Int?=null,
    var calorieGoal:Int?=null,
    var currentCalories:Int?=null
)