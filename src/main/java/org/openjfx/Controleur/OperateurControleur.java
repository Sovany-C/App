package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.OperateurPane;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OperateurControleur {

    private OperateurPane vue;

    public OperateurControleur(OperateurPane v){
        this.vue = v;
    }

    public void creationOperateur(){
        List<Machine> selection = this.vue.getListMachine().getSelectionModel().getSelectedItems();
        Operateur op = new Operateur(this.vue.getCode().getText(),
                                    this.vue.getNom().getText(),
                                    this.vue.getPrenom().getText(),
                                    new ArrayList<>(selection));
        this.vue.getModel().add(op);
        System.out.println("Operateur: " + this.vue.getCode().getText() + " ajouté à la liste");
        this.vue.getTableOperateurs().refresh();
    }

    public void sauvegarderOperateur(){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/operateurs.txt"));
            for (Operateur p : this.vue.getModel()){
                pw.println(p.getCode()+";"+p.getNom()+";"+p.getPrenom()+";"+p.compString());
            }
            pw.close();
            System.out.println("Operateur ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void modifierOperateur(){
        Operateur selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        if(selected != null){
            if(!this.vue.getCode().getText().trim().isEmpty()){
                selected.setCode(this.vue.getCode().getText().trim());
            }
            if(!this.vue.getNom().getText().trim().isEmpty()){
                selected.setNom(this.vue.getNom().getText().trim());
            }
            if(!this.vue.getPrenom().getText().trim().isEmpty()){
                selected.setPrenom(this.vue.getPrenom().getText().trim());
            }
            if(!this.vue.getListMachine().getSelectionModel().isEmpty()){
                List<Machine> selection = this.vue.getListMachine().getSelectionModel().getSelectedItems();
                selected.setCompetences(new ArrayList<>(selection));
            }
            int index = this.vue.getChoix().getSelectionModel().getSelectedIndex();
            this.vue.getChoix().getItems().set(index, selected);
            System.out.println("Operateur modifié");
            this.vue.getTableOperateurs().refresh();

        }
    }

    public void supprimerOperateur(){
        Operateur selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
    }
}
