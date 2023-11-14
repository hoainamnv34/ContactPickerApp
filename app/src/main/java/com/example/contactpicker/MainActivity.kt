package com.example.contactpicker

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactList = ArrayList<ContactModel>()

        repeat(10) {
            contactList.add(ContactModel("$it", "Name_$it", "Phone_$it", "Email_$it"))
        }

        var contactLV: ListView = findViewById(R.id.lv)

        val contactAdapter = MyAdapter(contactList = contactList, this@MainActivity)

        contactLV.adapter = contactAdapter;


        contactLV.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", contactList[position].name)
            intent.putExtra("phone", contactList[position].phone)
            intent.putExtra("email", contactList[position].mail)

            startActivity(intent)

        }


        registerForContextMenu(contactLV)
        println("hello nam2")
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        println("hello nam")
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.contact_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {


        return when (item.itemId) {
            R.id.menu_call -> {
                showToast("Call menu for position ")
                true
            }

            R.id.menu_send_email -> {
                showToast("Send email menu for position ")
                true
            }

            R.id.menu_send_sms -> {
                showToast("Send SMS menu for position ")
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}
