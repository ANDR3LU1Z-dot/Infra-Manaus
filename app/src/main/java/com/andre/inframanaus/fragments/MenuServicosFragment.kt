package com.andre.inframanaus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.inframanaus.R
import com.andre.inframanaus.adapter.MenuServicosAdapter
import com.andre.inframanaus.body.MenuSquareItem
import com.andre.inframanaus.databinding.FragmentMenuServicosBinding


class MenuServicosFragment : Fragment() {

    private lateinit var viewManager: GridLayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding : FragmentMenuServicosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuServicosBinding.inflate(inflater, container, false)
        val root = binding.root
        // Inflate the layout for this fragment
        return root

//        setupMenu()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

//    private fun setupMenu(){
//        val menuItens = ArrayList<MenuSquareItem>()
//
//        menuItens.add(MenuSquareItem("Desperdício de água", R.drawable.ic_faucet_icon))
//        menuItens.add(MenuSquareItem("Buracos em asfalto", R.drawable.ic_hole_icon))
//        menuItens.add(MenuSquareItem("Lixo descartado na rua", R.drawable.ic_trash))
//        menuItens.add(MenuSquareItem("Iluminação Pública", R.drawable.ic_bulb_light_icon))
//
//        viewManager = GridLayoutManager(context, 2)
//        viewAdapter = MenuServicosAdapter(menuItens, this.menuSquareItemClickListener() )
//
//        recyclerView = requireActivity().findViewById<RecyclerView>(R.id.lista_menu).apply {
//
//            setHasFixedSize(true)
//
//            layoutManager = viewManager
//
//            adapter = viewAdapter
//        }
//    }
//
//
//    private fun menuSquareItemClickListener(): MenuServicosAdapter.OnItemClickListener = object :
//        MenuServicosAdapter.OnItemClickListener {
//
//        override fun onItemClick(item: MenuSquareItem) {
//            when(item.drawable){
//
//
//
////                R.drawable.ic_fila_aguardando -> {
////                    findNavController().navigate(R.id.action_menuListaFragment_to_pendentesFragment)
////                }
////                R.drawable.ic_realizados -> {
////                    findNavController().navigate(R.id.action_menuListaFragment_to_concluidosFragment)
////                }
////                R.drawable.ic_evadiram -> {
////                    findNavController().navigate(R.id.action_menuListaFragment_to_evadiramFragment)
////                }
//
//
//            }
//        }
//
//    }



}