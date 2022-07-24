package com.example.usabasketballteam.model

import com.google.gson.annotations.SerializedName

data class TeamEventsResponse(
    @SerializedName("results")
    val events: List<TeamEvent>
)
