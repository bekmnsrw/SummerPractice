package com.example.task1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {

            val name = findViewById<EditText>(R.id.name).text.toString()
            val height = findViewById<EditText>(R.id.height).text.toString().toInt()
            val weight = findViewById<EditText>(R.id.weight).text.toString().toDouble()
            val age = findViewById<EditText>(R.id.age).text.toString().toInt()

            val view = findViewById<TextView>(R.id.result)

            if (name == "" || name.length > 50 || height < 0 || height > 250 || weight < 0 || weight > 250.0 || age > 150 || age < 0) {
                view.text = "Данные введены некорректно"
            } else {
                val formula = (name.length + height + weight.toInt() + age).toString()
                view.text = formula.toInt().toString()
            }
        }
    }
}