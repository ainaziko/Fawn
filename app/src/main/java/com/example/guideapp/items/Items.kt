package com.example.guideapp.items

data class Items(val description: String, val title: String, val phone_number: String,
                 val locationName:String, val location: String, var expanded: Boolean = false )

