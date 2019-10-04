package com.example.android.agilecontenttest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRepositoryList {
    @SerializedName("owner")
    @Expose
    var userInfo: UserInfo? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null

}