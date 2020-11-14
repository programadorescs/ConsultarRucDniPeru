package com.pcs.consultarrucdniperu.snippets;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import java.util.Iterator;

public class Utilidad {
    public static void OcultarTeclado(Context contexto, View view){
        InputMethodManager imm = (InputMethodManager) contexto.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void LimpiarEditText(View view){
        Iterator<View> it = view.getTouchables().iterator();
        while (it.hasNext()){
            View v = it.next();
            if ((v instanceof EditText)) ((EditText) v).setText("");
        }
    }

    public static void MostrarMensaje(String titulo, String mensaje, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setCancelable(false)
                .setPositiveButton("Aceptar",
                        (dialog, id) -> dialog.cancel());
        builder.create().show();
    }
}
