/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;

import com.modelo.Table04;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Usuarios;
import com.persistencia.exceptions.IllegalOrphanException;
import com.persistencia.exceptions.NonexistentEntityException;
import com.persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Camilo
 */
public class Table04JpaController implements Serializable {
    
    public Table04JpaController(){
        this.emf = Persistence.createEntityManagerFactory("UIPU");
    }
    
    public Table04JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Table04 table04) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Usuarios usuariosOrphanCheck = table04.getUsuarios();
        if (usuariosOrphanCheck != null) {
            Table04 oldTable04OfUsuarios = usuariosOrphanCheck.getTable04();
            if (oldTable04OfUsuarios != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Usuarios " + usuariosOrphanCheck + " already has an item of type Table04 whose usuarios column cannot be null. Please make another selection for the usuarios field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios = table04.getUsuarios();
            if (usuarios != null) {
                usuarios = em.getReference(usuarios.getClass(), usuarios.getCorreo());
                table04.setUsuarios(usuarios);
            }
            em.persist(table04);
            if (usuarios != null) {
                usuarios.setTable04(table04);
                usuarios = em.merge(usuarios);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTable04(table04.getUsuariosCorreo()) != null) {
                throw new PreexistingEntityException("Table04 " + table04 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Table04 table04) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Table04 persistentTable04 = em.find(Table04.class, table04.getUsuariosCorreo());
            Usuarios usuariosOld = persistentTable04.getUsuarios();
            Usuarios usuariosNew = table04.getUsuarios();
            List<String> illegalOrphanMessages = null;
            if (usuariosNew != null && !usuariosNew.equals(usuariosOld)) {
                Table04 oldTable04OfUsuarios = usuariosNew.getTable04();
                if (oldTable04OfUsuarios != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Usuarios " + usuariosNew + " already has an item of type Table04 whose usuarios column cannot be null. Please make another selection for the usuarios field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (usuariosNew != null) {
                usuariosNew = em.getReference(usuariosNew.getClass(), usuariosNew.getCorreo());
                table04.setUsuarios(usuariosNew);
            }
            table04 = em.merge(table04);
            if (usuariosOld != null && !usuariosOld.equals(usuariosNew)) {
                usuariosOld.setTable04(null);
                usuariosOld = em.merge(usuariosOld);
            }
            if (usuariosNew != null && !usuariosNew.equals(usuariosOld)) {
                usuariosNew.setTable04(table04);
                usuariosNew = em.merge(usuariosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = table04.getUsuariosCorreo();
                if (findTable04(id) == null) {
                    throw new NonexistentEntityException("The table04 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Table04 table04;
            try {
                table04 = em.getReference(Table04.class, id);
                table04.getUsuariosCorreo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The table04 with id " + id + " no longer exists.", enfe);
            }
            Usuarios usuarios = table04.getUsuarios();
            if (usuarios != null) {
                usuarios.setTable04(null);
                usuarios = em.merge(usuarios);
            }
            em.remove(table04);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Table04> findTable04Entities() {
        return findTable04Entities(true, -1, -1);
    }

    public List<Table04> findTable04Entities(int maxResults, int firstResult) {
        return findTable04Entities(false, maxResults, firstResult);
    }

    private List<Table04> findTable04Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Table04.class));
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

    public Table04 findTable04(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Table04.class, id);
        } finally {
            em.close();
        }
    }

    public int getTable04Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Table04> rt = cq.from(Table04.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
