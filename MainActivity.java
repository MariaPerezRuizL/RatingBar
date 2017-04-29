package com.example.maria.ratingbar;


import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends AppCompatActivity {


    ListView lvTodos;


    //Declaro los edittext
    EditText edtLibro;
    EditText edtLeido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrar (View v){

        //Obtengo las referencias a los editText LIBRO Y LEIDO
        edtLibro=(EditText)this.findViewById(R.id.etLibro);
        edtLeido=(EditText)this.findViewById(R.id.edtLeido);

        //Creo un objeto datos y guardo los valores
        datos libro=new datos(edtLibro.getText().toString(),
                edtLeido.getText().toString());

        //Accedemos a la base de datos y lo guardamos
        GestionLibros gLib=new GestionLibros(this);

        gLib.altaLibro(libro);
        gLib.cerrar();



    }

    public void mostrar(View v){

        //Creo objeto de la clase gestión de la bbdd
        GestionLibros gLib=new GestionLibros(this);

        SimpleCursorAdapter adp=new SimpleCursorAdapter(this,
                R.layout.fila,
                gLib.obtenerLibros(),
                new String[] {"libro", "leido", "puntuacion"},
                new int []{R.id.tvLibro, R.id.tvLeid, R.id.tvPuntuacion},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        //Asigno el adaptador al listview y volcamos el contenido
        lvTodos.setAdapter(adp);
        gLib.cerrar();


    }
}
