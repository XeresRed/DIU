/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;

import com.modelo.Gasto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Usuarios;
import com.persistencia.exceptions.NonexistentEntityException;
import com.persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Camilo
 */
public class GastoJpaController implements Serializable {

    public GastoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("UIPU");
    }
    
    public GastoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gasto gasto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuariosCorreo = gasto.getUsuariosCorreo();
            if (usuariosCorreo != null) {
                usuariosCorreo = em.getReference(usuariosCorreo.getClass(), usuariosCorreo.getCorreo());
                gasto.setUsuariosCorreo(usuariosCorreo);
            }
            em.persist(gasto);
            if (usuariosCorreo != null) {
                usuariosCorreo.getGastoCollection().add(gasto);
                usuariosCorreo = em.merge(usuariosCorreo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGasto(gasto.getIdgasto()) != null) {
                throw new PreexistingEntityException("Gasto " + gasto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gasto gasto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gasto persistentGasto = em.find(Gasto.class, gasto.getIdgasto());
            Usuarios usuariosCorreoOld = persistentGasto.getUsuariosCorreo();
            Usuarios usuariosCorreoNew = gasto.getUsuariosCorreo();
            if (usuariosCorreoNew != null) {
                usuariosCorreoNew = em.getReference(usuariosCorreoNew.getClass(), usuariosCorreoNew.getCorreo());
                gasto.setUsuariosCorreo(usuariosCorreoNew);
            }
            gasto = em.merge(gasto);
            if (usuariosCorreoOld != null && !usuariosCorreoOld.equals(usuariosCorreoNew)) {
                usuariosCorreoOld.getGastoCollection().remove(gasto);
                usuariosCorreoOld = em.merge(usuariosCorreoOld);
            }
            if (usuariosCorreoNew != null && !usuariosCorreoNew.equals(usuariosCorreoOld)) {
                usuariosCorreoNew.getGastoCollection().add(gasto);
                usuariosCorreoNew = em.merge(usuariosCorreoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gasto.getIdgasto();
                if (findGasto(id) == null) {
                    throw new NonexistentEntityException("The gasto with id " + id + " no longer exists.");
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
            Gasto gasto;
            try {
                gasto = em.getReference(Gasto.class, id);
                gasto.getIdgasto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gasto with id " + id + " no longer exists.", enfe);
            }
            Usuarios usuariosCorreo = gasto.getUsuariosCorreo();
            if (usuariosCorreo != null) {
                usuariosCorreo.getGastoCollection().remove(gasto);
                usuariosCorreo = em.merge(usuariosCorreo);
            }
            em.remove(gasto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gasto> findGastoEntities() {
        return findGastoEntities(true, -1, -1);
    }

    public List<Gasto> findGastoEntities(int maxResults, int firstResult) {
        return findGastoEntities(false, maxResults, firstResult);
    }

    private List<Gasto> findGastoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gasto.class));
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

    public Gasto findGasto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gasto.class, id);
        } finally {
            em.close();
        }
    }

    public int getGastoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gasto> rt = cq.from(Gasto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
