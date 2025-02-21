package com.dev.imuslim.network

import com.dev.imuslim.model.Dua
import com.dev.imuslim.model.Hadith
import com.dev.imuslim.model.QuranStories
import com.dev.imuslim.model.SallaTime
import com.dev.imuslim.model.StoriesFriends
import com.dev.imuslim.model.StoriesProphets
import retrofit2.http.GET

interface IMuslimApi {

    @GET("dua")
    suspend fun getDua(): List<Dua>

    @GET("hadith")
    suspend fun getHadith(): List<Hadith>

    @GET("quranStories")
    suspend fun getQuranStories(): List<QuranStories>

    @GET("storiesFriends")
    suspend fun getStoriesFriends(): List<StoriesFriends>

    @GET("storiesProphets")
    suspend fun getStoriesProphets(): List<StoriesProphets>

    @GET("storiesQuran")
    suspend fun getStoriesQuran(): List<QuranStories>

    @GET("")
    suspend fun getSallaTimes(): List<SallaTime>

    @GET("morning")
    suspend fun readMorning(): String

    @GET("evening")
    suspend fun readEvening(): String
}