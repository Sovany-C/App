package org.openjfx.Model;

public class Machine extends Equipement{

    private String type;
    private float x;
    private float y;
    private float cout;

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
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getCout() {
        return cout;
    }
    public void setCout(float cout) {
        this.cout = cout;
    }

    
    public Machine(String refMachine, String dMachine, String type, float x,
            float y, float cout) {
        
        super(refMachine, dMachine);
        if(cout < 0){
            throw new IllegalArgumentException("Erreur: valeur négative");
        }
        this.type = type;
        this.x = x;
        this.y = y;
        this.cout = cout;
    }

    // Methodes
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

    public float cout(){
        return this.getCout();
    }

    public String toString(){
        return this.getRefEquipement();
    }
    
    
}
