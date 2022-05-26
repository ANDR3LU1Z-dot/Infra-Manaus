package com.andre.inframanaus.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andre.inframanaus.R
import com.andre.inframanaus.activitys.PostangensActivity
import com.andre.inframanaus.databinding.FragmentUserQuestionBinding


class UserQuestionFragment : Fragment() {
    lateinit var binding: FragmentUserQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserQuestionBinding.inflate(inflater, container, false)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnUserContinue.setOnClickListener{
            val userField = binding.userField.text.toString()
            if(userField.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Obrigatório criar um nome de usuário para prosseguir", Toast.LENGTH_LONG)
                    .show()
            } else {
                startActivity(Intent(requireContext(),PostangensActivity::class.java))
            }
        }
    }
}