package org.openjfx.Class;

public class Equipement {
    private String refEquipement;
    private String dEquipement;

    // Getters and Setters
    public String getRefEquipement() {
        return refEquipement;
    }
    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }
    public String getdEquipement() {
        return dEquipement;
    }
    public void setdEquipement(String dEquipement) {
        this.dEquipement = dEquipement;
    }
    
    // Constructeur
    public Equipement(String refEquipement, String dEquipement) {
        this.refEquipement = refEquipement;
        this.dEquipement = dEquipement;
    }

    // Méthodes
    public float cout(){
        return 0;
    }
    


}
