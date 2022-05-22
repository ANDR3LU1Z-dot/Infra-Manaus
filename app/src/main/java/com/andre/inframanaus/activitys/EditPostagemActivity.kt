package com.andre.inframanaus.activitys

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andre.inframanaus.databinding.ActivityEditPostagemBinding
import com.andre.inframanaus.databinding.ActivityMenuServicosBinding

class EditPostagemActivity(photo: Bitmap) : AppCompatActivity() {
//    private val photo = data
     private lateinit var binding: ActivityEditPostagemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPostagemBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        val image = binding.imagePost

//        image.setImageBitmap(photo)

    }
}