package com.dev.imuslim.model

import com.google.gson.annotations.SerializedName

data class Hadith(
    @SerializedName("") var hadithTitle: String,
    @SerializedName("") var hadithContent: String,
    @SerializedName("") var hadithDescription: String
)
