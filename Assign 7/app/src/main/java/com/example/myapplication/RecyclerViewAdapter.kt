package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val list: ArrayList<NoteItem>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    private var clickListener: ClickListener? = null


    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val noteTextView = itemView.findViewById<TextView>(R.id.note)

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(this)
            }
        }

        fun bindNote(noteItem: NoteItem) {
            noteTextView.text = noteItem.note
        }


        override fun onClick(v: View?) {
            if (v != null) {
                clickListener?.onItemClick(v,adapterPosition)
            }
        }

    }

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindNote(list[position])
    }


    override fun getItemCount() = list.size

    interface ClickListener {
        fun onItemClick(v: View,position: Int)
    }

}

