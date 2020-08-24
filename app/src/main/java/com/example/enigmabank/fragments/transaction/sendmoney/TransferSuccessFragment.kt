package com.example.enigmabank.fragments.transaction.sendmoney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.enigmabank.R
import com.example.enigmabank.model.user.User
import com.example.enigmabank.model.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_transfer_success.*


class TransferSuccessFragment : Fragment() {
    private val userViewModel by activityViewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transfer_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.getUserInfo().observe(viewLifecycleOwner, Observer {
            userViewModel.requestUserLogin(User(username = it.username))
        })

        buttonNextTransactionSuccess.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_transferSuccessFragment_to_userMainMenuFragment)
        }
    }
}