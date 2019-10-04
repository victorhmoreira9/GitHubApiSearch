package com.example.android.agilecontenttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.android.agilecontenttest.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar?.setCustomView(R.layout.actionbar)

        search_button.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("Username", username_edittext.text)
            startActivity(intent)
        }
    }
}
