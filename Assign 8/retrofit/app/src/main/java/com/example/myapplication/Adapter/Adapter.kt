package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.api.dto.User
import kotlinx.android.synthetic.main.user.view.*

class Adapter(private val data: List<User>): RecyclerView.Adapter<Adapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false))
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.firstname2.text=data[position].firstName.toString()
        holder.lastname2.text=data[position].lastName.toString()
        holder.email2.text=data[position].email.toString()
        Glide.with(holder.itemView.context).load(data[position].avatar).into(holder.avatar2)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val firstname2 = itemView.firstname2
        val lastname2 = itemView.lastname2
        val email2 = itemView.email2
        val avatar2 = itemView.avatar2
    }

}
