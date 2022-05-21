package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andre.inframanaus.databinding.FragmentPostagemBinding
import kotlinx.android.synthetic.main.fragment_postagem.*


class PostagemFragment : Fragment() {
    private lateinit var binding: FragmentPostagemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostagemBinding.inflate(inflater, container, false)

        val root = binding.root
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val toolbar = binding.toolbarPostagemDetalhes

//        toolbar_postagem_detalhes.setNavigationIcon(R.drawable.ic_back_button)
//        toolbar.setOnClickListener{
//            findNavController().navigate(R.id.action_postagemFragment_to_nav_home)
//        }

    }

}