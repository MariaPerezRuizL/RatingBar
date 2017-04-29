package com.example.maria.ratingbar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maria on 29/4/17.
 */

public class Ayudante extends SQLiteOpenHelper {

    public Ayudante (Context ctx, String nombre)
    {
        super(ctx, nombre, null, 1);
    }

    //Método que se ejecuta al crear la BBDD
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Intrucción que crea la tabla
        String sqlCreaTabla="create table libros(";
        sqlCreaTabla+="_id integer primary key autoincrement,";
        sqlCreaTabla+="libro, leido)";

        //ejecutamos la instrucción
        db.execSQL(sqlCreaTabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
