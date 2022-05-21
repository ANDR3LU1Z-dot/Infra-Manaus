package com.andre.inframanaus.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()

        }

        val toolbar = binding.toolbarRp

        toolbar.setNavigationIcon(R.drawable.ic_back_button)


    }
}