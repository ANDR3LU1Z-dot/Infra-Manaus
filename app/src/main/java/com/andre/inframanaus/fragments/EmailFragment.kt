package com.andre.inframanaus.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.andre.inframanaus.InfraData
import com.andre.inframanaus.R
import com.andre.inframanaus.activitys.LoginActivity
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

        binding.toolbarEmail.setNavigationIcon(R.drawable.ic_back_button)
        binding.toolbarEmail.setOnClickListener {
            findNavController().navigate(R.id.action_emailFragment_to_termosFragment)
        }

        val btnContinue = binding.btnEmailRegisterContinue



        btnContinue.setOnClickListener{
            val emailfield = binding.emailRegisterField.text.toString()
            if(emailfield.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Preencha o campo Email", Toast.LENGTH_SHORT).show()
            } else{
                InfraData.createModal(
                    requireContext(),
                    R.drawable.ic_letter,
                    R.string.email_confirmacao,
                    R.string.caixa_spam,
                    null

                )!!.setOnDismissListener{
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                }
            }
        }
    }


}