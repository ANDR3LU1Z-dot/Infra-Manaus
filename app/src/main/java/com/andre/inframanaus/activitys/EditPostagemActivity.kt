package com.andre.inframanaus.activitys

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.FileProvider
import com.andre.inframanaus.InfraData
import com.andre.inframanaus.InfraData.reduzBitmap
import com.andre.inframanaus.InfraData.rotateImage
import com.andre.inframanaus.InfraData.takenImage
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.ActivityEditPostagemBinding
import com.andre.inframanaus.databinding.ItemPostagemBinding
import kotlinx.coroutines.*
import java.io.File

class EditPostagemActivity: AppCompatActivity() {

    val FILE_NAME = "photo.jpg"
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var photoFile: File
    private var photo: Bitmap? = null

    //    private val photo = data
    private lateinit var binding: ActivityEditPostagemBinding

    override fun onResume() {
        super.onResume()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPostagemBinding.inflate(layoutInflater)
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

        val image = binding.imagePost


        val btnTakePicture = binding.btnTirarFoto
        val btnConfirmar = binding.confirmarEnvioPostagem
//        val tipo_solicitacao = binding.autoCompleteSolicitacao


        val solicitacoes = resources.getStringArray(R.array.solicitacoes)
        val arrayAdapterSolicitacoes =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, solicitacoes)
        binding.menuSolicitacoes.setAdapter(arrayAdapterSolicitacoes)
        val menuSolicitacoes = binding.menuSolicitacoes

        val riscos = resources.getStringArray(R.array.risco)
        val arrayAdapterRiscos =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, riscos)
        binding.menuRiscos.setAdapter(arrayAdapterRiscos)
        val menuRiscos = binding.menuRiscos





        btnTakePicture.setOnClickListener {
            dispatchTakePictureIntent()
        }

        btnConfirmar.setOnClickListener {

//            Toast.makeText(this, solicitacoes[menuSolicitacoes.selectedItemPosition], Toast.LENGTH_LONG).show()
            if (photo != null) {
                InfraData.base64Img = InfraData.convertToBase64(reduzBitmap(this.photo!!)!!)

                InfraData.tipo_solicitacao = solicitacoes[menuSolicitacoes.selectedItemPosition]
                InfraData.tipoRisco = riscos[menuRiscos.selectedItemPosition]
                InfraData.comentario = binding.editcomentarioField.text.toString()
                modalSucesso()

            } else {
                Toast.makeText(this, "Obrigat??rio uma foto para a postagem", Toast.LENGTH_LONG)
                    .show()
            }


//            startActivity(Intent(this,EditPostagem2::class.java))
        }

//        image.setImageBitmap(photo)

        fun showDialog() {
            val binding = ItemPostagemBinding.inflate(layoutInflater)
            val alertDialog = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.dialog_cancel, null)

            alertDialog.setView(view)
            val dialog = alertDialog.create()
            dialog.show()

//        val btnConfirnar = view.
//        val btnCancelar = view.btn_cancelar_coleta

//        btnConfirnar.setOnClickListener {
//
////            getExames(cardListaExames)
////            getExamsColected(cardListaExames)
////            Log.i("Todos exames", "${getExames}")
////            Log.i("exames coletados", "${examesColetados}")
//            dialog.dismiss()
//        }
//
//
//        btnCancelar.setOnClickListener{
//            dialog.dismiss()
//
//        }

        }
    }







        fun modalSucesso() {
            InfraData.createModal(
                this,
                R.drawable.ic_check,
                R.string.denuncia_enviada,
                R.string.subtitulo_denuncia_enviada,
                R.string.nothing,
            )

        }

        /**
         * M??todo criado para realizar a foto de perfil do usu??rio
         */
        private fun dispatchTakePictureIntent() {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (takePictureIntent.resolveActivity(this.packageManager) != null) {

                try {
                    photoFile = InfraData.createImageFile(this)
                    if (photoFile != null) {
                        var photoURI = FileProvider.getUriForFile(
                            this,
                            "com.andre.inframanaus.fileprovider",
                            photoFile
                        )

                        takePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            photoURI
                        )
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }

//    private fun getPhotoFile(fileName: String): File {
//        val storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//        return File.createTempFile(fileName, ".jpg", storageDirectory)
//    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
                val uri = Uri.fromFile(photoFile)
                photo = BitmapFactory.decodeFile(uri.path)
                val exif = ExifInterface(uri.path!!)
                val orientation =
                    exif.getAttributeInt(
                        ExifInterface.TAG_ORIENTATION,
                        ExifInterface.ORIENTATION_UNDEFINED
                    )
                photo?.let {
                    photo = rotateImage(it, orientation)
                }
                takenImage = photo
                InfraData.base64Img = InfraData.convertToBase64(reduzBitmap(this.photo!!)!!)
                binding.imagePost.setImageBitmap(photo)
            }
            super.onActivityResult(requestCode, resultCode, data)
        }


    }
