package elpatio.elpatioapp.logica;


public class FormaDePago {
    
    private int id;
    private String formaDePago;
    private Boolean estado;

    public FormaDePago() {
    }

    public FormaDePago(int id, String formaDePago, Boolean estado) {
        this.id = id;
        this.formaDePago = formaDePago;
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }
    
    
    
}
