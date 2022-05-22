
package model;


public class News {
    
    private String nameTitular;
    private String link;
    private byte[] imgSrc;
     

    public byte[] getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(byte[] imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getNameTitular() {
        return nameTitular;
    }

    public void setNameTitular(String nameTitular) {
        this.nameTitular = nameTitular;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    
}
