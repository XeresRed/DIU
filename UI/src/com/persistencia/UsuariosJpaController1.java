/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Table04;
import com.modelo.Gasto;
import java.util.ArrayList;
import java.util.Collection;
import com.modelo.Organizador;
import com.modelo.Usuarios;
import com.persistencia.exceptions.IllegalOrphanException;
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
public class UsuariosJpaController1 implements Serializable {
    
    public UsuariosJpaController1(){
        this.emf = Persistence.createEntityManagerFactory("UIPU");
    }
    
    public UsuariosJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) throws PreexistingEntityException, Exception {
        if (usuarios.getGastoCollection() == null) {
            usuarios.setGastoCollection(new ArrayList<Gasto>());
        }
        if (usuarios.getOrganizadorCollection() == null) {
            usuarios.setOrganizadorCollection(new ArrayList<Organizador>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Table04 table04 = usuarios.getTable04();
            if (table04 != null) {
                table04 = em.getReference(table04.getClass(), table04.getUsuariosCorreo());
                usuarios.setTable04(table04);
            }
            Collection<Gasto> attachedGastoCollection = new ArrayList<Gasto>();
            for (Gasto gastoCollectionGastoToAttach : usuarios.getGastoCollection()) {
                gastoCollectionGastoToAttach = em.getReference(gastoCollectionGastoToAttach.getClass(), gastoCollectionGastoToAttach.getIdgasto());
                attachedGastoCollection.add(gastoCollectionGastoToAttach);
            }
            usuarios.setGastoCollection(attachedGastoCollection);
            Collection<Organizador> attachedOrganizadorCollection = new ArrayList<Organizador>();
            for (Organizador organizadorCollectionOrganizadorToAttach : usuarios.getOrganizadorCollection()) {
                organizadorCollectionOrganizadorToAttach = em.getReference(organizadorCollectionOrganizadorToAttach.getClass(), organizadorCollectionOrganizadorToAttach.getIdorganizador());
                attachedOrganizadorCollection.add(organizadorCollectionOrganizadorToAttach);
            }
            usuarios.setOrganizadorCollection(attachedOrganizadorCollection);
            em.persist(usuarios);
            if (table04 != null) {
                Usuarios oldUsuariosOfTable04 = table04.getUsuarios();
                if (oldUsuariosOfTable04 != null) {
                    oldUsuariosOfTable04.setTable04(null);
                    oldUsuariosOfTable04 = em.merge(oldUsuariosOfTable04);
                }
                table04.setUsuarios(usuarios);
                table04 = em.merge(table04);
            }
            for (Gasto gastoCollectionGasto : usuarios.getGastoCollection()) {
                Usuarios oldUsuariosCorreoOfGastoCollectionGasto = gastoCollectionGasto.getUsuariosCorreo();
                gastoCollectionGasto.setUsuariosCorreo(usuarios);
                gastoCollectionGasto = em.merge(gastoCollectionGasto);
                if (oldUsuariosCorreoOfGastoCollectionGasto != null) {
                    oldUsuariosCorreoOfGastoCollectionGasto.getGastoCollection().remove(gastoCollectionGasto);
                    oldUsuariosCorreoOfGastoCollectionGasto = em.merge(oldUsuariosCorreoOfGastoCollectionGasto);
                }
            }
            for (Organizador organizadorCollectionOrganizador : usuarios.getOrganizadorCollection()) {
                Usuarios oldUsuariosCorreoOfOrganizadorCollectionOrganizador = organizadorCollectionOrganizador.getUsuariosCorreo();
                organizadorCollectionOrganizador.setUsuariosCorreo(usuarios);
                organizadorCollectionOrganizador = em.merge(organizadorCollectionOrganizador);
                if (oldUsuariosCorreoOfOrganizadorCollectionOrganizador != null) {
                    oldUsuariosCorreoOfOrganizadorCollectionOrganizador.getOrganizadorCollection().remove(organizadorCollectionOrganizador);
                    oldUsuariosCorreoOfOrganizadorCollectionOrganizador = em.merge(oldUsuariosCorreoOfOrganizadorCollectionOrganizador);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarios(usuarios.getCorreo()) != null) {
                throw new PreexistingEntityException("Usuarios " + usuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getCorreo());
            Table04 table04Old = persistentUsuarios.getTable04();
            Table04 table04New = usuarios.getTable04();
            Collection<Gasto> gastoCollectionOld = persistentUsuarios.getGastoCollection();
            Collection<Gasto> gastoCollectionNew = usuarios.getGastoCollection();
            Collection<Organizador> organizadorCollectionOld = persistentUsuarios.getOrganizadorCollection();
            Collection<Organizador> organizadorCollectionNew = usuarios.getOrganizadorCollection();
            List<String> illegalOrphanMessages = null;
            if (table04Old != null && !table04Old.equals(table04New)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Table04 " + table04Old + " since its usuarios field is not nullable.");
            }
            for (Gasto gastoCollectionOldGasto : gastoCollectionOld) {
                if (!gastoCollectionNew.contains(gastoCollectionOldGasto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Gasto " + gastoCollectionOldGasto + " since its usuariosCorreo field is not nullable.");
                }
            }
            for (Organizador organizadorCollectionOldOrganizador : organizadorCollectionOld) {
                if (!organizadorCollectionNew.contains(organizadorCollectionOldOrganizador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Organizador " + organizadorCollectionOldOrganizador + " since its usuariosCorreo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (table04New != null) {
                table04New = em.getReference(table04New.getClass(), table04New.getUsuariosCorreo());
                usuarios.setTable04(table04New);
            }
            Collection<Gasto> attachedGastoCollectionNew = new ArrayList<Gasto>();
            for (Gasto gastoCollectionNewGastoToAttach : gastoCollectionNew) {
                gastoCollectionNewGastoToAttach = em.getReference(gastoCollectionNewGastoToAttach.getClass(), gastoCollectionNewGastoToAttach.getIdgasto());
                attachedGastoCollectionNew.add(gastoCollectionNewGastoToAttach);
            }
            gastoCollectionNew = attachedGastoCollectionNew;
            usuarios.setGastoCollection(gastoCollectionNew);
            Collection<Organizador> attachedOrganizadorCollectionNew = new ArrayList<Organizador>();
            for (Organizador organizadorCollectionNewOrganizadorToAttach : organizadorCollectionNew) {
                organizadorCollectionNewOrganizadorToAttach = em.getReference(organizadorCollectionNewOrganizadorToAttach.getClass(), organizadorCollectionNewOrganizadorToAttach.getIdorganizador());
                attachedOrganizadorCollectionNew.add(organizadorCollectionNewOrganizadorToAttach);
            }
            organizadorCollectionNew = attachedOrganizadorCollectionNew;
            usuarios.setOrganizadorCollection(organizadorCollectionNew);
            usuarios = em.merge(usuarios);
            if (table04New != null && !table04New.equals(table04Old)) {
                Usuarios oldUsuariosOfTable04 = table04New.getUsuarios();
                if (oldUsuariosOfTable04 != null) {
                    oldUsuariosOfTable04.setTable04(null);
                    oldUsuariosOfTable04 = em.merge(oldUsuariosOfTable04);
                }
                table04New.setUsuarios(usuarios);
                table04New = em.merge(table04New);
            }
            for (Gasto gastoCollectionNewGasto : gastoCollectionNew) {
                if (!gastoCollectionOld.contains(gastoCollectionNewGasto)) {
                    Usuarios oldUsuariosCorreoOfGastoCollectionNewGasto = gastoCollectionNewGasto.getUsuariosCorreo();
                    gastoCollectionNewGasto.setUsuariosCorreo(usuarios);
                    gastoCollectionNewGasto = em.merge(gastoCollectionNewGasto);
                    if (oldUsuariosCorreoOfGastoCollectionNewGasto != null && !oldUsuariosCorreoOfGastoCollectionNewGasto.equals(usuarios)) {
                        oldUsuariosCorreoOfGastoCollectionNewGasto.getGastoCollection().remove(gastoCollectionNewGasto);
                        oldUsuariosCorreoOfGastoCollectionNewGasto = em.merge(oldUsuariosCorreoOfGastoCollectionNewGasto);
                    }
                }
            }
            for (Organizador organizadorCollectionNewOrganizador : organizadorCollectionNew) {
                if (!organizadorCollectionOld.contains(organizadorCollectionNewOrganizador)) {
                    Usuarios oldUsuariosCorreoOfOrganizadorCollectionNewOrganizador = organizadorCollectionNewOrganizador.getUsuariosCorreo();
                    organizadorCollectionNewOrganizador.setUsuariosCorreo(usuarios);
                    organizadorCollectionNewOrganizador = em.merge(organizadorCollectionNewOrganizador);
                    if (oldUsuariosCorreoOfOrganizadorCollectionNewOrganizador != null && !oldUsuariosCorreoOfOrganizadorCollectionNewOrganizador.equals(usuarios)) {
                        oldUsuariosCorreoOfOrganizadorCollectionNewOrganizador.getOrganizadorCollection().remove(organizadorCollectionNewOrganizador);
                        oldUsuariosCorreoOfOrganizadorCollectionNewOrganizador = em.merge(oldUsuariosCorreoOfOrganizadorCollectionNewOrganizador);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuarios.getCorreo();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getCorreo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Table04 table04OrphanCheck = usuarios.getTable04();
            if (table04OrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Table04 " + table04OrphanCheck + " in its table04 field has a non-nullable usuarios field.");
            }
            Collection<Gasto> gastoCollectionOrphanCheck = usuarios.getGastoCollection();
            for (Gasto gastoCollectionOrphanCheckGasto : gastoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Gasto " + gastoCollectionOrphanCheckGasto + " in its gastoCollection field has a non-nullable usuariosCorreo field.");
            }
            Collection<Organizador> organizadorCollectionOrphanCheck = usuarios.getOrganizadorCollection();
            for (Organizador organizadorCollectionOrphanCheckOrganizador : organizadorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Organizador " + organizadorCollectionOrphanCheckOrganizador + " in its organizadorCollection field has a non-nullable usuariosCorreo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
