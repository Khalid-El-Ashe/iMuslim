package com.dev.imuslim.model

import com.google.gson.annotations.SerializedName

data class Dua(
    @SerializedName("dua_index") val duaIndex: Int,
    @SerializedName("dua_name") val duaName: String,
    @SerializedName("dua_content") val duaContent: String,
)
