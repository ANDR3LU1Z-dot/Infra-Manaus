package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentCepBinding


class CepFragment : Fragment() {
    private lateinit var binding : FragmentCepBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCepBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inflate the layout for this fragment
        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinue = binding.btnCepContinue
        val cepfield = binding.cepfield.text.toString()
        btnContinue.setOnClickListener{
            if(cepfield.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Preencha o campo do CEP", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_cepFragment_to_senhaFragment)
            }
        }
    }


}