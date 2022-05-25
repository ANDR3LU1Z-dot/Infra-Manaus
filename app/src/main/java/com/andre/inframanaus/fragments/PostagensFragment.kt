package com.andre.inframanaus.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andre.inframanaus.interfaces.CardOnClickListener
import com.andre.inframanaus.R
import com.andre.inframanaus.activitys.DetalhesDenunciaActivity
import com.andre.inframanaus.adapter.CardPostagensAdapter
import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.cardPostagensList
import com.andre.inframanaus.databinding.FragmentPostagensBinding

class PostagensFragment : Fragment(), CardOnClickListener {

    private var _binding: FragmentPostagensBinding? = null

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

        _binding = FragmentPostagensBinding.inflate(inflater, container, false)
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
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"

            )

            val card2 = BodyCardPostagens(
                "Alto",
                "Jairo",
                "Buraco em Asfalto",
                R.drawable.buraco2,
                "B"
            )

            val card3 = BodyCardPostagens(
                "Alto",
                "Gabriel",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "M"
            )

            val card4 = BodyCardPostagens(
                "Alto",
                "Jefson",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
            )

            val card5 = BodyCardPostagens(
                "Alto",
                "Deyse",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "M"
            )

            val card6 = BodyCardPostagens(
                "Alto",
                "André",
                "Sávio",
                R.drawable.buraco,
                "B"
            )


            val card7 = BodyCardPostagens(
                "Alto",
                "Afonso",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
            )

            val card8 = BodyCardPostagens(
                "Alto",
                "Carlos",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
            )

            val card9 = BodyCardPostagens(
                "Alto",
                "Janes",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
            )

            val card10 = BodyCardPostagens(
                "Alto",
                "Edrean",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
            )

            val card11 = BodyCardPostagens(
                "Alto",
                "Suellen",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
            )

            val card12 = BodyCardPostagens(
                "Alto",
                "Paulo",
                "Buraco em Asfalto",
                R.drawable.buraco,
                "A"
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
            cardPostagensList.add(card11)
        }


        populateCards()
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(cardPostagens: BodyCardPostagens) {
        startActivity(Intent(requireContext(), DetalhesDenunciaActivity::class.java))
    }
}


