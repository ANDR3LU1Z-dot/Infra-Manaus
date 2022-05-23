package com.andre.inframanaus

import android.content.Context
import android.os.Environment
import androidx.appcompat.app.AlertDialog
import java.io.File

object InfraData {

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

}