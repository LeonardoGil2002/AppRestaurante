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
import elpatio.elpatioapp.logica.FormaDePago;
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
public class FormaDePagoJpaController implements Serializable {

    public FormaDePagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public FormaDePagoJpaController(){
        emf = Persistence.createEntityManagerFactory("ElPatioAppPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    ///CLASES CREADAS POR MI
    
    //Traer forma de pago por nombre
    public FormaDePago traerUnaFormaDePagoPorNombre(String nombre){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT f FROM FormaDePago f WHERE f.formaDePago_FP = :name", FormaDePago.class)
                .setParameter("name", nombre)
                .getSingleResult();
        } finally {
            em.close();
        }
        
    }
    
    
    //// MÉTODOS CREADOS POR EL CONTROLLER ////
    
    public void create(FormaDePago formaDePago) {
        if (formaDePago.getFactura_FP() == null) {
            formaDePago.setFactura_FP(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Factura> attachedFactura_FP = new ArrayList<Factura>();
            for (Factura factura_FPFacturaToAttach : formaDePago.getFactura_FP()) {
                factura_FPFacturaToAttach = em.getReference(factura_FPFacturaToAttach.getClass(), factura_FPFacturaToAttach.getId_Fa());
                attachedFactura_FP.add(factura_FPFacturaToAttach);
            }
            formaDePago.setFactura_FP(attachedFactura_FP);
            em.persist(formaDePago);
            for (Factura factura_FPFactura : formaDePago.getFactura_FP()) {
                FormaDePago oldFormaDePago_FaOfFactura_FPFactura = factura_FPFactura.getFormaDePago_Fa();
                factura_FPFactura.setFormaDePago_Fa(formaDePago);
                factura_FPFactura = em.merge(factura_FPFactura);
                if (oldFormaDePago_FaOfFactura_FPFactura != null) {
                    oldFormaDePago_FaOfFactura_FPFactura.getFactura_FP().remove(factura_FPFactura);
                    oldFormaDePago_FaOfFactura_FPFactura = em.merge(oldFormaDePago_FaOfFactura_FPFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FormaDePago formaDePago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FormaDePago persistentFormaDePago = em.find(FormaDePago.class, formaDePago.getId_FP());
            List<Factura> factura_FPOld = persistentFormaDePago.getFactura_FP();
            List<Factura> factura_FPNew = formaDePago.getFactura_FP();
            ArrayList<Factura> attachedFactura_FPNew = new ArrayList<Factura>();
            for (Factura factura_FPNewFacturaToAttach : factura_FPNew) {
                factura_FPNewFacturaToAttach = em.getReference(factura_FPNewFacturaToAttach.getClass(), factura_FPNewFacturaToAttach.getId_Fa());
                attachedFactura_FPNew.add(factura_FPNewFacturaToAttach);
            }
            factura_FPNew = attachedFactura_FPNew;
            formaDePago.setFactura_FP(factura_FPNew);
            formaDePago = em.merge(formaDePago);
            for (Factura factura_FPOldFactura : factura_FPOld) {
                if (!factura_FPNew.contains(factura_FPOldFactura)) {
                    factura_FPOldFactura.setFormaDePago_Fa(null);
                    factura_FPOldFactura = em.merge(factura_FPOldFactura);
                }
            }
            for (Factura factura_FPNewFactura : factura_FPNew) {
                if (!factura_FPOld.contains(factura_FPNewFactura)) {
                    FormaDePago oldFormaDePago_FaOfFactura_FPNewFactura = factura_FPNewFactura.getFormaDePago_Fa();
                    factura_FPNewFactura.setFormaDePago_Fa(formaDePago);
                    factura_FPNewFactura = em.merge(factura_FPNewFactura);
                    if (oldFormaDePago_FaOfFactura_FPNewFactura != null && !oldFormaDePago_FaOfFactura_FPNewFactura.equals(formaDePago)) {
                        oldFormaDePago_FaOfFactura_FPNewFactura.getFactura_FP().remove(factura_FPNewFactura);
                        oldFormaDePago_FaOfFactura_FPNewFactura = em.merge(oldFormaDePago_FaOfFactura_FPNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = formaDePago.getId_FP();
                if (findFormaDePago(id) == null) {
                    throw new NonexistentEntityException("The formaDePago with id " + id + " no longer exists.");
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
            FormaDePago formaDePago;
            try {
                formaDePago = em.getReference(FormaDePago.class, id);
                formaDePago.getId_FP();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formaDePago with id " + id + " no longer exists.", enfe);
            }
            List<Factura> factura_FP = formaDePago.getFactura_FP();
            for (Factura factura_FPFactura : factura_FP) {
                factura_FPFactura.setFormaDePago_Fa(null);
                factura_FPFactura = em.merge(factura_FPFactura);
            }
            em.remove(formaDePago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FormaDePago> findFormaDePagoEntities() {
        return findFormaDePagoEntities(true, -1, -1);
    }

    public List<FormaDePago> findFormaDePagoEntities(int maxResults, int firstResult) {
        return findFormaDePagoEntities(false, maxResults, firstResult);
    }

    private List<FormaDePago> findFormaDePagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FormaDePago.class));
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

    public FormaDePago findFormaDePago(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FormaDePago.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormaDePagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FormaDePago> rt = cq.from(FormaDePago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
