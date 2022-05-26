package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentTermosBinding


class TermsFragment : Fragment() {
    lateinit var binding: FragmentTermosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermosBinding.inflate(layoutInflater, container, false)
        val root = binding.root
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarTermos.setNavigationIcon(R.drawable.ic_back_button)
        binding.toolbarTermos.setOnClickListener {
            findNavController().navigate(R.id.action_termosFragment_to_senhaFragment)
        }
        val btnContinueTermos = binding.btnTermos


        btnContinueTermos.setOnClickListener{
            if(binding.checkTermos.isChecked){
                findNavController().navigate(R.id.action_termosFragment_to_emailFragment)
            } else{
                Toast.makeText(requireContext(), "É necessário aceitar os termos de uso", Toast.LENGTH_SHORT).show()
            }

        }
    }


}