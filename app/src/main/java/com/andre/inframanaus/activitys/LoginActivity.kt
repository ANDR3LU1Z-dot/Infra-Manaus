package com.andre.inframanaus.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val buttonlogar = binding.btnSignIn

        buttonlogar.setOnClickListener{
            val email = binding.emailfield.text.toString()
            val senha = binding.passwordfield.text.toString()

            if(email != "" && senha != ""){
                if(email == "inframanaus@gmail.com" && senha == "infra123"){
                    startActivity(Intent(this, UserQuestionActivity::class.java))
                    finish()

                } else{
                   Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
            } else {
//                Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Preencha os campos de email e senha", Toast.LENGTH_SHORT).show()
            }


        }

        val forgotPassword = binding.forgotPassword
        val signUp = binding.signUp

        forgotPassword.setOnClickListener{
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        signUp.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }


        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }



    }


}