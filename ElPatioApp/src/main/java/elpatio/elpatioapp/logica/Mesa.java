
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
public class Mesa implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int numeroMesa_Me;
    
    @Basic
    private String estado_Me;
    
    @OneToMany(mappedBy="mesa_Fa")
    private List<Factura> factura_Fa;

    public Mesa(int numeroMesa_Me, String estado_Me) {
        this.numeroMesa_Me = numeroMesa_Me;
        this.estado_Me = estado_Me;
    }

    public Mesa(int numeroMesa_Me, String estado_Me, List<Factura> factura_Fa) {
        this.numeroMesa_Me = numeroMesa_Me;
        this.estado_Me = estado_Me;
        this.factura_Fa = factura_Fa;
    }
    
    public Mesa() {
    }

    public int getNumeroMesa_Me() {
        return numeroMesa_Me;
    }

    public void setNumeroMesa_Me(int numeroMesa_Me) {
        this.numeroMesa_Me = numeroMesa_Me;
    }

    public String getEstado_Me() {
        return estado_Me;
    }

    public void setEstado_Me(String estado_Me) {
        this.estado_Me = estado_Me;
    }

    public List<Factura> getFactura_Fa() {
        return factura_Fa;
    }

    public void setFactura_Fa(List<Factura> factura_Fa) {
        this.factura_Fa = factura_Fa;
    }
    
    
    
}
