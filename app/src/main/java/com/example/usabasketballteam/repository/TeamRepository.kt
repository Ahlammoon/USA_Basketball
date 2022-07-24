package com.example.usabasketballteam.repository

import com.example.usabasketballteam.model.Team
import com.example.usabasketballteam.model.TeamEvent


interface TeamRepository {
    suspend fun getAllTeams(country : String): List<Team>
    suspend fun getTeamEvents(id : String): List<TeamEvent>
}