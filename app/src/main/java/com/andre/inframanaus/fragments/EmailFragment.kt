package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailBinding.inflate(inflater, container, false)

        val root : View = binding.root

        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnContinue = binding.btnEmailRegisterContinue
        val emailfield = binding.emailRegisterField.text.toString()


        btnContinue.setOnClickListener{
            if(emailfield.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Preencha o campo Email", Toast.LENGTH_SHORT).show()
            }
        }
    }


}