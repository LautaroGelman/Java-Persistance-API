
package com.mycompany.proyectofinal.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Materias implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    private int profesor_dni;
    
    
    @ManyToOne
    private Carrera carre;
    
    public Materias() {
    }

    
    
    public Materias(int id, String nombre, int profesor_dni, Carrera carre) {
        this.id = id;
        this.nombre = nombre;
        this.profesor_dni = profesor_dni;
        this.carre = carre;
    }

    
    
    
    public Carrera getCarre() {
        return carre;
    }

    public void setCarre(Carrera carre) {
        this.carre = carre;
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

    public int getProfesor_dni() {
        return profesor_dni;
    }

    
    
    public void setProfesor_dni(int profesor_dni) {
        this.profesor_dni = profesor_dni;
    }
    
    
}
