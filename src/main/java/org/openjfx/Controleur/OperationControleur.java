package org.openjfx.Controleur;

import org.openjfx.Pane.OperationPane;

import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openjfx.Class.*;

public class OperationControleur {

    private OperationPane vue;

    public OperationControleur(OperationPane v){
        this.vue = v;
    }

    public void creationOperation(){
        List<Equipement> selection = this.vue.getListEquip().getSelectionModel().getSelectedItems();
        Operation op = new Operation(this.vue.getRef().getText().trim(),
                            this.vue.getDes().getText().trim(),
                            new ArrayList<>(selection),
                            Float.parseFloat(this.vue.getDuree_value().getText().trim()));
        this.vue.getModel().add(op);
        this.vue.getRef().clear();
        this.vue.getDes().clear();
        this.vue.getDuree_value().clear();
        System.out.println("Equipement: " + this.vue.getRef().getText() + " ajouté à la liste");
    }

    public void modifierOperation(){
        Operation selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        if(selected != null){
            if(!this.vue.getRef().getText().trim().isEmpty()){
                selected.setRefOperation(this.vue.getRef().getText().trim());
            }
            if(!this.vue.getDes().getText().trim().isEmpty()){
                selected.setdOperation(this.vue.getDes().getText().trim());
            }
            if(!this.vue.getDuree_value().getText().trim().isEmpty()){
                selected.setDureeOperation(Float.parseFloat(this.vue.getDuree_value().getText().trim()));
            }
            if(!this.vue.getListEquip().getSelectionModel().isEmpty()){
                List<Equipement> selection = this.vue.getListEquip().getSelectionModel().getSelectedItems();
                selected.setEquipements(new ArrayList<>(selection));
            }
        }
        this.vue.getTableOperations().refresh();
    }

    public void supprimerOperation(){
        Operation selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
    }

    public void sauvegarderOperation(){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("Operations.txt"));
            for (Operation op : this.vue.getModel()){
                pw.println(op.getRefOperation()+";"+op.getdOperation()+";"+op.equipementString()+";"+op.getDureeOperation());
            }
            pw.close();
            System.out.println("Operation ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
