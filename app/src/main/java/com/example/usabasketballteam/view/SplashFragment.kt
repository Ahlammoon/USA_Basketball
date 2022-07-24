package com.example.usabasketballteam.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.usabasketballteam.R
import com.example.usabasketballteam.databinding.FragmentSplashBinding
import com.example.usabasketballteam.util.Resource
//import com.example.usabasketballteam.databinding.FragmentSplashBinding
import com.example.usabasketballteam.model.TeamResponse

import com.example.usabasketballteam.viewModels.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

/*
Here I have initialized the viewmodel via viewModels delegate and used View Binding for binding the views.
call etAllTeams, where I will bind the views to the data or use appropriate actions as per the response,
 */

    private val viewModel : HomeFragmentViewModel by viewModels()

    private lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        getAllTeams(COUNTRY_USA)
    }

    override fun onResume() {
        super.onResume()
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.show()
    }

    private fun getAllTeams(country: String) {
        // Update the list when the data changes
        viewModel.getAllTeams(country).observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    val action = result.data?.let {
                        TeamResponse(
                            it
                        )
                    }?.let {
                        SplashFragmentDirections.actionSplashFragmentToHomeFragment(
                            it
                        )
                    }
                    if (action != null) {
                        findNavController().navigate(action)
                    }
                }
                is Resource.Failure -> {
                }
            }
        })
    }
}