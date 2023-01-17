/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Turnos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Canchas;

/**
 *
 * @author DAVID
 */
public class CanchasJpaController implements Serializable {
    
      public CanchasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("webFutbol5PU");
    }

    public CanchasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Canchas canchas) {
        if (canchas.getTurnosList() == null) {
            canchas.setTurnosList(new ArrayList<Turnos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turnos> attachedTurnosList = new ArrayList<Turnos>();
            for (Turnos turnosListTurnosToAttach : canchas.getTurnosList()) {
                turnosListTurnosToAttach = em.getReference(turnosListTurnosToAttach.getClass(), turnosListTurnosToAttach.getIdTurnos());
                attachedTurnosList.add(turnosListTurnosToAttach);
            }
            canchas.setTurnosList(attachedTurnosList);
            em.persist(canchas);
            for (Turnos turnosListTurnos : canchas.getTurnosList()) {
                Canchas oldIdCanchasOfTurnosListTurnos = turnosListTurnos.getIdCanchas();
                turnosListTurnos.setIdCanchas(canchas);
                turnosListTurnos = em.merge(turnosListTurnos);
                if (oldIdCanchasOfTurnosListTurnos != null) {
                    oldIdCanchasOfTurnosListTurnos.getTurnosList().remove(turnosListTurnos);
                    oldIdCanchasOfTurnosListTurnos = em.merge(oldIdCanchasOfTurnosListTurnos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Canchas canchas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Canchas persistentCanchas = em.find(Canchas.class, canchas.getIdCanchas());
            List<Turnos> turnosListOld = persistentCanchas.getTurnosList();
            List<Turnos> turnosListNew = canchas.getTurnosList();
            List<String> illegalOrphanMessages = null;
            for (Turnos turnosListOldTurnos : turnosListOld) {
                if (!turnosListNew.contains(turnosListOldTurnos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Turnos " + turnosListOldTurnos + " since its idCanchas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Turnos> attachedTurnosListNew = new ArrayList<Turnos>();
            for (Turnos turnosListNewTurnosToAttach : turnosListNew) {
                turnosListNewTurnosToAttach = em.getReference(turnosListNewTurnosToAttach.getClass(), turnosListNewTurnosToAttach.getIdTurnos());
                attachedTurnosListNew.add(turnosListNewTurnosToAttach);
            }
            turnosListNew = attachedTurnosListNew;
            canchas.setTurnosList(turnosListNew);
            canchas = em.merge(canchas);
            for (Turnos turnosListNewTurnos : turnosListNew) {
                if (!turnosListOld.contains(turnosListNewTurnos)) {
                    Canchas oldIdCanchasOfTurnosListNewTurnos = turnosListNewTurnos.getIdCanchas();
                    turnosListNewTurnos.setIdCanchas(canchas);
                    turnosListNewTurnos = em.merge(turnosListNewTurnos);
                    if (oldIdCanchasOfTurnosListNewTurnos != null && !oldIdCanchasOfTurnosListNewTurnos.equals(canchas)) {
                        oldIdCanchasOfTurnosListNewTurnos.getTurnosList().remove(turnosListNewTurnos);
                        oldIdCanchasOfTurnosListNewTurnos = em.merge(oldIdCanchasOfTurnosListNewTurnos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = canchas.getIdCanchas();
                if (findCanchas(id) == null) {
                    throw new NonexistentEntityException("The canchas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Canchas canchas;
            try {
                canchas = em.getReference(Canchas.class, id);
                canchas.getIdCanchas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The canchas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Turnos> turnosListOrphanCheck = canchas.getTurnosList();
            for (Turnos turnosListOrphanCheckTurnos : turnosListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Canchas (" + canchas + ") cannot be destroyed since the Turnos " + turnosListOrphanCheckTurnos + " in its turnosList field has a non-nullable idCanchas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(canchas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Canchas> findCanchasEntities() {
        return findCanchasEntities(true, -1, -1);
    }

    public List<Canchas> findCanchasEntities(int maxResults, int firstResult) {
        return findCanchasEntities(false, maxResults, firstResult);
    }

    private List<Canchas> findCanchasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Canchas.class));
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

    public Canchas findCanchas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Canchas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCanchasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Canchas> rt = cq.from(Canchas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
