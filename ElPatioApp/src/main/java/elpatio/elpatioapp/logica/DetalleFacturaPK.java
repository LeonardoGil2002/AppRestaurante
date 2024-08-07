
package elpatio.elpatioapp.logica;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//Con el tag de Embeddable avisamos al JPA que esto es una porción de una entidad (que será la de DetalleFactura)
@Embeddable
public class DetalleFacturaPK {
    
    @Column(name = "id_DF")
    private int id_DF;
    
    @Column(name="id_Fa_DF")
    private int id_Fa_DF;

    public DetalleFacturaPK(int id_DF, int id_Fa_DF) {
        this.id_DF = id_DF;
        this.id_Fa_DF = id_Fa_DF;
    }

    public DetalleFacturaPK() {
    }

    public int getId_DF() {
        return id_DF;
    }

    public void setId_DF(int id_DF) {
        this.id_DF = id_DF;
    }

    public int getId_Fa_DF() {
        return id_Fa_DF;
    }

    public void setId_Fa_DF(int id_Fa_DF) {
        this.id_Fa_DF = id_Fa_DF;
    }
    
    
    
}
