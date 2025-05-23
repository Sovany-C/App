package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.OperationPane;



import java.util.ArrayList;
import java.util.List;

public class OperationControleur {

    private OperationPane vue;

    public OperationControleur(OperationPane v){
        this.vue = v;
    }

    public void creationOperation(){
        try{
            this.vue.getA().verifOperation(this.vue.getRef().getText().trim());
            List<Equipement> selection = this.vue.getListEquip().getSelectionModel().getSelectedItems();
            Operation op = new Operation(this.vue.getRef().getText().trim(),
                                this.vue.getDes().getText().trim(),
                                new ArrayList<>(selection),
                                Float.parseFloat(this.vue.getDuree_value().getText().trim()));
            this.vue.getModel().add(op);
            System.out.println("Operation: " + this.vue.getRef().getText() + " ajouté à la liste");
            this.vue.getRef().clear();
            this.vue.getDes().clear();
            this.vue.getDuree_value().clear();   
            this.vue.getError().setVisible(false);
        }
        catch(NumberFormatException e){
            this.vue.getError().setText("Erreur: valeur saisie incorrecte");
            this.vue.getError().setVisible(true);
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText("Erreur: information manquante ou incorrecte");
            this.vue.getError().setVisible(true);
        }
        
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
        Sauvegarde.sauvegarderOperation(this.vue.getA());
    }


}
