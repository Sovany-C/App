package org.openjfx.Pane;

import org.openjfx.Controleur.AtelierControleur;
import org.openjfx.Model.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AtelierPane extends VBox {
    private Atelier model;
    private AtelierControleur controleur;

    private Button bt_machine;
    private Button bt_poste;
    private Button bt_operation;
    private Button bt_produit;
    private Button bt_gamme;
    private Button bt_operateur;

    private Button bt_dessiner;

    private GridPane pane_saisiedesinfo;
    private Pane espace_affichage;

    public Atelier getModel() {
        return model;
    }
    public void setModel(Atelier model) {
        this.model = model;
    }
    public AtelierControleur getControleur() {
        return controleur;
    }
    public void setControleur(AtelierControleur controleur) {
        this.controleur = controleur;
    }
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public void setPane_saisiedesinfo(GridPane pane_saisiedesinfo) {
        this.pane_saisiedesinfo = pane_saisiedesinfo;
    }
    public Pane getEspace_affichage() {
        return espace_affichage;
    }
    public void setEspace_affichage(Pane espace_affichage) {
        this.espace_affichage = espace_affichage;
    }
    public Button getBt_machine() {
        return bt_machine;
    }
    public void setBt_machine(Button bt_machine) {
        this.bt_machine = bt_machine;
    }
    public Button getBt_poste() {
        return bt_poste;
    }
    public void setBt_poste(Button bt_poste) {
        this.bt_poste = bt_poste;
    }
    public Button getBt_operation() {
        return bt_operation;
    }
    public void setBt_operation(Button bt_operation) {
        this.bt_operation = bt_operation;
    }
    public Button getBt_produit() {
        return bt_produit;
    }
    public void setBt_produit(Button bt_produit) {
        this.bt_produit = bt_produit;
    }
    public Button getBt_gamme() {
        return bt_gamme;
    }
    public void setBt_gamme(Button bt_gamme) {
        this.bt_gamme = bt_gamme;
    }
    public Button getBt_operateur() {
        return bt_operateur;
    }
    public void setBt_operateur(Button bt_operateur) {
        this.bt_operateur = bt_operateur;
    }
    public Button getBt_dessiner() {
        return bt_dessiner;
    }
    public void setBt_dessiner(Button bt_dessiner) {
        this.bt_dessiner = bt_dessiner;
    }


    public AtelierPane(Atelier a){
        int c=0 ,l=0;
        this.model = a;
        this.controleur = new AtelierControleur(this);

        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.bt_machine = new Button("Machine");
        this.pane_saisiedesinfo.add(bt_machine,c,l);
        this.bt_machine.setOnAction(evt -> {
            this.controleur.openMachine(a.getEquipements());
        });

        this.bt_poste = new Button("Poste");
        this.pane_saisiedesinfo.add(bt_poste, c+1,l);
        this.bt_poste.setOnAction(evt -> {
            this.controleur.openPoste(a.getEquipements());
        });

        this.bt_operation = new Button("Opereration");
        this.pane_saisiedesinfo.add(bt_operation,c+2,l);
        this.bt_operation.setOnAction(evt -> {
            this.controleur.openOperation(a);
        });

        this.bt_gamme = new Button("Gamme");
        this.pane_saisiedesinfo.add(bt_gamme, c+3, l);
        this.bt_gamme.setOnAction(evt -> {
            this.controleur.openGamme(a);
        });
        
        this.bt_produit = new Button("Produit");
        this.pane_saisiedesinfo.add(bt_produit, c+4, l);
        this.bt_produit.setOnAction(evt -> {
            this.controleur.openProduit(a);
        });

        this.bt_operateur = new Button("Operateur");
        this.pane_saisiedesinfo.add(bt_operateur, c+5, l);
        this.bt_operateur.setOnAction(evt -> {
            this.controleur.openOperateur(a);
        });

        this.bt_dessiner = new Button("dessiner");
        this.pane_saisiedesinfo.add(bt_dessiner, c, l+1);
        this.bt_dessiner.setOnAction(evt -> {
            this.controleur.dessinerAtelier();
        });

        this.espace_affichage = new Pane();
        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);
        this.getChildren().add(this.espace_affichage);

    }
    
}
