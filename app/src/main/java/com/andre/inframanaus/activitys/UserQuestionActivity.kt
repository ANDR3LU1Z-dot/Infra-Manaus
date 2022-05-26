package com.andre.inframanaus.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andre.inframanaus.InfraData
import com.andre.inframanaus.databinding.FragmentUserQuestionBinding

class UserQuestionActivity : AppCompatActivity() {
    lateinit var binding: FragmentUserQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentUserQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUserContinue.setOnClickListener{
            val userField = binding.userField.text.toString()
            if(userField.isNullOrEmpty()){
                Toast.makeText(this, "Obrigatório criar um nome de usuário para prosseguir", Toast.LENGTH_LONG)
                    .show()
            } else {
                InfraData.userName = userField
                startActivity(Intent(this,PostangensActivity::class.java))
                finish()
            }
        }
    }
}