package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.MachinePane;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class MachineControleur {

    private MachinePane vue;

    public MachineControleur(MachinePane v){
        this.vue = v;
    }

    public void creationMachine(ObservableList<Machine> choix){
        TextField[] attributs = {this.vue.getRef(), this.vue.getDes(), this.vue.getType(), this.vue.getCx_val(), this.vue.getCy_val(), this.vue.getCout_val()};
        Machine m = new Machine(attributs[0].getText().trim(),
                                attributs[1].getText(),
                                attributs[2].getText(),
                                Float.parseFloat(attributs[3].getText()),
                                Float.parseFloat(attributs[4].getText()),
                                Float.parseFloat(attributs[5].getText()));
        this.vue.getModel().add(m);
        choix.add(m);
        for(int i=0; i<6; i++){
            attributs[i].clear();
        }
        System.out.println("Equipement: " + this.vue.getRef().getText() + " ajouté à la liste");
        this.vue.getTableMachines().refresh();
    }

    public void sauvegarderMach(){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("../../src/main/java/org/openjfx/Fichier/machines.txt"));
            for (Equipement e : this.vue.getModel())
                if(e instanceof Machine){
                    Machine m = (Machine) e;
                    pw.println(m.getRefEquipement()+";"+m.getdEquipement()+";"+m.getType()+";"+m.getX()+";"+m.getY()+";"+m.getCout());
                }
            pw.close();
            System.out.println("Machine ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void modifierMachine(){
        Machine selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        if(selected != null){
            TextField[] attributs = {this.vue.getRef(), this.vue.getDes(), this.vue.getType(), this.vue.getCx_val(), this.vue.getCy_val(), this.vue.getCout_val()};
            
            for(int i=0; i<6;i++){
                if(!attributs[i].getText().trim().isEmpty()){
                    switch (i) {
                        case 0:
                            selected.setRefEquipement(attributs[0].getText().trim());
                            break;
                        case 1:
                            selected.setdEquipement(attributs[1].getText().trim());
                            break;
                        case 2:
                            selected.setType(attributs[2].getText().trim());
                            break;
                        case 3:
                            selected.setX(Float.parseFloat(attributs[3].getText().trim()));
                            break;
                        case 4:
                            selected.setY(Float.parseFloat(attributs[4].getText().trim()));
                            break;
                        case 5:
                            selected.setCout(Float.parseFloat(attributs[5].getText().trim()));
                        default:
                            break;
                    }
                }
            }
            int index = this.vue.getChoix().getSelectionModel().getSelectedIndex();
            this.vue.getChoix().getItems().set(index, selected);
            for(int i=0; i<6; i++){
                attributs[i].clear();
            }
            System.out.println("Machine modifié");
            this.vue.getTableMachines().refresh();

        }
    }

    public void supprimerMach(ObservableList<Machine> choix){
        Machine selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
        choix.remove(selected);
    }
}
