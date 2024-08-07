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
public class FormaDePago implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_FP;
    
    @Basic
    private String formaDePago_FP;
    private Boolean estado_FP;
    
    @OneToMany(mappedBy="formaDePago_Fa")
    private List<Factura> factura_FP;

    public FormaDePago() {
    }

    public FormaDePago(int id_FP, String formaDePago_FP, Boolean estado_FP, List<Factura> factura_FP) {
        this.id_FP = id_FP;
        this.formaDePago_FP = formaDePago_FP;
        this.estado_FP = estado_FP;
        this.factura_FP = factura_FP;
    }

    public int getId_FP() {
        return id_FP;
    }

    public void setId_FP(int id_FP) {
        this.id_FP = id_FP;
    }

    public String getFormaDePago_FP() {
        return formaDePago_FP;
    }

    public void setFormaDePago_FP(String formaDePago_FP) {
        this.formaDePago_FP = formaDePago_FP;
    }

    public Boolean getEstado_FP() {
        return estado_FP;
    }

    public void setEstado_FP(Boolean estado_FP) {
        this.estado_FP = estado_FP;
    }

    public List<Factura> getFactura_FP() {
        return factura_FP;
    }

    public void setFactura_FP(List<Factura> factura_FP) {
        this.factura_FP = factura_FP;
    }

    
    
    
    
    
}
