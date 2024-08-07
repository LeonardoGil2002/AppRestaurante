/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elpatio.elpatioapp.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import elpatio.elpatioapp.logica.Factura;
import elpatio.elpatioapp.logica.Mesa;
import elpatio.elpatioapp.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leo
 */
public class MesaJpaController implements Serializable {

    public MesaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public MesaJpaController(){
        emf = Persistence.createEntityManagerFactory("ElPatioAppPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    
    //MÉTODOS CREADOS POR MI
    
    //Comprobamos la existencia de una mesa en particular. Si devuelve 0 no existe y si devuelve 1 existe.
    public int comprobarExistenciaMesa(int id) {
        EntityManager em = getEntityManager();
        try {
            Mesa me = em.find(Mesa.class, id);
            if(me==null){
                return 0;
            }
            return 1;
        }
        finally {
            em.close();
        }
    }
    
    
    
    
    ///MÉTODOS CREADOS POR EL CONTROLADOR
    public void create(Mesa mesa) {
        if (mesa.getFactura_Fa() == null) {
            mesa.setFactura_Fa(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Factura> attachedFactura_Fa = new ArrayList<Factura>();
            for (Factura factura_FaFacturaToAttach : mesa.getFactura_Fa()) {
                factura_FaFacturaToAttach = em.getReference(factura_FaFacturaToAttach.getClass(), factura_FaFacturaToAttach.getId_Fa());
                attachedFactura_Fa.add(factura_FaFacturaToAttach);
            }
            mesa.setFactura_Fa(attachedFactura_Fa);
            em.persist(mesa);
            for (Factura factura_FaFactura : mesa.getFactura_Fa()) {
                Mesa oldMesa_FaOfFactura_FaFactura = factura_FaFactura.getMesa_Fa();
                factura_FaFactura.setMesa_Fa(mesa);
                factura_FaFactura = em.merge(factura_FaFactura);
                if (oldMesa_FaOfFactura_FaFactura != null) {
                    oldMesa_FaOfFactura_FaFactura.getFactura_Fa().remove(factura_FaFactura);
                    oldMesa_FaOfFactura_FaFactura = em.merge(oldMesa_FaOfFactura_FaFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mesa mesa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mesa persistentMesa = em.find(Mesa.class, mesa.getNumeroMesa_Me());
            List<Factura> factura_FaOld = persistentMesa.getFactura_Fa();
            List<Factura> factura_FaNew = mesa.getFactura_Fa();
            ArrayList<Factura> attachedFactura_FaNew = new ArrayList<Factura>();
            for (Factura factura_FaNewFacturaToAttach : factura_FaNew) {
                factura_FaNewFacturaToAttach = em.getReference(factura_FaNewFacturaToAttach.getClass(), factura_FaNewFacturaToAttach.getId_Fa());
                attachedFactura_FaNew.add(factura_FaNewFacturaToAttach);
            }
            factura_FaNew = attachedFactura_FaNew;
            mesa.setFactura_Fa(factura_FaNew);
            mesa = em.merge(mesa);
            for (Factura factura_FaOldFactura : factura_FaOld) {
                if (!factura_FaNew.contains(factura_FaOldFactura)) {
                    factura_FaOldFactura.setMesa_Fa(null);
                    factura_FaOldFactura = em.merge(factura_FaOldFactura);
                }
            }
            for (Factura factura_FaNewFactura : factura_FaNew) {
                if (!factura_FaOld.contains(factura_FaNewFactura)) {
                    Mesa oldMesa_FaOfFactura_FaNewFactura = factura_FaNewFactura.getMesa_Fa();
                    factura_FaNewFactura.setMesa_Fa(mesa);
                    factura_FaNewFactura = em.merge(factura_FaNewFactura);
                    if (oldMesa_FaOfFactura_FaNewFactura != null && !oldMesa_FaOfFactura_FaNewFactura.equals(mesa)) {
                        oldMesa_FaOfFactura_FaNewFactura.getFactura_Fa().remove(factura_FaNewFactura);
                        oldMesa_FaOfFactura_FaNewFactura = em.merge(oldMesa_FaOfFactura_FaNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mesa.getNumeroMesa_Me();
                if (findMesa(id) == null) {
                    throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.");
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
            Mesa mesa;
            try {
                mesa = em.getReference(Mesa.class, id);
                mesa.getNumeroMesa_Me();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesa with id " + id + " no longer exists.", enfe);
            }
            List<Factura> factura_Fa = mesa.getFactura_Fa();
            for (Factura factura_FaFactura : factura_Fa) {
                factura_FaFactura.setMesa_Fa(null);
                factura_FaFactura = em.merge(factura_FaFactura);
            }
            em.remove(mesa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mesa> findMesaEntities() {
        return findMesaEntities(true, -1, -1);
    }

    public List<Mesa> findMesaEntities(int maxResults, int firstResult) {
        return findMesaEntities(false, maxResults, firstResult);
    }

    private List<Mesa> findMesaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mesa.class));
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

    public Mesa findMesa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mesa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMesaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mesa> rt = cq.from(Mesa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
