package com.andre.inframanaus.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andre.inframanaus.R
import com.andre.inframanaus.interfaces.CardOnClickListener
import com.andre.inframanaus.activitys.DetalhesDenunciaActivity
import com.andre.inframanaus.activitys.requisicoes.ApiRetrofit
import com.andre.inframanaus.activitys.requisicoes.InfraNetwork
import com.andre.inframanaus.adapter.DenunciasAdapter
import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.MockupDenuncias
import com.andre.inframanaus.body.cardPostagensList
import com.andre.inframanaus.databinding.DialogLoadBinding
import com.andre.inframanaus.databinding.FragmentPostagensBinding

class PostagensFragment : Fragment(), CardOnClickListener {

    lateinit var bindingDialogLogin : DialogLoadBinding
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


        bindingDialogLogin = DialogLoadBinding.inflate(inflater, container, false)
        _binding = FragmentPostagensBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listView = binding.listaPostagens

        listView.layoutManager = LinearLayoutManager(requireContext())

        listView.adapter = DenunciasAdapter(cardPostagensList, this)

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api by lazy {
            ApiRetrofit(requireContext())
        }
        val denuncias = InfraNetwork.listarDenuncias(api)

        fun populateCards(){
            val card1 = MockupDenuncias(
                "Alto",
                "André",
                "Buraco em Asfalto",
                "A",
                R.drawable.buraco


                )

            val card2 = MockupDenuncias(
                "Alto",
                "Jairo",
                "Buraco em Asfalto",
                "B",
                R.drawable.buraco2,

                )

            val card3 = MockupDenuncias(
                "Alto",
                "Gabriel",
                "Buraco em Asfalto",
                "B",
                R.drawable.buraco_baixo,

                )

            val card4 = MockupDenuncias(
                "Alto",
                "Jefson",
                "Buraco em Asfalto",
                "A",
                R.drawable.cratera_asfalto,

                )

            val card5 = MockupDenuncias(
                "Alto",
                "Deyse",
                "Buraco em Asfalto",
                "A" ,
                R.drawable.cratera_2

            )







            cardPostagensList.add(card1)
            cardPostagensList.add(card2)
            cardPostagensList.add(card3)
            cardPostagensList.add(card4)
            cardPostagensList.add(card5)

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


