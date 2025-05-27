package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.MachinePane;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;


public class MachineControleur {

    private MachinePane vue;

    public MachineControleur(MachinePane v){
        this.vue = v;
    }

    // Bouton Créer
    public void creationMachine(ObservableList<Machine> choix) throws NumberFormatException{

        try{
            this.vue.getAtelier().verifMachine(this.vue.getRef().getText().trim());

            TextField[] attributs = {this.vue.getRef(), this.vue.getDes(), this.vue.getType(), this.vue.getCx_val(), this.vue.getCy_val(), this.vue.getCout_val()};
            Float[] val = new Float[3];
            for(int i=3; i<6;i++){
                if(attributs[i].getText().trim().isEmpty()){
                    val[i-3] = (float) 0;
                }
                else{
                    val[i-3] = Float.parseFloat(attributs[i].getText().trim());
                }
            }
            Machine m = new Machine(attributs[0].getText().trim(),
                                    attributs[1].getText(),
                                    attributs[2].getText(),
                                    val[0],
                                    val[1],
                                    val[2]);

            this.vue.getModel().add(m);
            choix.add(m);

            System.out.println("Equipement: " + this.vue.getRef().getText() + " ajouté à la liste");
            for(int i=0; i<6; i++){
                attributs[i].clear();
            }

            this.vue.getTableMachines().refresh();
            this.vue.getError().setVisible(false);
        }
        catch(NumberFormatException e){
            this.vue.getError().setText("Erreur: écriture valeur incorrecte");
            this.vue.getError().setVisible(true);
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Sauvegarder
    public void sauvegarderMach(){
        Sauvegarde.sauvegarderMachine(this.vue.getAtelier());
    }

    // Bouton Modifier
    public void modifierMachine(){
        try{
            Machine selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
            if(selected != null){
                TextField[] attributs = {this.vue.getRef(), this.vue.getDes(), this.vue.getType(), this.vue.getCx_val(), this.vue.getCy_val(), this.vue.getCout_val()};
                
                for(int i=0; i<6;i++){
                    if(!attributs[i].getText().trim().isEmpty()){
                        switch (i) {
                            case 0:
                                this.vue.getAtelier().verifMachine(this.vue.getRef().getText().trim());
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
                this.vue.getError().setVisible(false);
            }    
        }
        catch(NumberFormatException e){
            this.vue.getError().setText("Erreur: écriture valeur incorrecte");
            this.vue.getError().setVisible(true);
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }

        
    }

    // Bouton Supprimer
    public void supprimerMach(ObservableList<Machine> choix){
        Machine selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
        choix.remove(selected);
    }
}
