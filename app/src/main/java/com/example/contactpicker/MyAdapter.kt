package com.example.contactpicker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val contactList: List<ContactModel>, private val context: Context) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var avtTV: TextView
    private lateinit var nameTV: TextView

    override fun getCount(): Int {
        return contactList.size;
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView;

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.contact_item, null)
        }

        avtTV = convertView!!.findViewById(R.id.avt)
        avtTV.text = contactList[position].name[0].toString()
        nameTV = convertView!!.findViewById(R.id.name)
        nameTV.text = contactList[position].name


        return convertView;
    }






}

