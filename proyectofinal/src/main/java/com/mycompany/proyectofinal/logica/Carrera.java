
package com.mycompany.proyectofinal.logica;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @OneToMany (mappedBy = "carre")
    private LinkedList<Materias> listaMaterias;

    public Carrera() {
    }

    public Carrera(int id, String nombre, LinkedList<Materias> listaMaterias) {
        this.id = id;
        this.nombre = nombre;
        this.listaMaterias = listaMaterias;
    }

    public LinkedList<Materias> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(LinkedList<Materias> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
