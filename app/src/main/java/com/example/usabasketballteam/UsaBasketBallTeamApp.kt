package com.example.usabasketballteam

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/*
using Hilt for dependency injection and to kick off code generation of Hilt Components,
 we will need an application class, annotated with @HiltAndroidApp
 */
@HiltAndroidApp
class UsaBasketBallTeamApp : Application()