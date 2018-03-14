/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;

import com.modelo.Organizador;
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
public class OrganizadorJpaController implements Serializable {
    
    public OrganizadorJpaController(){
        this.emf = Persistence.createEntityManagerFactory("UIPU");
    }
    
    public OrganizadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Organizador organizador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuariosCorreo = organizador.getUsuariosCorreo();
            if (usuariosCorreo != null) {
                usuariosCorreo = em.getReference(usuariosCorreo.getClass(), usuariosCorreo.getCorreo());
                organizador.setUsuariosCorreo(usuariosCorreo);
            }
            em.persist(organizador);
            if (usuariosCorreo != null) {
                usuariosCorreo.getOrganizadorCollection().add(organizador);
                usuariosCorreo = em.merge(usuariosCorreo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrganizador(organizador.getIdorganizador()) != null) {
                throw new PreexistingEntityException("Organizador " + organizador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Organizador organizador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organizador persistentOrganizador = em.find(Organizador.class, organizador.getIdorganizador());
            Usuarios usuariosCorreoOld = persistentOrganizador.getUsuariosCorreo();
            Usuarios usuariosCorreoNew = organizador.getUsuariosCorreo();
            if (usuariosCorreoNew != null) {
                usuariosCorreoNew = em.getReference(usuariosCorreoNew.getClass(), usuariosCorreoNew.getCorreo());
                organizador.setUsuariosCorreo(usuariosCorreoNew);
            }
            organizador = em.merge(organizador);
            if (usuariosCorreoOld != null && !usuariosCorreoOld.equals(usuariosCorreoNew)) {
                usuariosCorreoOld.getOrganizadorCollection().remove(organizador);
                usuariosCorreoOld = em.merge(usuariosCorreoOld);
            }
            if (usuariosCorreoNew != null && !usuariosCorreoNew.equals(usuariosCorreoOld)) {
                usuariosCorreoNew.getOrganizadorCollection().add(organizador);
                usuariosCorreoNew = em.merge(usuariosCorreoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = organizador.getIdorganizador();
                if (findOrganizador(id) == null) {
                    throw new NonexistentEntityException("The organizador with id " + id + " no longer exists.");
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
            Organizador organizador;
            try {
                organizador = em.getReference(Organizador.class, id);
                organizador.getIdorganizador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The organizador with id " + id + " no longer exists.", enfe);
            }
            Usuarios usuariosCorreo = organizador.getUsuariosCorreo();
            if (usuariosCorreo != null) {
                usuariosCorreo.getOrganizadorCollection().remove(organizador);
                usuariosCorreo = em.merge(usuariosCorreo);
            }
            em.remove(organizador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Organizador> findOrganizadorEntities() {
        return findOrganizadorEntities(true, -1, -1);
    }

    public List<Organizador> findOrganizadorEntities(int maxResults, int firstResult) {
        return findOrganizadorEntities(false, maxResults, firstResult);
    }

    private List<Organizador> findOrganizadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Organizador.class));
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

    public Organizador findOrganizador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Organizador.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrganizadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Organizador> rt = cq.from(Organizador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
