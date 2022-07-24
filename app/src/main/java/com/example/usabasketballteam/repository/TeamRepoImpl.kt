package com.example.usabasketballteam.repository

import com.example.usabasketballteam.util.CheckConnection
import com.example.usabasketballteam.model.Team
import com.example.usabasketballteam.model.TeamEvent


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepoImpl @Inject constructor(
    private val TeamApi: TeamApi
) : TeamRepository {
    override suspend fun getAllTeams(country : String): List<Team> {
        val sportname = "Basketball"
        return if(CheckConnection.isNetworkAvailable()){
                TeamApi.getAllTeams(sportname, country).teams
        }else{
            emptyList()
        }
    }

    override suspend fun getTeamEvents(id: String): List<TeamEvent> {
        return if(CheckConnection.isNetworkAvailable()){
            TeamApi.getTeamEvents(id).events
        }else{
            emptyList()
        }
    }

}