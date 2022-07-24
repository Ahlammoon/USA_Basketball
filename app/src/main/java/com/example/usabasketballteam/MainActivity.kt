package com.example.usabasketballteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this?.onBackPressed()
            return true
        } else {
            //
            return super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        //the role of the FragmentManager in relation to your activities and fragments,
        // managing the back stack with FragmentManager,
        // and providing data and dependencies to your fragments.
        if (supportFragmentManager.backStackEntryCount > 0)
             supportFragmentManager.popBackStack()
        else super.onBackPressed()
    }


}