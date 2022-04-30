
package model;


public class Medi {
    private String NombreMedicamento;
    private String Cantidad;
    private String MedidaCantida;
    private String NumeroPastillas;
    private String PostImageSrc;
    private String Hora;

    public String getNombreMedicamento() {
        return NombreMedicamento;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    

    public void setNombreMedicamento(String NombreMedicamento) {
        this.NombreMedicamento = NombreMedicamento;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getMedidaCantida() {
        return MedidaCantida;
    }

    public void setMedidaCantida(String MedidaCantida) {
        this.MedidaCantida = MedidaCantida;
    }

    public String getNumeroPastillas() {
        return NumeroPastillas;
    }

    public void setNumeroPastillas(String NumeroPastillas) {
        this.NumeroPastillas = NumeroPastillas;
    }

    public String getPostImageSrc() {
        return PostImageSrc;
    }

    public void setPostImageSrc(String PostImageSrc) {
        this.PostImageSrc = PostImageSrc;
    }
    
    
}
