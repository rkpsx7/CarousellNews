package com.dev_akash.carousellnews.model

import com.google.gson.annotations.SerializedName

data class NewsHomeResponse(
    var id: String? = null,
    var title: String? = null,
    var description: String? = null,
    @SerializedName("banner_url")
    var bannerUrl: String? = null,
    @SerializedName("time_created")
    var timeCreated: Long? = null,
    var rank: Int? = null
)