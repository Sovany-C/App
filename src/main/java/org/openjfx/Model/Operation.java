/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.Model;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author anato
 */
public class Operation {
    
    private String refOperation;
    private String dOperation;
    private ArrayList<Equipement> equipements;
    private float dureeOperation;

    // Getters & Setters
    public String getRefOperation() {
        return refOperation;
    }

    public void setRefOperation(String refOperation) {
        this.refOperation = refOperation;
    }

    public String getdOperation() {
        return dOperation;
    }

    public void setdOperation(String dOperation) {
        this.dOperation = dOperation;
    }

    public ArrayList<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(ArrayList<Equipement> equipements) {
        this.equipements = equipements;
    }

    public float getDureeOperation() {
        return dureeOperation;
    }

    public void setDureeOperation(float dureeOperation) {
        this.dureeOperation = dureeOperation;
    }

    // Constructeur
    public Operation(String refOperation, String dOperation, ArrayList<Equipement> equipements, float dureeOperation) {
        if(dureeOperation<0){
            throw new IllegalArgumentException();
        }
        this.refOperation = refOperation;
        this.dOperation = dOperation;
        this.equipements = equipements;
        this.dureeOperation = dureeOperation;
    }

    public String equipementString(){
        return this.equipements.stream()
                   .map(Equipement::getRefEquipement)
                   .collect(Collectors.joining(","));
    }
    
    public String toString(){
        return getRefOperation();
    }
    
}
