package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val note = ArrayList<NoteItem>()

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val quantity = sharedPref.getInt("NOTE", 0)
        val savedStrings = ArrayList<String>()
        for(i in 0 until quantity) {
            savedStrings.add(sharedPref.getString(i.toString(), "").toString())
            note.add(NoteItem(savedStrings[i]))
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter=RecyclerViewAdapter(note)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener(object : RecyclerViewAdapter.ClickListener {
            override fun onItemClick(v: View, position: Int) {
                note.remove(note[position])
                recyclerView.adapter=adapter
            }
        })


        buttonAdd.setOnClickListener {
            val input = editTextNote.text.toString()

            if (input.isNotEmpty()) {
                note.add(NoteItem(input))
                recyclerView.adapter=adapter

                editTextNote.setText("")
            }

        }

    }

}