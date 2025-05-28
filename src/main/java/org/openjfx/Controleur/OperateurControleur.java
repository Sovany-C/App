package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.OperateurPane;


import java.util.ArrayList;
import java.util.List;

public class OperateurControleur {

    private OperateurPane vue;

    public OperateurControleur(OperateurPane v){
        this.vue = v;
    }

    // Bouton Créer
    public void creationOperateur(){
        try{
            this.vue.getA().verifOperateur(this.vue.getCode().getText().trim());

            List<Machine> selection = this.vue.getListMachine().getSelectionModel().getSelectedItems();
            Operateur op = new Operateur(this.vue.getCode().getText(),
                                        this.vue.getNom().getText(),
                                        this.vue.getPrenom().getText(),
                                        new ArrayList<>(selection));

            this.vue.getModel().add(op);
            System.out.println("Operateur: " + this.vue.getCode().getText() + " ajouté à la liste");

            this.vue.getCode().clear();
            this.vue.getNom().clear();
            this.vue.getPrenom().clear();
            this.vue.getTableOperateurs().refresh();
            this.vue.getError().setVisible(false);
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Sauvegarder
    public void sauvegarderOperateur(){
        Sauvegarde.sauvegarderOperateur(this.vue.getA());
    }

    // Bouton Modifier
    public void modifierOperateur(){
        try{
            Operateur selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
                    if(selected != null){
                        if(!this.vue.getCode().getText().trim().isEmpty()){
                            this.vue.getA().verifOperateur(this.vue.getCode().getText().trim());

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
                        this.vue.getError().setVisible(false);
                    }
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Supprimer
    public void supprimerOperateur(){
        Operateur selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getA().removeOperateur(selected);
    }
}
