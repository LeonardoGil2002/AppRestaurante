
package elpatio.elpatioapp.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_Ca;
    
    @Basic
    private String categoria_Ca;
    private Boolean estado_Ca;
    
    @OneToMany(mappedBy="cat_Me")
    private List<Menu> men_Ca;

    public Categoria(){
        
    }

    public Categoria(int id_Ca, String categoria_Ca, Boolean estado_Ca, List<Menu> men_Ca) {
        this.id_Ca = id_Ca;
        this.categoria_Ca = categoria_Ca;
        this.estado_Ca = estado_Ca;
        this.men_Ca = men_Ca;
    }

    public List<Menu> getMen_Ca() {
        return men_Ca;
    }

    public void setMen_Ca(List<Menu> men_Ca) {
        this.men_Ca = men_Ca;
    }

    public int getId_Ca() {
        return id_Ca;
    }

    public void setId_Ca(int id_Ca) {
        this.id_Ca = id_Ca;
    }

    public String getCategoria_Ca() {
        return categoria_Ca;
    }

    public void setCategoria_Ca(String categoria_Ca) {
        this.categoria_Ca = categoria_Ca;
    }

    public Boolean getEstado_Ca() {
        return estado_Ca;
    }

    public void setEstado_Ca(Boolean estado_Ca) {
        this.estado_Ca = estado_Ca;
    }
    
    
    
}
