/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elpatio.elpatioapp.persistencia;

import elpatio.elpatioapp.logica.Factura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import elpatio.elpatioapp.logica.Mesa;
import elpatio.elpatioapp.logica.FormaDePago;
import elpatio.elpatioapp.persistencia.exceptions.NonexistentEntityException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Leo
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public FacturaJpaController(){
        emf = Persistence.createEntityManagerFactory("ElPatioAppPU");
    }
   
    ///MÉTODOS CREADOS POR MI
    
        //Traer el número de factura de una mesa específica ocupada
        public int traerNumeroDeFactura(int numeroMesa) {
            EntityManager em = getEntityManager();
            try {
                String jpql = "SELECT f.id_Fa FROM Factura f WHERE f.estado_Fa = 'En proceso' AND f.mesa_Fa.numeroMesa_Me = :numeroMesa";
                TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
                query.setParameter("numeroMesa", numeroMesa);

                Integer result = query.getSingleResult();
                return (result != null) ? result : -1; // Devuelve -1 si no hay resultado
            } catch (NoResultException e) {
                return -1; // Manejo de caso cuando no hay resultado
            } finally {
                em.close();
            }
        }
        
        
        //Traer el número de factura de una mesa específica ocupada
        public List<Factura> filtroFechaFacturas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
            EntityManager em = getEntityManager();
            try {
                // Definir la consulta JPQL con INNER JOIN basado en la relación y filtros por fecha
                String jpql = "SELECT f FROM Factura f WHERE f.fecha_Fa BETWEEN :fechaInicio AND :fechaFin";

                // Crear la consulta
                TypedQuery<Factura> query = em.createQuery(jpql, Factura.class);

                // Establecer los parámetros de la consulta
                query.setParameter("fechaInicio", fechaDesde);
                query.setParameter("fechaFin", fechaHasta);

                // Ejecutar la consulta y obtener los resultados
                return query.getResultList();
            } finally {
                // Cerrar el EntityManager
                em.close();
            }
        }
    
    
    ///MÉTODOS CREADOS POR EL JPA CONTROLLER
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mesa mesa_Fa = factura.getMesa_Fa();
            if (mesa_Fa != null) {
                mesa_Fa = em.getReference(mesa_Fa.getClass(), mesa_Fa.getNumeroMesa_Me());
                factura.setMesa_Fa(mesa_Fa);
            }
            FormaDePago formaDePago_Fa = factura.getFormaDePago_Fa();
            if (formaDePago_Fa != null) {
                formaDePago_Fa = em.getReference(formaDePago_Fa.getClass(), formaDePago_Fa.getId_FP());
                factura.setFormaDePago_Fa(formaDePago_Fa);
            }
            em.persist(factura);
            if (mesa_Fa != null) {
                mesa_Fa.getFactura_Fa().add(factura);
                mesa_Fa = em.merge(mesa_Fa);
            }
            if (formaDePago_Fa != null) {
                formaDePago_Fa.getFactura_FP().add(factura);
                formaDePago_Fa = em.merge(formaDePago_Fa);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getId_Fa());
            Mesa mesa_FaOld = persistentFactura.getMesa_Fa();
            Mesa mesa_FaNew = factura.getMesa_Fa();
            FormaDePago formaDePago_FaOld = persistentFactura.getFormaDePago_Fa();
            FormaDePago formaDePago_FaNew = factura.getFormaDePago_Fa();
            if (mesa_FaNew != null) {
                mesa_FaNew = em.getReference(mesa_FaNew.getClass(), mesa_FaNew.getNumeroMesa_Me());
                factura.setMesa_Fa(mesa_FaNew);
            }
            if (formaDePago_FaNew != null) {
                formaDePago_FaNew = em.getReference(formaDePago_FaNew.getClass(), formaDePago_FaNew.getId_FP());
                factura.setFormaDePago_Fa(formaDePago_FaNew);
            }
            factura = em.merge(factura);
            if (mesa_FaOld != null && !mesa_FaOld.equals(mesa_FaNew)) {
                mesa_FaOld.getFactura_Fa().remove(factura);
                mesa_FaOld = em.merge(mesa_FaOld);
            }
            if (mesa_FaNew != null && !mesa_FaNew.equals(mesa_FaOld)) {
                mesa_FaNew.getFactura_Fa().add(factura);
                mesa_FaNew = em.merge(mesa_FaNew);
            }
            if (formaDePago_FaOld != null && !formaDePago_FaOld.equals(formaDePago_FaNew)) {
                formaDePago_FaOld.getFactura_FP().remove(factura);
                formaDePago_FaOld = em.merge(formaDePago_FaOld);
            }
            if (formaDePago_FaNew != null && !formaDePago_FaNew.equals(formaDePago_FaOld)) {
                formaDePago_FaNew.getFactura_FP().add(factura);
                formaDePago_FaNew = em.merge(formaDePago_FaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = factura.getId_Fa();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getId_Fa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            Mesa mesa_Fa = factura.getMesa_Fa();
            if (mesa_Fa != null) {
                mesa_Fa.getFactura_Fa().remove(factura);
                mesa_Fa = em.merge(mesa_Fa);
            }
            FormaDePago formaDePago_Fa = factura.getFormaDePago_Fa();
            if (formaDePago_Fa != null) {
                formaDePago_Fa.getFactura_FP().remove(factura);
                formaDePago_Fa = em.merge(formaDePago_Fa);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
