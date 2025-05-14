package org.openjfx.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Utilitaire {
    
    public static ObservableList<Machine> getMachines(ObservableList<Equipement> equipements){
        ObservableList<Machine> machines = FXCollections.observableArrayList();
        for(Equipement e : equipements){
            if(e instanceof Machine){
                Machine m = (Machine) e;
                machines.add(m);
            }
        }
        return machines;
    }

    public static ObservableList<Poste> getPostes(ObservableList<Equipement> equipements){
        ObservableList<Poste> postes = FXCollections.observableArrayList();
        for(Equipement e : equipements){
            if(e instanceof Poste){
                Poste m = (Poste) e;
                postes.add(m);
            }
        }
        return postes;
    }

}
