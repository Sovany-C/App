package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.GammePane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GammeControleur {

    private GammePane vue;

    public GammeControleur(GammePane v){
        this.vue = v;
    }

    public void creationGamme(){
        try{
            this.vue.getA().verifGamme(this.vue.getRef().getText().trim());
            List<Operation> selection = this.vue.getListOperation().getSelectionModel().getSelectedItems();
            List<Equipement> equipements = new ArrayList<>();
            for(Operation o : selection){
                equipements.addAll(o.getEquipements());
            }
            Gamme g = new Gamme(this.vue.getRef().getText(),
                                new ArrayList<>(selection),
                                new HashSet<>(equipements));
            this.vue.getModel().add(g);
            this.vue.getRef().clear();
            System.out.println("Gamme: " + this.vue.getRef().getText() + " ajouté à la liste");
            this.vue.getError().setVisible(false);    
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    public void modifierGamme(){
        try{
            Gamme selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
            if(selected != null){
                if(!this.vue.getRef().getText().trim().isEmpty()){
                    this.vue.getA().verifGamme(this.vue.getRef().getText().trim());
                    selected.setRefGamme(this.vue.getRef().getText().trim());
                }
                if(!this.vue.getListOperation().getSelectionModel().isEmpty()){
                    List<Operation> selection = this.vue.getListOperation().getSelectionModel().getSelectedItems();
                    List<Equipement> equipements = new ArrayList<>();
                    for(Operation o : selection){
                    equipements.addAll(o.getEquipements());
                    }
                    selected.setOperations(new ArrayList<>(selection));
                    selected.setEquipements(new HashSet<>(equipements));
                }
            }
            this.vue.getTableGammes().refresh(); 
            this.vue.getError().setVisible(false);  
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }

        
    }

    public void supprimerGamme(){
        Gamme selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
    }

    public void sauvegarderGamme(){
        Sauvegarde.sauvegarderGamme(this.vue.getA());
    }


}
