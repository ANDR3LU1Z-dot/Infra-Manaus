package com.andre.inframanaus.activitys

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.inframanaus.R
import com.andre.inframanaus.adapter.MenuServicosAdapter
import com.andre.inframanaus.body.MenuSquareItem
import com.andre.inframanaus.databinding.ActivityMenuServicosBinding


private const val REQUEST_CODE = 42

class MenuServicosActivity : AppCompatActivity() {
    private lateinit var viewManager: GridLayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    private lateinit var binding: com.andre.inframanaus.databinding.ActivityMenuServicosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuServicosBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        val toolbar = binding.toolbar

        toolbar.setNavigationIcon(R.drawable.ic_back_button)
        toolbar.setOnClickListener {
            startActivity(Intent(this, PostangensActivity::class.java))
        }
        setupMenu()
    }


    private fun setupMenu() {
        val menuItens = ArrayList<MenuSquareItem>()

        menuItens.add(MenuSquareItem("Desperdício de água", R.drawable.ic_desperdicio_agua))
        menuItens.add(MenuSquareItem("Buracos em asfalto", R.drawable.ic_roda_presa))
        menuItens.add(MenuSquareItem("Lixo descartado na rua", R.drawable.ic_lixo))
        menuItens.add(MenuSquareItem("Iluminação Pública", R.drawable.ic_iluminacao_publica))

        viewManager = GridLayoutManager(this, 2)
        viewAdapter = MenuServicosAdapter(menuItens, this.menuSquareItemClickListener())

        recyclerView = this.findViewById<RecyclerView>(R.id.lista_menu).apply {

            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }
    }


    private fun menuSquareItemClickListener(): MenuServicosAdapter.OnItemClickListener = object :
        MenuServicosAdapter.OnItemClickListener {

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        override fun onItemClick(item: MenuSquareItem) {
            when (item.drawable) {


                R.drawable.ic_roda_presa -> {
                    startActivity(Intent(this@MenuServicosActivity, EditPostagemActivity::class.java))
//                    @Suppress("DEPRECATION")
//                    if (takePictureIntent.resolveActivity(this@MenuServicosActivity.packageManager) != null) {
//                        startActivityForResult(takePictureIntent, REQUEST_CODE)
//                    } else {
//                        Toast.makeText(
//                            this@MenuServicosActivity,
//                            "Camera desabilitada",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
                }
                R.drawable.ic_iluminacao_publica -> {
                    startActivity(Intent(this@MenuServicosActivity, EditPostagemActivity::class.java))

//                    @Suppress("DEPRECATION")
//                    if (takePictureIntent.resolveActivity(this@MenuServicosActivity.packageManager) != null) {
//                        startActivityForResult(takePictureIntent, REQUEST_CODE)
//                    } else {
//                        Toast.makeText(
//                            this@MenuServicosActivity,
//                            "Camera desabilitada",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }

                }
                R.drawable.ic_desperdicio_agua -> {
                    startActivity(Intent(this@MenuServicosActivity, EditPostagemActivity::class.java))

//                    @Suppress("DEPRECATION")
//                    if (takePictureIntent.resolveActivity(this@MenuServicosActivity.packageManager) != null) {
//                        startActivityForResult(takePictureIntent, REQUEST_CODE)
//                    } else {
//                        Toast.makeText(
//                            this@MenuServicosActivity,
//                            "Camera desabilitada",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }

                }

                R.drawable.ic_lixo -> {
                    startActivity(Intent(this@MenuServicosActivity, EditPostagemActivity::class.java))

//                    @Suppress("DEPRECATION")
//                    if (takePictureIntent.resolveActivity(this@MenuServicosActivity.packageManager) != null) {
//                        startActivityForResult(takePictureIntent, REQUEST_CODE)
//                    } else {
//                        Toast.makeText(
//                            this@MenuServicosActivity,
//                            "Camera desabilitada",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }

                }


            }
        }

    }

//    @Suppress("DEPRECATION")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
//        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
//            val takenImage = data?.data!! as Bitmap
//        } else{
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//
//
//    }



}