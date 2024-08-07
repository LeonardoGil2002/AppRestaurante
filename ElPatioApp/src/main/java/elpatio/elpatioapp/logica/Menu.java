package elpatio.elpatioapp.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_Me;
    
    @Basic
    private String nombre_Me;
    private float precio_Me;
    private Boolean estado_Me;
    
    @ManyToOne
    @JoinColumn(name="id_Ca")
    private Categoria cat_Me;
    
    @OneToMany(mappedBy="menu_DF")
    private List<DetalleFactura> detalleFactura_Me;

    public Menu(int id_Me, String nombre_Me, float precio_Me, Boolean estado_Me, Categoria cat_Me, List<DetalleFactura> detalleFactura_Me) {
        this.id_Me = id_Me;
        this.nombre_Me = nombre_Me;
        this.precio_Me = precio_Me;
        this.estado_Me = estado_Me;
        this.cat_Me = cat_Me;
        this.detalleFactura_Me = detalleFactura_Me;
    }

    
    
    public Menu() {
    }

    public int getId_Me() {
        return id_Me;
    }

    public List<DetalleFactura> getDetalleFactura_Me() {
        return detalleFactura_Me;
    }

    public void setDetalleFactura_Me(List<DetalleFactura> detalleFactura_Me) {
        this.detalleFactura_Me = detalleFactura_Me;
    }

    public void setId_Me(int id_Me) {
        this.id_Me = id_Me;
    }

    public String getNombre_Me() {
        return nombre_Me;
    }

    public void setNombre_Me(String nombre_Me) {
        this.nombre_Me = nombre_Me;
    }

    public float getPrecio_Me() {
        return precio_Me;
    }

    public void setPrecio_Me(float precio_Me) {
        this.precio_Me = precio_Me;
    }

    public Boolean getEstado_Me() {
        return estado_Me;
    }

    public void setEstado_Me(Boolean estado_Me) {
        this.estado_Me = estado_Me;
    }

    public Categoria getCat_Me() {
        return cat_Me;
    }

    public void setCat_Me(Categoria cat_Me) {
        this.cat_Me = cat_Me;
    }
    
    
}
