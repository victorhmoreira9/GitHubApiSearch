package com.example.android.agilecontenttest.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.agilecontenttest.models.UserRepositoryList

class ProfileAdapter(private val list: List<UserRepositoryList>) :
    RecyclerView.Adapter<ProfileViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProfileViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}