package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var equalsButton: Button

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.init()

        equalsButton.setOnClickListener {

            val secOperandText: String = resultTextView.text.toString()
            var secOperand: Double = 0.0

            if (secOperandText.isNotEmpty()) {
                secOperand = secOperandText.toDouble()
            }

            when (this.operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
                "%" -> resultTextView.text = (operand / 100 * secOperand).toString()
                "C" -> resultTextView.text = "0"
                "√" -> resultTextView.text = (operand.pow(1/2)).toString()
                "+/-" -> resultTextView.text = if (operand < 0) Math.abs(operand).toString() else (-operand).toString()
//                "." -> resultTextView.append(".") //ver mivxvdi aq rogor avamushavo
            }

        }

    }

    fun tst(view: View) {

        if (view is TextView) {
            println("here it comes " +  view.text)

            if (!resultTextView.text.toString().contains(".") && resultTextView.text.toString().length > 0) {
                resultTextView.append(".")
            }

        }

    }

    private fun init() {
        resultTextView = findViewById(R.id.resultTextView)
        equalsButton = findViewById(R.id.equalsButton)
    }

    fun numberClick(view: View) {

        if (view is Button) {

            val number = view.text.toString()
            var result = resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is Button) {

            if (resultTextView.text.toString().isNotEmpty()) {
                operand = resultTextView.text.toString().toDouble()
            }

            operation = view.text.toString()

            resultTextView.text = ""

        }

    }

}
