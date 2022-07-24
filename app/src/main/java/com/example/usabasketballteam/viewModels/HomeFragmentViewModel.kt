package com.example.usabasketballteam.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.usabasketballteam.util.Resource
import com.example.usabasketballteam.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val teamRepo: TeamRepository
) : ViewModel(){

    fun getAllTeams(country : String) = liveData(Dispatchers.IO){

       // emit() call suspends the execution of the block until the LiveData value is set on the main thread.
        emit(Resource.Loading( ))
        try {
            emit(
                Resource.Success(
                    teamRepo.getAllTeams(country)
                )
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}