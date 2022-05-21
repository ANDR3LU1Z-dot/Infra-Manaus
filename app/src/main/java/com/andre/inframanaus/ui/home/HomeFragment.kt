package com.andre.inframanaus.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andre.inframanaus.CardOnClickListener
import com.andre.inframanaus.R
import com.andre.inframanaus.adapter.CardPostagensAdapter
import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.cardPostagensList
import com.andre.inframanaus.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), CardOnClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listView = binding.listaPostagens

        listView.layoutManager = LinearLayoutManager(requireContext())

        listView.adapter = CardPostagensAdapter(cardPostagensList, this)

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun populateCards(){
            val card1 = BodyCardPostagens(
                "Alto",
                "André",
                "A"
            )

            val card2 = BodyCardPostagens(
                "Baixo",
                "Jairo",
                "B"
            )

            val card3 = BodyCardPostagens(
                "Médio",
                "Gabriel",
                "M"
            )

            val card4 = BodyCardPostagens(
                "Alto",
                "Jefson",
                "A"
            )

            val card5 = BodyCardPostagens(
                "Médio",
                "Deyse",
                "M"
            )

            val card6 = BodyCardPostagens(
                "Alto",
                "Luna Allen Pereira",
                "A"
            )


            val card7 = BodyCardPostagens(
                "Médio",
                "Mera Sampaio Torres",
                "M"
            )

            val card8 = BodyCardPostagens(
                "Alto",
                "Louis Helena Silva",
                "A"
            )

            val card9 = BodyCardPostagens(
                "Baixo",
                "Jason Todd da Silva",
                "B"
            )

            val card10 = BodyCardPostagens(
                "Médio",
                "Edward Nigma",
                "M"
            )

            cardPostagensList.add(card1)
            cardPostagensList.add(card2)
            cardPostagensList.add(card3)
            cardPostagensList.add(card4)
            cardPostagensList.add(card5)
            cardPostagensList.add(card6)
            cardPostagensList.add(card7)
            cardPostagensList.add(card8)
            cardPostagensList.add(card9)
            cardPostagensList.add(card10)
        }


        populateCards()
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(cardPostagens: BodyCardPostagens) {
        findNavController().navigate(R.id.action_nav_home_to_postagemFragment)
    }
}


