package org.openjfx.Controleur;

import org.openjfx.Pane.PostePane;

import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

import org.openjfx.Class.*;

public class PosteControleur {

    private PostePane vue;

    public PosteControleur(PostePane v){
        this.vue = v;
    }

    public void creationPoste(ObservableList<Poste> choix){
        List<Machine> selection = this.vue.getListMachines().getSelectionModel().getSelectedItems();
        Poste p = new Poste(this.vue.getRef().getText(),
                            this.vue.getDes().getText(),
                            new HashSet<>(selection));
        this.vue.getModel().add(p);
        choix.add(p);
        this.vue.getRef().clear();
        this.vue.getDes().clear();
        System.out.println("Equipement: " + this.vue.getRef().getText() + " ajouté à la liste");
    }

    public void modifierPoste(){
        Poste selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        if(selected != null){
            if(!this.vue.getRef().getText().trim().isEmpty()){
                selected.setRefEquipement(this.vue.getRef().getText().trim());
            }
            if(!this.vue.getDes().getText().trim().isEmpty()){
                selected.setdEquipement(this.vue.getDes().getText().trim());
            }
            if(!this.vue.getListMachines().getSelectionModel().isEmpty()){
                List<Machine> selection = this.vue.getListMachines().getSelectionModel().getSelectedItems();
                selected.setMachines(new HashSet<>(selection));
            }
        }
        this.vue.getTablePoste().refresh();
    }

    public void supprimerPoste(ObservableList<Poste> choix){
        Poste selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
        choix.remove(selected);
    }

    public void sauvegarderPoste(){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("postes.txt"));
            for (Equipement e : this.vue.getModel()){
                if(e instanceof Poste){
                    Poste p = (Poste) e;
                    pw.println(p.getRefEquipement()+";"+p.getdEquipement()+";"+p.machineString());
                }
            }
            pw.close();
            System.out.println("Poste ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
