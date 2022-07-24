package com.example.usabasketballteam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamResponse(
    @SerializedName("teams")
    val teams: List<Team>
) : Parcelable
