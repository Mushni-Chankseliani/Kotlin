package com.example.assign9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern
import kotlin.contracts.Returns

val EMAIL_REGEX = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
"\\@" +
"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
"(" +
"\\." +
"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
")+"

val PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        auth = FirebaseAuth.getInstance()
        submit.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty() && password.text.toString() == passwordConfirm.text.toString()) {
                if (isValidEmail(email.text.toString()) && isPasswordValid(password.text.toString())) {
                    auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                            email.text.clear()
                            password.text.clear()
                            passwordConfirm.text.clear()
                        } else {
                            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Validation Error", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "shouldn't be empty", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Pattern.compile(EMAIL_REGEX)
        return emailRegex.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordRegex = Pattern.compile(PASSWORD_REGEX)
        return passwordRegex.matcher(password).matches()
    }

}