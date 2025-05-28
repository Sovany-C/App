package org.openjfx.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class Fiabilite{

    public static void calculfiab( Atelier atelier){
        
        String chemin = "data/" + atelier.getNom() + "/suiviMaintenance.txt";
        
        try (BufferedReader in = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            while ((ligne = in.readLine()) != null) {
                String[] t = ligne.split(";");
                String date = t[0];
                String[] heure = t[1].split(":");
                String ref = t[2]; // machine
                String event = t[3];
                String operateur = t[4];
                String cause = t[5];

                Float duree = Float.parseFloat(heure[0])*60+Float.parseFloat(heure[1]);

                for(Machine m : atelier.getMachine()){
                    if(m.getRefEquipement().equals(ref)){
                        if(event.equals("A") && cause.equals("panne")){
                            m.setNbPannes(m.getNbPannes()+1);
                            m.setDuree(m.getDuree()-duree);
                            m.setEtat("A");
                        }
                        if(event.equals("A") && cause.equals("maintenance")){
                            m.setEtat("Maintenance");
                        }
                        if(event.equals("A") && cause.equals("accident")){
                            m.setNbPannes(m.getNbPannes()+1);
                            m.setEtat("Accident");
                        }
                        if(event.equals("D")){
                            if(m.getEtat().equals("Maintenance")){
                                m.setEtat("D");
                            }
                            if(m.getEtat().equals("A")) {
                                m.setDuree(m.getDuree()+duree);
                                m.setEtat("D");  
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    

    public static void calculerFiabiliteMachines(Atelier atelier) {
        for (Machine m : atelier.getMachine()) {
            // Exemple simple : fiabilité = 1 / (1 + nbPannes)
            double rendement = 1.0 / (1 + m.getNbPannes());
            m.setRendement(rendement);
        }
    }


}

 