package com.example.usabasketballteam.repository


import com.example.usabasketballteam.model.TeamEventsResponse
import com.example.usabasketballteam.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TeamApi {

    @GET("search_all_teams.php")
    suspend fun getAllTeams(@Query("s")sport : String,

                            @Query("c") country : String): TeamResponse

    @GET("eventslast.php")
    suspend fun getTeamEvents(@Query("id") id : String) : TeamEventsResponse

}