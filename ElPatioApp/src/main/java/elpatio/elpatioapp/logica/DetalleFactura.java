
package elpatio.elpatioapp.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DetalleFactura implements Serializable {
    
    @EmbeddedId
    private DetalleFacturaPK id_DF;
    
    @Basic
    private int cantidad_DF;
    
    @ManyToOne
    @JoinColumn(name="id_Me")
    private Menu menu_DF;
    
    //Hacemos la relación. Debemos poner el MapsId para 
    @ManyToOne
    @JoinColumn(name="id_Fa")
    @MapsId("id_Fa_DF")
    private Factura factura_DF;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK id_DF, int cantidad_DF, Menu menu_DF, Factura factura_DF) {
        this.id_DF = id_DF;
        this.cantidad_DF = cantidad_DF;
        this.menu_DF = menu_DF;
        this.factura_DF = factura_DF;
    }

    public DetalleFacturaPK getId_DF() {
        return id_DF;
    }

    public void setId_DF(DetalleFacturaPK id_DF) {
        this.id_DF = id_DF;
    }

    public int getCantidad_DF() {
        return cantidad_DF;
    }

    public void setCantidad_DF(int cantidad_DF) {
        this.cantidad_DF = cantidad_DF;
    }

    public Menu getMenu_DF() {
        return menu_DF;
    }

    public void setMenu_DF(Menu menu_DF) {
        this.menu_DF = menu_DF;
    }

    public Factura getFactura_DF() {
        return factura_DF;
    }

    public void setFactura_DF(Factura factura_DF) {
        this.factura_DF = factura_DF;
    }
    
    
    
    
    
}
