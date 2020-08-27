package com.example.enigmabank

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.enigmabank.model.user.InjectorUtility
import com.example.enigmabank.model.user.UserViewModel
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_upload_image.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import pub.devrel.easypermissions.EasyPermissions
import java.io.File


class UploadImageActivity : AppCompatActivity() {
    lateinit var imageFileChoosed: MultipartBody.Part

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)
        val userViewModel =
            ViewModelProvider(
                this,
                InjectorUtility.provideUserViewModelFactory()
            ).get(UserViewModel::class.java)

        buttonUploadImage.setOnClickListener {
            userViewModel.uploadImage(imageFileChoosed)
        }

        buttonPickImage.setOnClickListener {
            if (EasyPermissions.hasPermissions(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {

                ImagePicker.with(this) // buat ngambil gambar, pake library implementation 'com.github.dhaval2404:imagepicker:1.7.4'
                    .compress(1024)                     //Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)     //Final image resolution will be less than 1080 x 1080(Optional)
//                    .cropSquare()
                    .start(300)

            } else {
                // pake library implementation 'pub.devrel:easypermissions:1.2.0'
                // tampilkan permission request saat belum mendapat permission dari user
                EasyPermissions.requestPermissions(
                    this,
                    "This application need your permission to access photo gallery.",
                    991,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 300 && resultCode == Activity.RESULT_OK) {
            val getFile = ImagePicker.getFile(data)!! // dapetin data gambar yang barusan dipilih
            Glide.with(this).load(getFile).circleCrop().into(imageChoosed) // Buat nampilin image yang dipilih, pake library glide

            val requestBody = RequestBody.create("multipart".toMediaTypeOrNull(), getFile)
            imageFileChoosed = MultipartBody.Part.createFormData("file", getFile.name, requestBody)

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}