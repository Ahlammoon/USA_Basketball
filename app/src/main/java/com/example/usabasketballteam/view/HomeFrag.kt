package com.example.usabasketballteam.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usabasketballteam.MainActivity
import com.example.usabasketballteam.R
import com.example.usabasketballteam.databinding.FragmentHomeBinding
import com.example.usabasketballteam.model.Team

import dagger.hilt.android.AndroidEntryPoint

const val COUNTRY_USA = "United_States"


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), TAdapter.OnTeamClickListener{

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: TAdapter
    private lateinit var mLayoutManager : LinearLayoutManager


    private val args by navArgs<HomeFragmentArgs>()

    private var teamsList = mutableListOf<Team>()

    private var mActivity: MainActivity? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        mAdapter = TAdapter(teamsList, this)
        mLayoutManager = LinearLayoutManager(requireContext())
        binding.rvTeams.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
        /*
        MutableList class is used to create mutable lists in which the elements can be added or removed.
         The method mutableListOf() returns an instance of MutableList Interface and takes the array of a particular type
          or mixed (depends on the type of MutableList instance) elements or it can be null also.
         */
        mAdapter.setTeams(args.teamsList.teams.toMutableList())


    }

    override fun onResume() {
        super.onResume()
        setupActionBar(getString(R.string.app_name))
    }

    private fun setupActionBar(title: String) {
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = title
    }
    override fun onTeamClick(team: Team) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(team)
        findNavController().navigate(action)
    }
}