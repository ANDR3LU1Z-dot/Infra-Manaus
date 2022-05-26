package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentNomeUsuarioBinding
import com.andre.inframanaus.databinding.FragmentTelefoneBinding


class UserNameFragment : Fragment() {
    private lateinit var binding: FragmentNomeUsuarioBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentNomeUsuarioBinding.inflate(layoutInflater, container, false)
        val root = binding.root
        // Inflate the layout for this fragment
        return root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarUserName.setNavigationIcon(R.drawable.ic_back_button)
        binding.toolbarUserName.setOnClickListener {
            findNavController().navigate(R.id.action_nomeUsuarioFragment_to_nomeCompletoFragment)
        }

        val btnContinue = binding.btnUserContinue



        btnContinue.setOnClickListener {
            val userField = binding.userField.text.toString()
            if (userField.isEmpty()) {
                Toast.makeText(requireContext(), "Preencha o campo do Usuario", Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(R.id.action_nomeUsuarioFragment_to_telefoneFragment)
            }
        }
    }




}