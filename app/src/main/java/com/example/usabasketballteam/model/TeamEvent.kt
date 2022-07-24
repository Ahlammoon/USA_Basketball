package com.example.usabasketballteam.model

import com.google.gson.annotations.SerializedName

data class TeamEvent(
    @SerializedName("strEvent")
    val event: String,
    @SerializedName("dateEvent")
    val date: String
)

