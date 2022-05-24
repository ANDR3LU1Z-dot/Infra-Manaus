package com.andre.inframanaus

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.os.Build
import android.os.Environment
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.*

object InfraData {

    var base64Img: String? = ""
    var takenImage: Bitmap? = null
    var tipo_solicitacao: String = ""
    var tipoRisco: String = ""
    var comentario: String = ""

    /**
     * Método criado para envio da foto
     * @return AlertDialogMessage
     */

    fun reduzBitmap(bmpFotoRotation: Bitmap): Bitmap? {
        return Bitmap.createScaledBitmap(
            bmpFotoRotation,  //                (int) (bmpFotoRotation.getWidth() * 0.1), (int) (bmpFotoRotation.getHeight() * 0.1)
            200, 200
            , true
        )
    }

    /**
     * Método que cria a imagem de perfil do usuário
     * @param context Contexto
     */
    fun createImageFile(context: Context): File {
        val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "profilephoto", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        )
    }

    /**
     *
     * Método que cria modal de carregamento
     * @param context Contexto na aplicação
     * @param show Flag para exibir ou não o modal
     * @return AlertDialog
     *
     * */
    fun createLoadDialog(context: Context, show: Boolean): AlertDialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.dialog_load)
        builder.setCancelable(false)
        val modal = builder.create()
        modal.setCanceledOnTouchOutside(false)
        if (show) modal.show()
        return modal
    }

    /**
     * Método que rotaciona imagem para ser enviada corretamente para o reconhecimento facial e ser utilizada no aplicativo
     */
    fun rotateImage(source: Bitmap, orientation: Int): Bitmap? {
        val matrix = Matrix()
        when (orientation) {

            ExifInterface.ORIENTATION_NORMAL -> {
                return source
            }
            ExifInterface.ORIENTATION_ROTATE_90 -> {
                matrix.setRotate(90F)
            }
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> {
                matrix.setScale(-1F, 1F)
            }
            ExifInterface.ORIENTATION_ROTATE_180 -> {
                matrix.setRotate(180F)
            }
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> {
                matrix.setRotate(180F)
                matrix.postScale(-1F, 1F)
            }
            ExifInterface.ORIENTATION_TRANSPOSE -> {
                matrix.setRotate(90F)
                matrix.postScale(-1F, 1F)
            }
            ExifInterface.ORIENTATION_TRANSVERSE -> {
                matrix.setRotate(-90F)
                matrix.postScale(-1F, 1F)
            }
            ExifInterface.ORIENTATION_UNDEFINED, ExifInterface.ORIENTATION_ROTATE_270 -> {
//                matrix.setRotate(-90F);
                return source
            }

        }
        try {
            val bmRotated = Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
            source.recycle()
            return bmRotated
        } catch (e: OutOfMemoryError) {
            e.printStackTrace()
            return null
        }
    }

    /**
     * Método que converte um bitmap para uma string de Base64
     * @param imagem Bitmap
     */
    fun convertToBase64(imagem: Bitmap): String? {
        val stream = ByteArrayOutputStream()
        imagem.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val byteFormat = stream.toByteArray()

        val imgString = if (Build.VERSION.SDK_INT >= 26) {
            Base64.getEncoder().encodeToString(byteFormat)
        } else {
            android.util.Base64.encodeToString(byteFormat, android.util.Base64.DEFAULT)
        }
        return imgString
    }


    /**
     * Método que converte a string Base64 em um bitmap
     * @param base64 String a ser convertida
     */
    fun convertBase64ToBitmap(base64: String): Bitmap? {

        val data = android.util.Base64.decode(base64, android.util.Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(data, 0, data.size)

    }


}