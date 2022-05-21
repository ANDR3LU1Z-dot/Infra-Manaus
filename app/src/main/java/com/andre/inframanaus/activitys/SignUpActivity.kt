package com.andre.inframanaus.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andre.inframanaus.R

class SignUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}