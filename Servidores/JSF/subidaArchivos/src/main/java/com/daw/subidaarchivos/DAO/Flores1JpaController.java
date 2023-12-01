/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.subidaarchivos.DAO;

import com.daw.subidaarchivos.DAO.exceptions.NonexistentEntityException;
import com.daw.subidaarchivos.DTO.Flores1;
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
 * @author Usuario
 */
public class Flores1JpaController implements Serializable {

    public Flores1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Flores1 flores1) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(flores1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Flores1 flores1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            flores1 = em.merge(flores1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = flores1.getCodigoFlor();
                if (findFlores1(id) == null) {
                    throw new NonexistentEntityException("The flores1 with id " + id + " no longer exists.");
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
            Flores1 flores1;
            try {
                flores1 = em.getReference(Flores1.class, id);
                flores1.getCodigoFlor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The flores1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(flores1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Flores1> findFlores1Entities() {
        return findFlores1Entities(true, -1, -1);
    }

    public List<Flores1> findFlores1Entities(int maxResults, int firstResult) {
        return findFlores1Entities(false, maxResults, firstResult);
    }

    private List<Flores1> findFlores1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Flores1.class));
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

    public Flores1 findFlores1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Flores1.class, id);
        } finally {
            em.close();
        }
    }

    public int getFlores1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Flores1> rt = cq.from(Flores1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
