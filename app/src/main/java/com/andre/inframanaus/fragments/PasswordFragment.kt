package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentPostagensBinding
import com.andre.inframanaus.databinding.FragmentSenhaBinding


class PasswordFragment : Fragment() {
    lateinit var binding: FragmentSenhaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSenhaBinding.inflate(layoutInflater, container, false)
        val root = binding.root
        // Inflate the layout for this fragment
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnContinuePassword = binding.btnSenhaContinue

        btnContinuePassword.setOnClickListener{
            val senha = binding.senhaField.text.toString()
            val senhaConfirm = binding.comfirmSenhaField.text.toString()

            if(senha.isNullOrEmpty() && senhaConfirm.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Preencha os campos das senhas", Toast.LENGTH_SHORT).show()
            }

            if(senha != senhaConfirm){
                Toast.makeText(requireContext(), "A senhas precisam ser iguais", Toast.LENGTH_SHORT).show()
            }

            findNavController().navigate(R.id.action_senhaFragment_to_termosFragment)

        }

    }


}