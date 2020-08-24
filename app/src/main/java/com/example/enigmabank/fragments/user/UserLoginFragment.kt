package com.example.enigmabank.fragments.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.enigmabank.R
import com.example.enigmabank.model.user.User
import com.example.enigmabank.model.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_login.*

class UserLoginFragment : Fragment() {
    private val userViewModel by activityViewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonUserLogin.setOnClickListener {
            userViewModel.requestUserLogin(User(username = inputUsername.text.toString()))
        }

        userViewModel.getUserInfo().observe(viewLifecycleOwner, Observer {
            println("=============================")
            println("FRAGMENT LOGIN -> ")
            if (it != null) {
                println(it.id)
                println(it.username)
                println(it.balance)
                println(it.created)

                Navigation.findNavController(view)
                    .navigate(R.id.action_userLoginFragment_to_userMainMenuFragment)
            }
            println("=============================")
            loginFailedInfo.isVisible = true
        })
    }
}