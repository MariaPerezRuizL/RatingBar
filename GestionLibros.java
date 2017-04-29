package com.example.maria.ratingbar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Maria on 29/4/17.
 */

public class GestionLibros {

    private Ayudante helper;
    private SQLiteDatabase bd;

    public GestionLibros(Context ctx){
        helper = new Ayudante(ctx, "cosas");
        //Abrimos la bd en modo escritura
        bd=helper.getWritableDatabase();
    }


    public void altaLibro(datos dat){
        ContentValues valores=new ContentValues();
        valores.put("libro", dat.getLibro().toString());
        valores.put("leido", dat.getLeido().toString());
        bd.insert("libros", null, valores);
    }

    public Cursor obtenerLibros(){
        return bd.query("libros", null, null, null, null, null, null);
    }

    public void cerrar(){
        helper.close();
    }
}
