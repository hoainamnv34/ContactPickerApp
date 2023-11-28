package com.example.contactpicker

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    val addContactFragment = AddContactFragment()

    val listFragment = ListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_list, listFragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println("hello nam 1")
        when (item.itemId) {
            R.id.add -> {
                println("hello nam 2")
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_list, addContactFragment)
                    .addToBackStack(null) // Để quay lại Fragment trước đó
                    .commit()
                return true
            }
            // Xử lý các item khác nếu cần
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
