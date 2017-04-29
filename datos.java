package com.example.maria.ratingbar;



import java.io.Serializable;

/**
 * Created by Maria on 28/4/17.
 */

public class datos implements Serializable{

    private String Libro;
    private String leido;

    public datos(String libro, String leido) {
        Libro = libro;
        this.leido = leido;
    }

    public String getLibro() {
        return Libro;
    }

    public void setLibro(String libro) {
        Libro = libro;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }
}
