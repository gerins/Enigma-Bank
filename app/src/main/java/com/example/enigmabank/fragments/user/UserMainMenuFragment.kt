package com.example.enigmabank.fragments.user

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.enigmabank.MyApplication
import com.example.enigmabank.R
import com.example.enigmabank.model.user.User
import com.example.enigmabank.model.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_main_menu.*
import javax.inject.Inject

class UserMainMenuFragment : Fragment() {
    //    private val userViewModel by activityViewModels<UserViewModel>()
    @Inject lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_main_menu, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.getUserInfo().observe(viewLifecycleOwner, Observer {
            balanceUserInfo.setText("$ ${it.balance}")
            usernameUserInfo.setText(it.username)
        })

        buttonGoToHistoryTransaction.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_userMainMenuFragment_to_transactionListFragment)
        }

        buttonGoToTransaction.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_userMainMenuFragment_to_inputRecipentFragment)
        }
    }
}