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
import com.example.enigmabank.model.transaction.Transaction
import com.example.enigmabank.model.transaction.TransactionViewModel
import com.example.enigmabank.model.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_input_nominal.*


class InputNominalFragment : Fragment() {
    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    private val userViewModel by activityViewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_nominal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var userID = ""
        userViewModel.getUserInfo().observe(viewLifecycleOwner, Observer {
            userID = it.id
        })

        buttonNextInputNominal.setOnClickListener {
            transactionViewModel.fetchPostNewTransaction(Transaction(userID = userID, nominal = inputAmountTextInput.text.toString()))
            Navigation.findNavController(view).navigate(R.id.action_inputNominalFragment_to_transferSuccessFragment
            )
        }
    }
}