package org.openjfx.Model;

import java.util.ArrayList;

public class Machine extends Equipement{

    private String type;
    private float x;
    private float y;
    private float cout;
    private int nbPannes;
    private double rendement;
    private float duree;
    private String etat;
    
    // Getters & Setters
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        if(x < 0 || x>1200){
            throw new IllegalArgumentException("Erreur: valeur Cx <0 ou >1200");
        }
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        if(y < 0 || y>500){
            throw new IllegalArgumentException("Erreur: valeur Cy <0 ou >500");
        }
        this.y = y;
    }
    public float getCout() {
        return cout;
    }
    public void setCout(float cout) {
        if(cout < 0){
            throw new IllegalArgumentException("Erreur: valeur négative");
        }
        this.cout = cout;
    }
       public int getNbPannes() {
        return nbPannes;
    }
    public void setNbPannes(int nbPannes) {
        this.nbPannes = nbPannes;
    }
    public double getRendement() {
        return rendement;
    }
    public void setRendement(double rendement) {
        this.rendement = rendement;
    }
    public float getDuree() {
        return duree;
    }
    public void setDuree(float duree) {
        this.duree = duree;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    // Constructeur
    public Machine(String refMachine, String dMachine, String type, float x,
            float y, float cout) {
        
        super(refMachine, dMachine);
        if(cout < 0){
            throw new IllegalArgumentException("Erreur: valeur négative");
        }
        if(x < 0 || x>1200){
            throw new IllegalArgumentException("Erreur: valeur Cx <0 ou >1200");
        }
        if(y < 0 || y>500){
            throw new IllegalArgumentException("Erreur: valeur Cy <0 ou >500");
        }
        this.type = type;
        this.x = x;
        this.y = y;
        this.cout = cout;
        this.nbPannes = 0;
        this.rendement = 0;
        this.duree = 0;
        this.etat = "D";
        
    }

    // Methodes
    // -----------------------
    public String affiche(){
        return "Ref machine : " + this.getRefEquipement() + " | désignation : " + this.getdEquipement() + " | type : " + this.type + " | coordonnées : "
        + this.x + " , " + this.y + " | cout horaire : " + this.cout;
    }

    public void modifierMachine(String attribut, String mod){
        switch (attribut) {
            case "ref":
                this.setRefEquipement(mod);
                break;
            case "des":
                this.setdEquipement(mod);
                break;
            case "type":
                this.setType(mod);
            default:
                System.out.println("Erreur syntaxe : tapez ref, des ou type");
                break;
        }
    }
    
    public void modifierMachine(String attribut, float mod){
        switch (attribut) {
            case "x":
                this.setX(mod);
                break;
            case "y":
                this.setY(mod);
                break;
            case "cout":
                this.setCout(mod);
            default:
                System.out.println("Erreur syntaxe : tapez x, y ou cout");
                break;
        }
    }
    //----------------------------

    
    public float cout(){
        return this.getCout();
    }

    public String toString(){
        return this.getRefEquipement();
    }
    
    
}
