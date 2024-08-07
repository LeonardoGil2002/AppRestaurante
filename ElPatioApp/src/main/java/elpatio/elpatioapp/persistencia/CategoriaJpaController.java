/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elpatio.elpatioapp.persistencia;

import elpatio.elpatioapp.logica.Categoria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import elpatio.elpatioapp.logica.Menu;
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
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public CategoriaJpaController(){
        emf = Persistence.createEntityManagerFactory("ElPatioAppPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

    ///CLASES CREADAS POR MI
    
    //Traer categoría por nombre
    public Categoria traerCategoriaPorNombre(String nombre){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Categoria c WHERE c.categoria_Ca = :name", Categoria.class)
                .setParameter("name", nombre)
                .getSingleResult();
        } finally {
            em.close();
        }
        
    }
    
    
    
    ///CLASES CREADAS POR EL JPA CONTROLLER
   
    public void create(Categoria categoria) {
        if (categoria.getMen_Ca() == null) {
            categoria.setMen_Ca(new ArrayList<Menu>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Menu> attachedMen_Ca = new ArrayList<Menu>();
            for (Menu men_CaMenuToAttach : categoria.getMen_Ca()) {
                men_CaMenuToAttach = em.getReference(men_CaMenuToAttach.getClass(), men_CaMenuToAttach.getId_Me());
                attachedMen_Ca.add(men_CaMenuToAttach);
            }
            categoria.setMen_Ca(attachedMen_Ca);
            em.persist(categoria);
            for (Menu men_CaMenu : categoria.getMen_Ca()) {
                Categoria oldCat_MeOfMen_CaMenu = men_CaMenu.getCat_Me();
                men_CaMenu.setCat_Me(categoria);
                men_CaMenu = em.merge(men_CaMenu);
                if (oldCat_MeOfMen_CaMenu != null) {
                    oldCat_MeOfMen_CaMenu.getMen_Ca().remove(men_CaMenu);
                    oldCat_MeOfMen_CaMenu = em.merge(oldCat_MeOfMen_CaMenu);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getId_Ca());
            List<Menu> men_CaOld = persistentCategoria.getMen_Ca();
            List<Menu> men_CaNew = categoria.getMen_Ca();
            ArrayList<Menu> attachedMen_CaNew = new ArrayList<Menu>();
            for (Menu men_CaNewMenuToAttach : men_CaNew) {
                men_CaNewMenuToAttach = em.getReference(men_CaNewMenuToAttach.getClass(), men_CaNewMenuToAttach.getId_Me());
                attachedMen_CaNew.add(men_CaNewMenuToAttach);
            }
            men_CaNew = attachedMen_CaNew;
            categoria.setMen_Ca(men_CaNew);
            categoria = em.merge(categoria);
            for (Menu men_CaOldMenu : men_CaOld) {
                if (!men_CaNew.contains(men_CaOldMenu)) {
                    men_CaOldMenu.setCat_Me(null);
                    men_CaOldMenu = em.merge(men_CaOldMenu);
                }
            }
            for (Menu men_CaNewMenu : men_CaNew) {
                if (!men_CaOld.contains(men_CaNewMenu)) {
                    Categoria oldCat_MeOfMen_CaNewMenu = men_CaNewMenu.getCat_Me();
                    men_CaNewMenu.setCat_Me(categoria);
                    men_CaNewMenu = em.merge(men_CaNewMenu);
                    if (oldCat_MeOfMen_CaNewMenu != null && !oldCat_MeOfMen_CaNewMenu.equals(categoria)) {
                        oldCat_MeOfMen_CaNewMenu.getMen_Ca().remove(men_CaNewMenu);
                        oldCat_MeOfMen_CaNewMenu = em.merge(oldCat_MeOfMen_CaNewMenu);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = categoria.getId_Ca();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getId_Ca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<Menu> men_Ca = categoria.getMen_Ca();
            for (Menu men_CaMenu : men_Ca) {
                men_CaMenu.setCat_Me(null);
                men_CaMenu = em.merge(men_CaMenu);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
