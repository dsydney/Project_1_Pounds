package com.revature.project1pounds.datafile

data class account(
    var firstName:String,
    var lastName:String,
    var email:String,
    var password:String,
    var calorieGoal:Int?=null,
    var currentCalories:Int?=null
)