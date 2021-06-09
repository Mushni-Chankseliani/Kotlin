package com.example.myapplication.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity2
import com.example.myapplication.R
import com.example.myapplication.api.dto.User
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.user_list.view.*

class UserAdapter (private val data: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false))
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.firstname.text=data[position].firstName.toString()
        holder.lastname.text=data[position].lastName.toString()
        holder.email.text=data[position].email.toString()
        Glide.with(holder.itemView.context).load(data[position].avatar).into(holder.avatar)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, MainActivity2::class.java)
            intent.putExtra("id", data[position].id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val firstname = itemView.firstname
        val lastname = itemView.lastname
        val email = itemView.email
        val avatar = itemView.imageView
    }

}
