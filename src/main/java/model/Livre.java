package model;

public class Livre {
    private String ref;
    private String title;
    private double prix;
    private int qte;

    public Livre(String ref, String title, double prix, int qte) {
        super();
        this.ref = ref;
        this.title = title;
        this.prix = prix;
        this.qte = qte;
    }
    public Livre() {
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getQte() {
        return qte;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }

}