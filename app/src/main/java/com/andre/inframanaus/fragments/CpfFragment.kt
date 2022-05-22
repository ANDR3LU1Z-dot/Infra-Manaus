package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentCpfBinding


class CpfFragment : Fragment() {

    private lateinit var binding: FragmentCpfBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCpfBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinue = binding.btnCpfContinue

        val toolbar = binding.toolbarCpf

        toolbar.setNavigationIcon(R.drawable.ic_back_button)
        toolbar.setOnClickListener{

        }

        btnContinue.setOnClickListener{
            val cpffield = binding.cpffield.text.toString()

            if(cpffield.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Preencha o campo do CPF", Toast.LENGTH_SHORT).show()
            } else{
                findNavController().navigate(R.id.action_cpfFragment_to_dadosPessoaisFragment)
            }
        }


    }
}