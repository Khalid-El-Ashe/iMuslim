package com.dev.imuslim.model

import com.google.gson.annotations.SerializedName

data class Athckar(
    @SerializedName("athckar_index") val athckarIndex: Int,
    @SerializedName("athckar_name") val AthckarName: String,
    @SerializedName("athckar_content") val AthckarContent: String
)
