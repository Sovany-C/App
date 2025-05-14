package org.openjfx.Controleur;

import org.openjfx.Model.*;
import org.openjfx.Pane.ProduitPane;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProduitControleur {

    private ProduitPane vue;

    public ProduitControleur(ProduitPane v){
        this.vue = v;
    }

    public void creationProduit(){
        List<Gamme> selection = this.vue.getListGamme().getSelectionModel().getSelectedItems();
        Produit m = new Produit(this.vue.getCode().getText().trim(), this.vue.getDes().getText().trim(), new ArrayList<>(selection));
        this.vue.getModel().add(m);
        System.out.println("Equipement: " + this.vue.getCode().getText() + " ajouté à la liste");
        this.vue.getTableProduits().refresh();
    }

    public void sauvegarderProduit(){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("Produits.txt"));
            for (Produit p : this.vue.getModel()){
                pw.println(p.getCodeProduit()+";"+p.getdProduit()+";"+p.gammeString());
            }
            pw.close();
            System.out.println("Produit ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void modifierProduit(){
        Produit selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        if(selected != null){
            if(!this.vue.getCode().getText().trim().isEmpty()){
                selected.setCodeProduit(this.vue.getCode().getText().trim());
            }
            if(!this.vue.getDes().getText().trim().isEmpty()){
                selected.setCodeProduit(this.vue.getDes().getText().trim());
            }
            if(!this.vue.getListGamme().getSelectionModel().isEmpty()){
                List<Gamme> selection = this.vue.getListGamme().getSelectionModel().getSelectedItems();
                selected.setGammes(new ArrayList<>(selection));
            }
            int index = this.vue.getChoix().getSelectionModel().getSelectedIndex();
            this.vue.getChoix().getItems().set(index, selected);
            System.out.println("Produit modifié");
            this.vue.getTableProduits().refresh();

        }
    }

    public void supprimerProduit(){
        Produit selected = this.vue.getChoix().getSelectionModel().getSelectedItem();
        this.vue.getModel().remove(selected);
    }
}
