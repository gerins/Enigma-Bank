package com.example.enigmabank.fragments.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.enigmabank.MyApplication
import com.example.enigmabank.R
import com.example.enigmabank.model.user.InjectorUtility
import com.example.enigmabank.model.user.User
import com.example.enigmabank.model.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_login.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class UserLoginFragment : Fragment() {
    lateinit var imagename: MultipartBody.Part

//    @Inject lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userViewModel =
            ViewModelProvider(
                this,
                InjectorUtility.provideUserViewModelFactory()
            ).get(UserViewModel::class.java)

        buttonUserLogin.setOnClickListener {
            userViewModel.requestUserLogin(User(username = inputUsername.text.toString()))
        }

        buttonUploadImage.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_userLoginFragment_to_uploadImageActivity)
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