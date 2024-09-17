
package percistencia;

import com.mycompany.proyectofinal.logica.Alumno;
import com.mycompany.proyectofinal.logica.Carrera;
import com.mycompany.proyectofinal.logica.Materias;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import percistencia.exceptions.NonexistentEntityException;


public class ControlodoraPersistencia {
    
    AlumnoJpaController aluJpa = new AlumnoJpaController();
    CarreraJpaController carreJpa = new CarreraJpaController();
    MateriasJpaController matJpa = new MateriasJpaController();
    
    public void crearAlumno(Alumno alu) {
        aluJpa.create(alu);
    }

    public void eliminarAlumno(int id) {
        try {
            aluJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlodoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAlumno(Alumno alu) {
        try {
            aluJpa.edit(alu);
        } catch (Exception ex) {
            Logger.getLogger(ControlodoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno traerAlumno(int id) {
        return aluJpa.findAlumno(id);
    }

    public ArrayList<Alumno> traerListaAlumnos() {
        List <Alumno> listita = aluJpa.findAlumnoEntities();
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno> (listita);
        
        return listaAlumnos;
    }

    
    //Carrera
    
    public ArrayList<Carrera> traerListaCarreras() {
        List <Carrera> lista = carreJpa.findCarreraEntities();
        ArrayList<Carrera> listaCarreras = new ArrayList<Carrera> (lista);
        return listaCarreras;
    }

    public Carrera traerCarrera(int id) {
        return carreJpa.findCarrera(id);
    }

    public void eliminarCarrera(int id) {
        try {
            carreJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlodoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCarrera(Carrera carre) {
        carreJpa.create(carre);
    }

    public void editarAlumno(Carrera carre) {
        try {
            carreJpa.edit(carre);
        } catch (Exception ex) {
            Logger.getLogger(ControlodoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Materias

    public ArrayList<Materias> traerListaMaterias() {
        List<Materias> lista = matJpa.findMateriasEntities();
        ArrayList <Materias> listaMaterias = new ArrayList (lista);
        return listaMaterias;
    }

    public Materias traerMaterias(int id) {
        return matJpa.findMaterias(id);
    }

    public void editarMaterias(Materias mat) {
        try {
            matJpa.edit(mat);
        } catch (Exception ex) {
            Logger.getLogger(ControlodoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMaterias(int id) {
        try {
            matJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlodoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearMaterias(Materias mat) {
        matJpa.create(mat);
    }
    
    
}
