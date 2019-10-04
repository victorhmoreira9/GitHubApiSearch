package com.example.android.agilecontenttest.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.agilecontenttest.R
import com.example.android.agilecontenttest.models.UserRepositoryList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),
    IProfileView {
    override fun onUserNotFound() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.user_not_found)
        builder.setPositiveButton(R.string.ok_button) { dialog, which ->
            finish()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onApiError() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.api_error)
        builder.setPositiveButton(R.string.ok_button) { dialog, which ->
            finish()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private var presenter: IProfilePresenterView? = null
    private var mAdapter: ProfileAdapter? = null
    private var profileName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        presenter = ProfilePresenter(this)
        setSupportActionBar(profile_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        profileName = intent.extras["Username"].toString()
        if (profileName != null) {
            presenter?.search(profileName!!)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onUserSearched(repositoryList: List<UserRepositoryList>) {
        profile_name_textview.text = profileName
        Picasso.get().load(repositoryList[0].userInfo?.avatarUrl).into(profile_imageview)
        mAdapter = ProfileAdapter(repositoryList)
        this.repositories_recyclerview?.adapter = mAdapter
        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        this.repositories_recyclerview?.layoutManager = horizontalLayoutManager
    }
}
