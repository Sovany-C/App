/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author arthu
 */
public class Poste extends Equipement {
    private Set<Machine> machines;

    // Getters & Setters
    public Set<Machine> getMachines() {
        return machines;
    }

    public void setMachines(Set<Machine> machines) {
        this.machines = machines;
    }

    // Constructeur
    public Poste(String refPoste, String dPoste, Set<Machine> machines) {
        super(refPoste, dPoste);
        this.machines = machines;
    }
    public Poste(String refPoste, String dPoste) {
        super(refPoste, dPoste);
        this.machines = new HashSet<>() ;
    }

    // Méthodes
    public String affiche(){
        Set<String> refMach = new HashSet<>();
        for(Machine m : this.machines){
            refMach.add(m.getRefEquipement());
        }
        return "Ref Poste : " + this.getRefEquipement()+" | Def : "+this.getdEquipement()+" | " + refMach;
    }

    public void addMachine(Machine m){ // Ajoute machine au poste
        this.machines.add(m);
    }
    public void supprMachine(Machine m){ // Supprime machine du poste
        this.machines.remove(m);
    }

    
    public float cout(){ // cout horaire du poste
        float cout = 0;
        for(Machine m : this.machines){
            cout += m.cout();
        }
        return cout;
    }

    public String machineString(){
        return machines.stream()
                   .map(Machine::getRefEquipement)
                   .collect(Collectors.joining(","));
    }

    public String toString(){
        return getRefEquipement();
    }
}
