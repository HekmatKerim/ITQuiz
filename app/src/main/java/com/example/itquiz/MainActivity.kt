package com.example.itquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.btn_start)
        val input = findViewById<EditText>(R.id.et_name)

        start.setOnClickListener{
            if (input.text.toString().isEmpty()){
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, Activity_Quiz::class.java)
                intent.putExtra(Constans.USER_NAME, input.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}