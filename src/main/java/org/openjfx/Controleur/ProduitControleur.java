package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.ProduitPane;

import java.util.ArrayList;
import java.util.List;

public class ProduitControleur {

    private ProduitPane vue;

    public ProduitControleur(ProduitPane v){
        this.vue = v;
    }

    // Bouton Créer
    public void creationProduit(){
        try{
            this.vue.getA().verifProduit(this.vue.getCode().getText().trim());

            List<Gamme> selection = this.vue.getListGamme().getSelectionModel().getSelectedItems();
            for(Gamme g : selection){
                if(!this.vue.getA().getGammelibre().contains(g)){
                    throw new IllegalArgumentException("Erreur: Gamme déjà utilisé");
                }
            }
            Produit m = new Produit(this.vue.getCode().getText().trim(), this.vue.getDes().getText().trim(), new ArrayList<>(selection));
            
            this.vue.getModel().add(m);
            System.out.println("Produit: " + this.vue.getCode().getText() + " ajouté à la liste");
            this.vue.listViewAff(this.vue.getA());

            this.vue.getCode().clear();
            this.vue.getDes().clear();
            this.vue.getTableProduits().refresh();
            this.vue.getError().setVisible(false);    

        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Sauvegarder
    public void sauvegarderProduit(){
        Sauvegarde.sauvegarderProduit(this.vue.getA());
    }

    // Bouton Modifier
    public void modifierProduit(){
        try{
            Produit selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
            if(selected != null){
                if(!this.vue.getCode().getText().trim().isEmpty()){
                    selected.setCodeProduit(this.vue.getCode().getText().trim());

                    this.vue.getA().verifProduit(this.vue.getCode().getText().trim());
                }
                if(!this.vue.getDes().getText().trim().isEmpty()){
                    selected.setCodeProduit(this.vue.getDes().getText().trim());
                }
                if(!this.vue.getListGamme().getSelectionModel().isEmpty()){
                    List<Gamme> selection = this.vue.getListGamme().getSelectionModel().getSelectedItems();
                    for(Gamme g : selection){
                    if(!this.vue.getA().getGammelibre().contains(g) && !selected.getGammes().contains(g)){
                        throw new IllegalArgumentException("Erreur: Gamme déjà utilisé");
                        }
                    }
                    selected.setGammes(new ArrayList<>(selection));
                }
                int index = this.vue.getChoix().getSelectionModel().getSelectedIndex();
                this.vue.getChoix().getItems().set(index, selected);
                this.vue.getTableProduits().refresh();
                this.vue.listViewAff(this.vue.getA());

            } 
        }
        catch(IllegalArgumentException e){
            this.vue.getError().setText(e.getMessage());
            this.vue.getError().setVisible(true);
        }
        
    }

    // Bouton Supprimer
    public void supprimerProduit(){
        Produit selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getA().removeProduit(selected);
        this.vue.listViewAff(this.vue.getA());
    }
}
