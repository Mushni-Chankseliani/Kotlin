package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EmailActivity : AppCompatActivity() {
    private lateinit var emailButton: Button
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        emailEditText = findViewById(R.id.email)
        emailButton = findViewById(R.id.email_button)

        val name = intent.extras?.getString("name")
        var age = intent.extras?.getInt("age")

        emailButton.setOnClickListener {
            val email = emailEditText.text.toString()

            if(email.isEmpty()){
                return@setOnClickListener
            }


            val intent = Intent(this,FinishActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("email", email)
            startActivity(intent)


        }
    }

}
