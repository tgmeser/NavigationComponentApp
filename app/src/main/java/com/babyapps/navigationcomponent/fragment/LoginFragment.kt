package com.babyapps.navigationcomponent.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.babyapps.navigationcomponent.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_confirm.setOnClickListener {
            val username = edittext_username.text.toString()
            val password = edittext_password.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username,password)
            findNavController().navigate(action)
        }
    }
}