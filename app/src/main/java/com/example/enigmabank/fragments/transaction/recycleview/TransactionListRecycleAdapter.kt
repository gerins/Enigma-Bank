package com.example.enigmabank.fragments.transaction.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmabank.R
import com.example.enigmabank.model.transaction.Transaction

class TransactionListRecycleAdapter(private val listTransaction: List<Transaction>) :
    RecyclerView.Adapter<TransactionListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_list_recycle_view, parent, false)
        return TransactionListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionListViewHolder, position: Int) {
        holder.transactionNominal.text = listTransaction[position].nominal
        holder.transactionDate.text = listTransaction[position].created
    }

    override fun getItemCount(): Int {
        return listTransaction.size
    }
}

class TransactionListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val transactionDate = view.findViewById<TextView>(R.id.transactionDateTextView)
    val transactionNominal = view.findViewById<TextView>(R.id.transactionNominalTextView)
}
