package com.andre.inframanaus.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andre.inframanaus.InfraData
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
        toolbar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }


        binding.buttonRecoverAccount.setOnClickListener{
            if(binding.recoverpasswordfield.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Preencha o campo Email", Toast.LENGTH_SHORT).show()
            } else {
                InfraData.createModal(
                    this,
                    R.drawable.ic_letter,
                    R.string.email_recuperacao,
                    R.string.caixa_spam,
                    null

                )!!.setOnDismissListener{
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }

        }

    }
}