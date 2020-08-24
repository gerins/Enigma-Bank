package com.example.enigmabank.fragments.transaction.sendmoney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.enigmabank.R
import kotlinx.android.synthetic.main.fragment_input_recipent.*

class InputRecipentFragment : Fragment() {
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_recipent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonNextInputRecipent.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_inputRecipentFragment_to_inputNominalFragment)
        }
    }
}