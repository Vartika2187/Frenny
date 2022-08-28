package com.example.frenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var et1: EditText
    lateinit var et2: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)


                btn1.setOnClickListener {
                    startActivity(Intent(this, MainActivity2::class.java))
                    finish()
                }
            }

        }


