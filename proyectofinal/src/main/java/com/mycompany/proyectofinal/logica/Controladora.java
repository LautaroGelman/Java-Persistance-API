
package com.mycompany.proyectofinal.logica;

import java.util.ArrayList;
import percistencia.ControlodoraPersistencia;

public class Controladora {
    
    ControlodoraPersistencia controlPersis = new ControlodoraPersistencia();
    
    public void crearAlumno (Alumno alu){
        
        controlPersis.crearAlumno (alu);
    }
    
    public void eliminarAlumno (int id){
        
        controlPersis.eliminarAlumno(id);
    }
    
    public void editarAlumno (Alumno alu) {
        controlPersis.editarAlumno(alu);
        
    }
    
    public Alumno traerAlumno (int id){
        
        return controlPersis.traerAlumno(id);
    }
    
    public ArrayList<Alumno> traerAlumnos (){
        return controlPersis.traerListaAlumnos();
    }
    
    //Carrera
    
    public void crearCarrera (Carrera carre){
        
        controlPersis.crearCarrera (carre);
    }
    
    public void eliminarCarrera (int id){
        
        controlPersis.eliminarCarrera(id);
    }
    
    public void editarCarrera (Carrera carre) {
        controlPersis.editarAlumno(carre);
        
    }
    
    public Carrera traerCarrera (int id){
        
        return controlPersis.traerCarrera(id);
    }
    
    public ArrayList<Carrera> traerCarrera (){
        return controlPersis.traerListaCarreras();
    }
    
    //Materias
    
    public void crearMaterias (Materias mat){
        
        controlPersis.crearMaterias (mat);
    }
    
    public void eliminaMaterias (int id){
        
        controlPersis.eliminarMaterias(id);
    }
    
    public void editarMaterias (Materias mat) {
        controlPersis.editarMaterias(mat);
        
    }
    
    public Materias traerMaterias (int id){
        
        return controlPersis.traerMaterias(id);
    }
    
    public ArrayList<Materias> traerMaterias (){
        return controlPersis.traerListaMaterias();
    }
}
