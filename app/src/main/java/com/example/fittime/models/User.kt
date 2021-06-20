package com.example.fittime.models

import android.provider.ContactsContract

data class User(
    val id: String = "",
    var username: String = "",
    var fullname: String = "",
    var phone: String = "",
    var sex: String = "",
    var databirth: String = "",
    var growth: String = "",
    var weight: String = "",
    var photoUrl: String = "empty",
    var mon: String = "0",
    var tue: String = "0",
    var wed: String = "0",
    var thu: String = "0",
    var fri: String = "0",
    var sat: String = "0",
    var sun: String = "0"

)