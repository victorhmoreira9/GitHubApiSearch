package com.example.android.agilecontenttest.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.agilecontenttest.R
import com.example.android.agilecontenttest.models.UserRepositoryList
import kotlinx.android.synthetic.main.profile_repositories_viewholder.view.*

class ProfileViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.profile_repositories_viewholder,
            parent,
            false
        )
    ) {
    fun bind(list: List<UserRepositoryList>) {
        itemView.repository_name_textview.text = list[position].name
        itemView.repository_language_text_view.text = list[position].language
    }
}