package com.example.enigmabank.model.transaction

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository(val transactionAPI: TransactionAPI) {
    var transactionListLiveData = MutableLiveData<List<Transaction>>()

    fun fetchUserTransactionList(id:String){
        transactionAPI.fetchUserTransactionList(id).enqueue(object : Callback<List<Transaction>>{
            override fun onResponse(call: Call<List<Transaction>>, response: Response<List<Transaction>>) {
                transactionListLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                println("=============================")
                print("FETCHING USER TRANSACTION FAILED -> ")
                println(t)
                println("=============================")
            }
        })
    }

    fun fetchPostNewTransaction(transaction: Transaction){
        transactionAPI.fetchPostNewTransaction(transaction).enqueue(object : Callback<Transaction>{
            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                println("=============================")
                print("FETCHING POST TRANSACTION SUCCESS -> ")
                println(response.code())
                println("=============================")
            }

            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                println("=============================")
                print("FETCHING POST TRANSACTION FAILED -> ")
                println(t)
                println("=============================")
            }

        })
    }
}