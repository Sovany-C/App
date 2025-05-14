/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.Model;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author arthu
 */
public class Gamme {
    private String refGamme;
    private ArrayList<Operation> operations;
    private Set<Equipement> equipements;

    // Getters & Setters
    public String getRefGamme() {
        return refGamme;
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public Set<Equipement> getEquipements() {
        return equipements;
    }

    public void setRefGamme(String refGamme) {
        this.refGamme = refGamme;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public void setEquipements(Set<Equipement> equipements) {
        this.equipements = equipements;
    }

    // Constructeur
    public Gamme(String refGamme, ArrayList<Operation> operations, Set<Equipement> equipements) {
        this.refGamme = refGamme;
        this.operations = operations;
        this.equipements = equipements;
    }
    public Gamme(String refGamme){
        this.refGamme = refGamme;
        this.operations = new ArrayList<Operation>();
        this.equipements = new HashSet<Equipement>();
    }

    // Méthodes
    public String afficherGamme(){
        String liste = "";
        for(Equipement e : this.equipements ){
            liste = liste + e.getRefEquipement();
        }
        return liste;
    }

    public float dureeGamme(){ // Calcul durée total de la gamme
        float dureeTotal = 0;
        for(Operation o : this.operations){
            dureeTotal = dureeTotal + o.getDureeOperation();
        }
        return dureeTotal;
    }

    public float coutGamme(){ // Calcul cout total de cette gamme
        float coutTotal = 0;
        for(Operation o : this.operations){
            for(Equipement e : o.getEquipements()){
                coutTotal += e.cout();
            }
        }
        return coutTotal;
    }

    public void ajoutOp(Operation op){
        this.operations.add(op);
    }
    public void supprOp(Operation op){
        this.operations.remove(op);
    }
    
    public String opString(){
        return operations.stream()
                   .map(Operation::getRefOperation)
                   .collect(Collectors.joining(","));
    }

    public String eqString(){
        return equipements.stream()
                   .map(Equipement::getRefEquipement)
                   .collect(Collectors.joining(","));
    }

    public String toString(){
        return this.getRefGamme();
    }
}
