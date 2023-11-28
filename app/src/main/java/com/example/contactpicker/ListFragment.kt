package com.example.contactpicker

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    private val detailFragment = DetailFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactLV = view.findViewById<ListView>(R.id.list_view)

        val contactList = ArrayList<ContactModel>()

        repeat(20) {
            contactList.add(ContactModel("$it", "Name_$it", "Phone_$it", "Email_$it"))
        }
        val contactAdapter = MyAdapter(contactList = contactList, requireContext())

        contactLV.adapter = contactAdapter;


        contactLV.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            println("here nam");

            val selectedContact = contactList[position]

            val bundle = Bundle()
            bundle.putStringArrayList(
                "SELECTED_ITEM",
                ArrayList(listOf(selectedContact.name, selectedContact.phone, selectedContact.mail))
            )

            findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)

        }

    }


}


