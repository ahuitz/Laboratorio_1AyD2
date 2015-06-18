/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Tablas.TPersona;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rosario
 */
public class TPersonaJpaController implements Serializable {

    public TPersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TPersona TPersona) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TPersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTPersona(TPersona.getId()) != null) {
                throw new PreexistingEntityException("TPersona " + TPersona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TPersona TPersona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TPersona = em.merge(TPersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = TPersona.getId();
                if (findTPersona(id) == null) {
                    throw new NonexistentEntityException("The tPersona with id " + id + " no longer exists.");
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
            TPersona TPersona;
            try {
                TPersona = em.getReference(TPersona.class, id);
                TPersona.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TPersona with id " + id + " no longer exists.", enfe);
            }
            em.remove(TPersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TPersona> findTPersonaEntities() {
        return findTPersonaEntities(true, -1, -1);
    }

    public List<TPersona> findTPersonaEntities(int maxResults, int firstResult) {
        return findTPersonaEntities(false, maxResults, firstResult);
    }

    private List<TPersona> findTPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TPersona.class));
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

    public TPersona findTPersona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TPersona.class, id);
        } finally {
            em.close();
        }
    }

    public int getTPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TPersona> rt = cq.from(TPersona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
