package com.example.enigmabank.fragments.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmabank.R
import com.example.enigmabank.fragments.transaction.recycleview.TransactionListRecycleAdapter
import com.example.enigmabank.model.transaction.TransactionViewModel
import com.example.enigmabank.model.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_transaction_list.*


class TransactionListFragment : Fragment() {
    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    private val userViewModel by activityViewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.getUserInfo().observe(viewLifecycleOwner, Observer {
            transactionViewModel.fetchUserTransactionList(it.id)
        })

        transactionListRecyclerView.layoutManager = LinearLayoutManager(activity)
        transactionViewModel.getTransactionList().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                transactionListRecyclerView.adapter = TransactionListRecycleAdapter(it)
            }
        })
    }
}