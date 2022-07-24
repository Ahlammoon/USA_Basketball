package com.example.usabasketballteam.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usabasketballteam.MainActivity
import com.example.usabasketballteam.R
import com.example.usabasketballteam.util.Resource
import com.example.usabasketballteam.databinding.DetailFragmentBinding
import com.example.usabasketballteam.model.TeamEvent


import com.example.usabasketballteam.viewModels.DetailFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment)   {



    private lateinit var binding : DetailFragmentBinding
    private lateinit var mAdapter: TEventsAdapter
    private lateinit var mLayoutManager : LinearLayoutManager

    private val viewModel : DetailFragmentViewModel by viewModels()
    private var eventsList = mutableListOf<TeamEvent>()

    private val args by navArgs<DetailFragmentArgs>()
    private var mActivity: MainActivity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DetailFragmentBinding.bind(view)
        mAdapter = TEventsAdapter(eventsList)
        mLayoutManager = LinearLayoutManager(requireContext())
        binding.rvEvents.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
        loadView()
        getTeamEvents()

    }



    private fun loadView() {
        with(binding){
            tvTeamName.text = args.team.name
            tvTeamDesc.text = args.team.desc

            setupActionBar(args.team.name)
        }
    }

    private fun setupActionBar(nickname: String) {
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = nickname
    }

    private fun getTeamEvents() {
        eventsList.clear()
        // Update the list when the data changes
        viewModel.getTeamEvents(args.team.id).observe(viewLifecycleOwner, { Teamsresult ->
            when( Teamsresult) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    Teamsresult.data?.let { eventsList.addAll(it) }
                    mAdapter.setTeamEvents(eventsList)
                }


                is Resource.Failure -> {
                }
            }
        })
    }


}