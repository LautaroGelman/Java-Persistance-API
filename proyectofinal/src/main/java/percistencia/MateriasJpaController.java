/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package percistencia;

import com.mycompany.proyectofinal.logica.Materias;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import percistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author NikoG
 */
public class MateriasJpaController implements Serializable {

    public MateriasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public MateriasJpaController (){
        emf = Persistence.createEntityManagerFactory("Proyectofinal");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materias materias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(materias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materias materias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            materias = em.merge(materias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = materias.getId();
                if (findMaterias(id) == null) {
                    throw new NonexistentEntityException("The materias with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materias materias;
            try {
                materias = em.getReference(Materias.class, id);
                materias.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materias with id " + id + " no longer exists.", enfe);
            }
            em.remove(materias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materias> findMateriasEntities() {
        return findMateriasEntities(true, -1, -1);
    }

    public List<Materias> findMateriasEntities(int maxResults, int firstResult) {
        return findMateriasEntities(false, maxResults, firstResult);
    }

    private List<Materias> findMateriasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materias.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Materias findMaterias(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materias.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materias> rt = cq.from(Materias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
