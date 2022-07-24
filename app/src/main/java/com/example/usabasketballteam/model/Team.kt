package com.example.usabasketballteam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*
Sending object references between Android components is not possible
because by changing the process, the object references won’t be in the new process,
so we must make our objects Parcelabel or Serializable till the OS be able to save
the values of the objects
 */
@Parcelize
/*
A parcel is highly optimized for local IPC (Inter-Process Communication —
You can get familiar with IPC here) no store
 is very essential for passing the data between Activities, Fragments
 */
data class Team(
    /*
    Serializing objects means converting an object’s state to a byte stream and used
    for Sending data over the network.
    Transferring objects between different components in Android
     */
    @SerializedName("idTeam")
    val id: String ,
   @SerializedName("strTeam")
    val name: String ,

    @SerializedName("strStadium")
    val stadiumName: String ,

    @SerializedName("strTeamBadge")
    val badge: String ,
  @SerializedName("strDescriptionEN")
   var desc: String,

) : Parcelable





