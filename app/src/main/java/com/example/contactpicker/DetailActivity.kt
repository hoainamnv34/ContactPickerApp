package com.example.contactpicker

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_detail)

        val bundle: Bundle? = intent.extras

        val name = bundle!!.getString("name")
        val phone = bundle!!.getString("phone")
        val email = bundle!!.getString("email")

        var nameTV: TextView = findViewById(R.id.textViewName)
        var phoneTV: TextView = findViewById(R.id.textViewPhone)
        var emailTV: TextView = findViewById(R.id.textViewEmail)
        var backBtn : ImageButton = findViewById(R.id.backBtn)

        nameTV.text = name
        phoneTV.text = phone
        emailTV.text = email


        backBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}