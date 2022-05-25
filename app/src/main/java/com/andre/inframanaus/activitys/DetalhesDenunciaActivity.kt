package com.andre.inframanaus.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.ActivityDetalhesDenunciaBinding

class DetalhesDenunciaActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalhesDenunciaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityDetalhesDenunciaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


    }
}