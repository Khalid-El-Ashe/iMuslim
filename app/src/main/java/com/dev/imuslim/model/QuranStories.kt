package com.dev.imuslim.model

import com.google.gson.annotations.SerializedName


data class QuranStories(
    @SerializedName("") var titleQuranStore: String,
    @SerializedName("") var contentQuranStory: String,
    @SerializedName("") var descriptionQuranStories: String
)
