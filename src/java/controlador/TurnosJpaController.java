/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Canchas;
import modelo.Turnos;

/**
 *
 * @author DAVID
 */
public class TurnosJpaController implements Serializable {
    
      public TurnosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("webFutbol5PU");
    }

    public TurnosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turnos turnos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Canchas idCanchas = turnos.getIdCanchas();
            if (idCanchas != null) {
                idCanchas = em.getReference(idCanchas.getClass(), idCanchas.getIdCanchas());
                turnos.setIdCanchas(idCanchas);
            }
            em.persist(turnos);
            if (idCanchas != null) {
                idCanchas.getTurnosList().add(turnos);
                idCanchas = em.merge(idCanchas);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turnos turnos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turnos persistentTurnos = em.find(Turnos.class, turnos.getIdTurnos());
            Canchas idCanchasOld = persistentTurnos.getIdCanchas();
            Canchas idCanchasNew = turnos.getIdCanchas();
            if (idCanchasNew != null) {
                idCanchasNew = em.getReference(idCanchasNew.getClass(), idCanchasNew.getIdCanchas());
                turnos.setIdCanchas(idCanchasNew);
            }
            turnos = em.merge(turnos);
            if (idCanchasOld != null && !idCanchasOld.equals(idCanchasNew)) {
                idCanchasOld.getTurnosList().remove(turnos);
                idCanchasOld = em.merge(idCanchasOld);
            }
            if (idCanchasNew != null && !idCanchasNew.equals(idCanchasOld)) {
                idCanchasNew.getTurnosList().add(turnos);
                idCanchasNew = em.merge(idCanchasNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = turnos.getIdTurnos();
                if (findTurnos(id) == null) {
                    throw new NonexistentEntityException("The turnos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turnos turnos;
            try {
                turnos = em.getReference(Turnos.class, id);
                turnos.getIdTurnos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turnos with id " + id + " no longer exists.", enfe);
            }
            Canchas idCanchas = turnos.getIdCanchas();
            if (idCanchas != null) {
                idCanchas.getTurnosList().remove(turnos);
                idCanchas = em.merge(idCanchas);
            }
            em.remove(turnos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turnos> findTurnosEntities() {
        return findTurnosEntities(true, -1, -1);
    }

    public List<Turnos> findTurnosEntities(int maxResults, int firstResult) {
        return findTurnosEntities(false, maxResults, firstResult);
    }

    private List<Turnos> findTurnosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turnos.class));
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

    public Turnos findTurnos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turnos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turnos> rt = cq.from(Turnos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
