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

    public void initialisation(){
        Lecture.lectureMachine(this);
        Lecture.lecturePoste(this);
        Lecture.lectureOperation(this);
        Lecture.lectureGamme(this);
        Lecture.lectureProduit(this);
        Lecture.lectureOperateur(this);
    }
    

    
}
