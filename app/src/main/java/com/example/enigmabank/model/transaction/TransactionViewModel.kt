package com.example.enigmabank.model.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigmabank.utility.RetrofitBuilder

class TransactionViewModel : ViewModel() {
    private val transactionRepository =
        TransactionRepository(RetrofitBuilder.createRetrofit().create(TransactionAPI::class.java))

    fun getTransactionList() =
        transactionRepository.transactionListLiveData as LiveData<List<Transaction>>

    fun fetchUserTransactionList(id: String) = transactionRepository.fetchUserTransactionList(id)

    fun fetchPostNewTransaction(transaction: Transaction) = transactionRepository.fetchPostNewTransaction(transaction)
}