package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentTelefoneBinding


class PhoneFragment : Fragment() {
    private lateinit var binding : FragmentTelefoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTelefoneBinding.inflate(inflater,container, false)
        val root : View = binding.root

        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinue = binding.btnPhoneContinue


        btnContinue.setOnClickListener{
            val phonefield = binding.phonefield.text.toString()
            if (phonefield.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Preencha o campo do Telefone", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_telefoneFragment_to_cepFragment)
            }
        }

    }


}