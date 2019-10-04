package com.example.android.agilecontenttest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null,
    @SerializedName("login")
    @Expose
    var login: String? = null
)