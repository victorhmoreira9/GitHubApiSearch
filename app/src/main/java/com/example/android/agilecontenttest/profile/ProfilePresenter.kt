package com.example.android.agilecontenttest.profile

import com.example.android.agilecontenttest.models.UserRepositoryList
import com.example.android.agilecontenttest.service.RestApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePresenter(val view: IProfileView) : IProfilePresenterView {
    val apiService = RestApiBuilder.getService(RestApiBuilder())

    override fun search(login: String) {
        val userListCall = apiService.getUser(login)
        userListCall.enqueue(object : Callback<List<UserRepositoryList>> {
            override fun onResponse(
                call: Call<List<UserRepositoryList>>?,
                response: Response<List<UserRepositoryList>>?
            ) {
                if (response?.isSuccessful!!) {
                    val userList = response.body()
                    view.onUserSearched(userList)
                } else {
                    view.onUserNotFound()
                }
            }

            override fun onFailure(call: Call<List<UserRepositoryList>>?, t: Throwable?) {
                view.onApiError()
            }

        })
    }

}