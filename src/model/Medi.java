
package model;


public class Medi {
    
    private int idMedi;
    private String idUserMedi;
    private String NombreMedicamento;
    private String FormaMedi;
    private String Cantidad;
    private String MedidaCantida;
    private String NumeroPastillas;
    private String PostImageSrc;
    private String Hora;
    private String VencimientoMedi;

    public Medi(String idUserMedi, String NombreMedicamento, String FormaMedi, String Cantidad, String MedidaCantida, String NumeroPastillas, String PostImageSrc, String Hora, String VencimientoMedi) {
        this.idUserMedi = idUserMedi;
        this.NombreMedicamento = NombreMedicamento;
        this.FormaMedi = FormaMedi;
        this.Cantidad = Cantidad;
        this.MedidaCantida = MedidaCantida;
        this.NumeroPastillas = NumeroPastillas;
        this.PostImageSrc = PostImageSrc;
        this.Hora = Hora;
        this.VencimientoMedi = VencimientoMedi;
    }
 
    public Medi(){
    
    }

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
    
     public String getFormaMedi() {
        return FormaMedi;
    }

    public void setFormaMedi(String FormaMedi) {
        this.FormaMedi = FormaMedi;
    }

    public String getIdUserMedi() {
        return idUserMedi;
    }

    public void setIdUserMedi(String idUserMedi) {
        this.idUserMedi = idUserMedi;
    }

    public String getVencimientoMedi() {
        return VencimientoMedi;
    }

    public void setVencimientoMedi(String VencimientoMedi) {
        this.VencimientoMedi = VencimientoMedi;
    }

    public int getIdMedi() {
        return idMedi;
    }

    public void setIdMedi(int idMedi) {
        this.idMedi = idMedi;
    }
    
    
}
