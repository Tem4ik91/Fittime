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
    var photoUrl: String = ""


)