/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.Model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author arthu
 */
public class Atelier {
    private String nom;
    private ObservableList<Equipement> equipements;
    private ObservableList<Produit> produits;
    private ObservableList<Gamme> gammes;
    private ObservableList<Operation> operations;
    private ObservableList<Operateur> operateurs;

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ObservableList<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(ObservableList<Equipement> equipements) {
        this.equipements = equipements;
    }
    
    public ObservableList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ObservableList<Produit> produits) {
        this.produits = produits;
    }
    
    public ObservableList<Gamme> getGammes() {
        return gammes;
    }

    public void setGammes(ObservableList<Gamme> gammes) {
        this.gammes = gammes;
    }

    public ObservableList<Operation> getOperations() {
        return operations;
    }

    public void setOperations(ObservableList<Operation> operations) {
        this.operations = operations;
    }

    public ObservableList<Operateur> getOperateurs() {
        return operateurs;
    }

    public void setOperateurs(ObservableList<Operateur> operateurs) {
        this.operateurs = operateurs;
    }

    // Constructeur
    public Atelier(String nom) {
        this.nom = nom;
        this.equipements = FXCollections.observableArrayList();
        this.produits = FXCollections.observableArrayList();
        this.gammes = FXCollections.observableArrayList();
        this.operateurs = FXCollections.observableArrayList();
        this.operations = FXCollections.observableArrayList();
    }
    

    public String affiche(){
        ArrayList<String> refEq = new ArrayList<>();
        for(Equipement e: this.equipements){
            refEq.add(e.getRefEquipement());
        }
        return "Nom : " + this.nom + " | Equipement: " + refEq;
    }

    public ObservableList<Machine> getMachine(){
        ObservableList<Machine> machines = FXCollections.observableArrayList();
        for(Equipement e : this.getEquipements()){
            if(e instanceof Machine){
                Machine m = (Machine) e;
                machines.add(m);
            }
        }
        return machines;
    }

    public ObservableList<Machine> getMachinelibre(){
        ObservableList<Machine> uniquemachines = FXCollections.observableArrayList();
        boolean check;
        for(Machine m : this.getMachine()){
            check = false;
            for(Poste p : this.getPostes()){
                for(Machine pMach : p.getMachines()){
                    if(pMach.getRefEquipement().equals(m.getRefEquipement())){
                        check = true;
                        break;
                    }
                }
            }
            if(!check){
                uniquemachines.add(m);
            }
        }
        
        return uniquemachines;
    }

    public ObservableList<Gamme> getGammelibre(){
        ObservableList<Gamme> uniqueGammes = FXCollections.observableArrayList();
        boolean check;
        for(Gamme g : this.getGammes()){
            check = false;
            for(Produit p : this.getProduits()){
                for(Gamme pGamme : p.getGammes()){
                    if(pGamme.getRefGamme().equals(g.getRefGamme())){
                        check = true;
                        break;
                    }
                }
            }
            if(!check){
                uniqueGammes.add(g);
            }
        }
        
        return uniqueGammes;
    }


    public ObservableList<Poste> getPostes(){
        ObservableList<Poste> postes = FXCollections.observableArrayList();
        for(Equipement e : this.getEquipements()){
            if(e instanceof Poste){
                Poste m = (Poste) e;
                postes.add(m);
            }
        }
        return postes;
    }

    public void initialisation(){
        Lecture.lectureMachine(this);
        Lecture.lecturePoste(this);
        Lecture.lectureOperation(this);
        Lecture.lectureGamme(this);
        Lecture.lectureProduit(this);
        Lecture.lectureOperateur(this);
    }

    public void verifMachine(String ref){
        if(ref==null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("Erreur: référence null");
        }
        for(Machine m : getMachine()){
            if(m.getRefEquipement().equals(ref)){
                throw new IllegalArgumentException("Erreur: référence existante");
            }
        }
    }
    public void verifGamme(String ref){
        if(ref==null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("Erreur: référence null");
        }
        for(Gamme m : this.gammes){
            if(m.getRefGamme().equals(ref)){
                throw new IllegalArgumentException("Erreur: référence existante");
            }
        }
    }
    public void verifOperateur(String ref){
        if(ref==null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("Erreur: référence null");
        }
        for(Operateur m : this.operateurs){
            if(m.getCode().equals(ref)){
                throw new IllegalArgumentException("Erreur: référence existante");
            }
        }
    }
    public void verifOperation(String ref){
        if(ref==null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("Erreur: référence null");
        }
        for(Operation m: this.operations){
            if(m.getRefOperation().equals(ref)){
                throw new IllegalArgumentException("Erreur: référence existante");
            }
        }
    }
    public void verifPoste(String ref){
        if(ref==null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("Erreur: référence null");
        }
        for(Poste m : this.getPostes()){
            if(m.getRefEquipement().equals(ref)){
                throw new IllegalArgumentException("Erreur: référence existante");
            }
        }
    }
    public void verifProduit(String ref){
        if(ref==null || ref.trim().isEmpty()){
            throw new IllegalArgumentException("Erreur: référence null");
        }
        for(Produit m : this.produits){
            if(m.getCodeProduit().equals(ref)){
                throw new IllegalArgumentException("Erreur: référence existante");
            }
        }
    }

    
}
