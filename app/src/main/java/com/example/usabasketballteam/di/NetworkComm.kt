package com.example.usabasketballteam.di

import com.example.usabasketballteam.repository.TeamApi
import com.example.usabasketballteam.repository.TeamRepoImpl
import com.example.usabasketballteam.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
As we are using Dagger 2 with Retrofit,
 so we have to create  module that is responsible for providing the objects to Retrofit also.
 */

/*
We have defined singleton instances of the following dependencies needed to create an instance of TeamApi interface,
Hilt automatically checks for the required dependencies by checking the return types of other annotated methods.
 As these dependencies are third-party libraries, we need to annotate our object with the @Module annotation.
 */
/*
@Module — In Dagger 2, @Module class is responsible for providing objects to injected class.
@Provides — In @Module class, there is a method that is annotated as @Provides which is responsible for providing dependencies.
@Singleton — It is responsible for assuring that there should be only one instance of that class.
@Inject — It is used on the constructor so that Dagger should use it to create an instance of the class.
 @InstallIn annotation that determines which Hilt component(s) to install the module into.

 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkComm {

    private val BASE_URL ="https://www.thesportsdb.com/api/v1/json/2/"
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



    }

    @Singleton
    @Provides
    fun provideTeamApi(retrofit: Retrofit) : TeamApi {
        return retrofit.create(TeamApi::class.java)
    }


}

@Module
@InstallIn(SingletonComponent::class)
interface repositoryModule{
    @Binds
    fun provideRepositoryImpl(repositoryImpl: TeamRepoImpl) : TeamRepository
}

