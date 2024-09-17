package com.mycompany.proyectofinal;

import com.mycompany.proyectofinal.logica.Alumno;
import com.mycompany.proyectofinal.logica.Carrera;
import com.mycompany.proyectofinal.logica.Controladora;
import com.mycompany.proyectofinal.logica.Materias;
import java.util.Date;
import java.util.LinkedList;



public class ProyectoJPA {

    public static void main(String[] args) {
        
        Controladora control = new Controladora();
        
        //Creacion de lista de Materias
        LinkedList<Materias> listaMaterias = new LinkedList<Materias> ();
        //Creacion de Carrera
        Carrera carre = new Carrera (25, "Licenciatura en IA", listaMaterias);
        
        //Guardado de Carrera
        control.crearCarrera(carre);
        
        //Creacion de Materias
        Materias mat1 = new Materias(1, "introduccion IA", 23283766, carre);
        Materias mat2 = new Materias(2, "Icloud nube", 42009554, carre);
        Materias mat3 = new Materias(3, "Educando a la IA", 26155588, carre);
        
        //Guardado de Materias
        control.crearMaterias(mat1);
        control.crearMaterias(mat2);
        control.crearMaterias(mat3);
        
        
        //Agrega a la lista de materias
        listaMaterias.add(mat1);
        listaMaterias.add(mat2);
        listaMaterias.add(mat3);
        
        carre.setListaMaterias(listaMaterias);
        control.editarCarrera(carre);
        
        //Creacion de Alumno
        Alumno al = new Alumno(42009554, "Luca", "ruiz", "Ciudad Mendoza", 26183722, new Date(), carre);
        
        //Guardado de Alumno
        control.crearAlumno(al);
        
        System.out.println("--------------------");
        System.out.println("-----Datos Alumno-----");
        Alumno alu = control.traerAlumno(42009554);
        System.out.println("Alumno: " + alu.getNombre() + " " + alu.getApellido());
        System.out.println("Cursa la carrera de: " + alu.getCarre().getNombre());
        

    }
}
