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
import elpatio.elpatioapp.logica.Categoria;
import elpatio.elpatioapp.logica.Menu;
import elpatio.elpatioapp.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leo
 */
public class MenuJpaController implements Serializable {

    public MenuJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public MenuJpaController(){
        emf = Persistence.createEntityManagerFactory("ElPatioAppPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    ///CLASES CREADAS POR MI
    
    //Traer categoría por nombre
    public Menu traerUnMenuSegunNombre(String nombre){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT m FROM Menu m WHERE m.nombre_Me = :name", Menu.class)
                .setParameter("name", nombre)
                .getSingleResult();
        } finally {
            em.close();
        }
        
    }
    
    
    
    ///CLASES CREADAS POR EL JPA CONTROLLER    
    
    public void create(Menu menu) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria cat_Me = menu.getCat_Me();
            if (cat_Me != null) {
                cat_Me = em.getReference(cat_Me.getClass(), cat_Me.getId_Ca());
                menu.setCat_Me(cat_Me);
            }
            em.persist(menu);
            if (cat_Me != null) {
                cat_Me.getMen_Ca().add(menu);
                cat_Me = em.merge(cat_Me);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menu menu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menu persistentMenu = em.find(Menu.class, menu.getId_Me());
            Categoria cat_MeOld = persistentMenu.getCat_Me();
            Categoria cat_MeNew = menu.getCat_Me();
            if (cat_MeNew != null) {
                cat_MeNew = em.getReference(cat_MeNew.getClass(), cat_MeNew.getId_Ca());
                menu.setCat_Me(cat_MeNew);
            }
            menu = em.merge(menu);
            if (cat_MeOld != null && !cat_MeOld.equals(cat_MeNew)) {
                cat_MeOld.getMen_Ca().remove(menu);
                cat_MeOld = em.merge(cat_MeOld);
            }
            if (cat_MeNew != null && !cat_MeNew.equals(cat_MeOld)) {
                cat_MeNew.getMen_Ca().add(menu);
                cat_MeNew = em.merge(cat_MeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = menu.getId_Me();
                if (findMenu(id) == null) {
                    throw new NonexistentEntityException("The menu with id " + id + " no longer exists.");
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
            Menu menu;
            try {
                menu = em.getReference(Menu.class, id);
                menu.getId_Me();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menu with id " + id + " no longer exists.", enfe);
            }
            Categoria cat_Me = menu.getCat_Me();
            if (cat_Me != null) {
                cat_Me.getMen_Ca().remove(menu);
                cat_Me = em.merge(cat_Me);
            }
            em.remove(menu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menu> findMenuEntities() {
        return findMenuEntities(true, -1, -1);
    }

    public List<Menu> findMenuEntities(int maxResults, int firstResult) {
        return findMenuEntities(false, maxResults, firstResult);
    }

    private List<Menu> findMenuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menu.class));
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

    public Menu findMenu(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menu.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menu> rt = cq.from(Menu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
