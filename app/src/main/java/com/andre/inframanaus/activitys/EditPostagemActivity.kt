package com.andre.inframanaus.activitys

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.FileProvider
import com.andre.inframanaus.InfraData
import com.andre.inframanaus.InfraData.rotateImage
import com.andre.inframanaus.R
import com.andre.inframanaus.databinding.ActivityEditPostagemBinding
import kotlinx.coroutines.*
import java.io.File

class EditPostagemActivity: AppCompatActivity() {
    var takenImage: Bitmap? = null
    val FILE_NAME =  "photo.jpg"
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var photoFile: File
    private var photo: Bitmap? = null

    //    private val photo = data
     private lateinit var binding: ActivityEditPostagemBinding

    override fun onResume() {
        super.onResume()
        val solicitacoes = resources.getStringArray(R.array.solicitacoes)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item, solicitacoes)
        binding.autoCompleteSolicitacao.setAdapter(arrayAdapter)

        val riscos = resources.getStringArray(R.array.risco)
        val arrayAdapterRiscos = ArrayAdapter(this, R.layout.dropdown_item, riscos)
        binding.autoCompleteRisco.setAdapter(arrayAdapterRiscos)
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
        toolbar.setOnClickListener{
            startActivity(Intent(this,PostangensActivity::class.java))
        }

        val image = binding.imagePost



        val btnTakePicture = binding.btnTirarFoto
        val btnConfirmar = binding.confirmarEnvioPostagem

        btnTakePicture.setOnClickListener{
            takePicture()
        }

        btnConfirmar.setOnClickListener{

        }

//        image.setImageBitmap(photo)

    }

    fun takePicture(){
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoFile(FILE_NAME)
        val fileProvider = FileProvider.getUriForFile(this, "com.andre.inframanaus.fileprovider",photoFile)
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
        if(takePictureIntent.resolveActivity(this.packageManager)!= null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } else{
            Toast.makeText(this, "Camera  desabilitada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
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
            binding.imagePost.setImageBitmap(photo)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }





}