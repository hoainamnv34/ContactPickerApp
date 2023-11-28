package com.example.contactpicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    lateinit var nameTextView: TextView
    lateinit var phoneTextView: TextView
    lateinit var emailTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView = view.findViewById(R.id.textViewName)
        phoneTextView = view.findViewById(R.id.textViewPhone)
        emailTextView = view.findViewById(R.id.textViewEmail)

        val arguments = arguments
        if (arguments != null) {
            val selectedContact = arguments.getStringArrayList("SELECTED_ITEM")

            if (selectedContact != null && selectedContact.size == 3) {
                displayContactDetails(selectedContact[0], selectedContact[1], selectedContact[2])
            }
        }
    }

    fun displayContactDetails(name: String, phone: String, email: String) {
        println(name)
        nameTextView.text = "Name: $name"
        phoneTextView.text = "Phone: $phone"
        emailTextView.text = "Email: $email"
    }
}