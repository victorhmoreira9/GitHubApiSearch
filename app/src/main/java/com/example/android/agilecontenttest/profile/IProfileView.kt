package com.example.android.agilecontenttest.profile

import com.example.android.agilecontenttest.models.UserRepositoryList

interface IProfileView {
    fun onUserSearched(repositoryList: List<UserRepositoryList>)
    fun onUserNotFound()
    fun onApiError()
}