package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentDadosPessoaisBinding


class DadosPessoaisFragment : Fragment() {

    private lateinit var binding : FragmentDadosPessoaisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDadosPessoaisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinue = binding.btnDadosContinue

        binding.toolbarDadosPessoais.setNavigationIcon(R.drawable.ic_back_button)
        binding.toolbarDadosPessoais.setOnClickListener {
            findNavController().navigate(R.id.action_dadosPessoaisFragment_to_cpfFragment)
        }

        btnContinue.setOnClickListener{
            findNavController().navigate(R.id.action_dadosPessoaisFragment_to_nomeCompletoFragment)
        }
    }


}