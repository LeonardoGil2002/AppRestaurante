
package elpatio.elpatioapp.logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Factura implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Fa;
    
    @Basic
    private float total_Fa;
    private LocalDateTime fecha_Fa;
    
    @ManyToOne
    @JoinColumn(name="numeroMesa_Me")
    private Mesa mesa_Fa;
    
    @ManyToOne
    @JoinColumn(name="id_FP")
    private FormaDePago formaDePago_Fa;
    
    @Basic
    private String estado_Fa;

    public Factura() {
    }

    public Factura(int id_Fa, float total_Fa, LocalDateTime fecha_Fa, Mesa mesa_Fa, FormaDePago formaDePago_Fa, String estado_Fa) {
        this.id_Fa = id_Fa;
        this.total_Fa = total_Fa;
        this.fecha_Fa = fecha_Fa;
        this.mesa_Fa = mesa_Fa;
        this.formaDePago_Fa = formaDePago_Fa;
        this.estado_Fa = estado_Fa;
    }

    public int getId_Fa() {
        return id_Fa;
    }

    public String getEstado_Fa() {
        return estado_Fa;
    }

    public void setEstado_Fa(String estado_Fa) {
        this.estado_Fa = estado_Fa;
    }

    public void setId_Fa(int id_Fa) {
        this.id_Fa = id_Fa;
    }

    public float getTotal_Fa() {
        return total_Fa;
    }

    public void setTotal_Fa(float total_Fa) {
        this.total_Fa = total_Fa;
    }

    public LocalDateTime getFecha_Fa() {
        return fecha_Fa;
    }

    public void setFecha_Fa(LocalDateTime fecha_Fa) {
        this.fecha_Fa = fecha_Fa;
    }

    public Mesa getMesa_Fa() {
        return mesa_Fa;
    }

    public void setMesa_Fa(Mesa mesa_Fa) {
        this.mesa_Fa = mesa_Fa;
    }

    public FormaDePago getFormaDePago_Fa() {
        return formaDePago_Fa;
    }

    public void setFormaDePago_Fa(FormaDePago formaDePago_Fa) {
        this.formaDePago_Fa = formaDePago_Fa;
    }
    
    
    
    
}
