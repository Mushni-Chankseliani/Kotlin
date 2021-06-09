package com.example.myapplication.api.dto

import com.google.gson.annotations.SerializedName

data class User(

    var id: Long?,

    var email: String?,

    @SerializedName("first_name")
    var firstName: String?,

    @SerializedName("last_name")
    var lastName: String?,

    var avatar: String?

)

data class UserDetailed(
   var data: User?
)

data class ReqresData<T>(

    var page: Int?,

    var data: T?

)
