package elpatio.elpatioapp.persistencia;

import elpatio.elpatioapp.logica.DetalleFactura;
import elpatio.elpatioapp.logica.DetalleFacturaPK;
import elpatio.elpatioapp.persistencia.exceptions.NonexistentEntityException;
import elpatio.elpatioapp.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class DetalleFacturaJpaController implements Serializable {

    public DetalleFacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public DetalleFacturaJpaController(){
        emf = Persistence.createEntityManagerFactory("ElPatioAppPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    ///MÉTODOS CREADOS POR MI
    
        //Trae todos los detalle de factura de una factura específica
        public List<DetalleFactura> traerDetallesDeFactura(int numeroFactura){
            EntityManager em = getEntityManager();
            try {
                // Definir la consulta JPQL con INNER JOIN basado en la relación
                String jpql = "SELECT d FROM DetalleFactura d WHERE d.id_DF.id_Fa_DF = :numeroFactura";

                // Crear la consulta
                TypedQuery<DetalleFactura> query = em.createQuery(jpql, DetalleFactura.class);

                // Establecer el parámetro de la consulta
                query.setParameter("numeroFactura", numeroFactura);

                // Ejecutar la consulta y obtener los resultados
                return query.getResultList();
            } finally {
                // Cerrar el EntityManager
                em.close();
            }
        }
    
    
        //Trae todos los detalle de factura de una mesa ocupada
        public List<DetalleFactura> traerDetalleFacturaMesa(int numeroMesa){
            EntityManager em = getEntityManager();
            try {
                // Definir la consulta JPQL con INNER JOIN basado en la relación
                String jpql = "SELECT d FROM DetalleFactura d JOIN d.factura_DF f JOIN f.mesa_Fa m WHERE m.numeroMesa_Me = :numeroMesa AND f.estado_Fa = 'En proceso'";

                // Crear la consulta
                TypedQuery<DetalleFactura> query = em.createQuery(jpql, DetalleFactura.class);

                // Establecer el parámetro de la consulta
                query.setParameter("numeroMesa", numeroMesa);

                // Ejecutar la consulta y obtener los resultados
                return query.getResultList();
            } finally {
                // Cerrar el EntityManager
                em.close();
            }
        }
        
        //Trae el próximo número de detalleFactura de una factura específica
        public int traerUltimoDetalleFactura(int numeroFactura) {
            EntityManager em = getEntityManager();
            try {
                String jpql = "SELECT MAX(d.id_DF.id_DF) FROM DetalleFactura d WHERE d.factura_DF.id_Fa = :idFa";
                TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
                query.setParameter("idFa", numeroFactura);

                Integer result = query.getSingleResult();

                // Manejo en caso de resultado nulo
                return (result != null) ? result : -1;
            } catch (NoResultException e) {
                return -1; // Manejo de caso cuando no hay resultado
            } finally {
                em.close();
            }
        }
    
    
    ///MÉTODOS CREADOS POR EL JPA CONTROLLER
    
    public void create(DetalleFactura detalleFactura) throws PreexistingEntityException, Exception {
        if (detalleFactura.getId_DF() == null) {
            detalleFactura.setId_DF(new DetalleFacturaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleFactura(detalleFactura.getId_DF()) != null) {
                throw new PreexistingEntityException("DetalleFactura " + detalleFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleFactura detalleFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleFactura = em.merge(detalleFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleFacturaPK id = detalleFactura.getId_DF();
                if (findDetalleFactura(id) == null) {
                    throw new NonexistentEntityException("The detalleFactura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleFacturaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleFactura detalleFactura;
            try {
                detalleFactura = em.getReference(DetalleFactura.class, id);
                detalleFactura.getId_DF();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleFactura> findDetalleFacturaEntities() {
        return findDetalleFacturaEntities(true, -1, -1);
    }

    public List<DetalleFactura> findDetalleFacturaEntities(int maxResults, int firstResult) {
        return findDetalleFacturaEntities(false, maxResults, firstResult);
    }

    private List<DetalleFactura> findDetalleFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleFactura.class));
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

    public DetalleFactura findDetalleFactura(DetalleFacturaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleFactura> rt = cq.from(DetalleFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
