package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.PostePane;

import javafx.collections.ObservableList;


import java.util.HashSet;
import java.util.List;

public class PosteControleur {

    private PostePane vue;

    public PosteControleur(PostePane v){
        this.vue = v;
    }

    // Bouton Créer
    public void creationPoste(ObservableList<Poste> choix){
        try{
            this.vue.getAtelier().verifPoste(this.vue.getRef().getText().trim());

            List<Machine> selection = this.vue.getListMachines().getSelectionModel().getSelectedItems();
            for(Machine m: selection){
                if(!this.vue.getAtelier().getMachinelibre().contains(m)){
                    throw new IllegalArgumentException("Erreur: élément déjà utilisé");
                }
            }

            Poste p = new Poste(this.vue.getRef().getText(),
                                this.vue.getDes().getText(),
                                new HashSet<>(selection));

            this.vue.getModel().add(p);
            choix.add(p);
            this.vue.listViewAff(this.vue.getAtelier());
            System.out.println("Equipement: " + this.vue.getRef().getText() + " ajouté à la liste");

            this.vue.getRef().clear();
            this.vue.getDes().clear();
            
            this.vue.getError().setVisible(false);   
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Modifier
    public void modifierPoste(){
        try{
            Poste selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
            if(selected != null){
                if(!this.vue.getRef().getText().trim().isEmpty()){
                    this.vue.getAtelier().verifPoste(this.vue.getRef().getText().trim());

                    selected.setRefEquipement(this.vue.getRef().getText().trim());
                }
                if(!this.vue.getDes().getText().trim().isEmpty()){
                    selected.setdEquipement(this.vue.getDes().getText().trim());
                }
                if(!this.vue.getListMachines().getSelectionModel().isEmpty()){
                    List<Machine> selection = this.vue.getListMachines().getSelectionModel().getSelectedItems();
                    for(Machine m: selection){
                        if(!this.vue.getAtelier().getMachinelibre().contains(m) && !selected.getMachines().contains(selection)){
                            throw new IllegalArgumentException("Erreur: élément déjà utilisé");
                        }
                    }
                    selected.setMachines(new HashSet<>(selection));
                }
            }
            this.vue.listViewAff(this.vue.getAtelier());
            this.vue.getTablePoste().refresh();
            this.vue.getError().setVisible(false);   
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Supprimer
    public void supprimerPoste(ObservableList<Poste> choix){
        Poste selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getAtelier().removePoste(selected);
        choix.remove(selected);
        this.vue.listViewAff(this.vue.getAtelier());
    }

    // Bouton Sauvegarder
    public void sauvegarderPoste(Atelier a){
        Sauvegarde.sauvegarderPoste(this.vue.getAtelier());
    }


}
