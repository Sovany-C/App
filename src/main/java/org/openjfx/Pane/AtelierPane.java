package org.openjfx.Pane;

import org.openjfx.Controleur.AtelierControleur;
import org.openjfx.Controleur.SceneControleur;
import org.openjfx.Model.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AtelierPane extends VBox {
    private Atelier model;
    private AtelierControleur controleur;
    private SceneControleur sceneControleur;

    private Label nom;
    private Label plan;
    
    private Button bt_machine;
    private Button bt_poste;
    private Button bt_operation;
    private Button bt_produit;
    private Button bt_gamme;
    private Button bt_operateur;
    private Button bt_retour;

    private Button bt_dessiner;

    private GridPane pane_saisiedesinfo;
    private Pane espace_affichage;
    private VBox pane_VBox;
    private HBox paneHBox;

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
    public Label getNom() {
        return nom;
    }
    public void setNom(Label nom) {
        this.nom = nom;
    }
    public Label getPlan() {
        return plan;
    }
    public void setPlan(Label plan) {
        this.plan = plan;
    }
    public Button getBt_retour() {
        return bt_retour;
    }
    public void setBt_retour(Button bt_retour) {
        this.bt_retour = bt_retour;
    }
    public SceneControleur getSceneControleur() {
        return sceneControleur;
    }
    public void setSceneControleur(SceneControleur sceneControleur) {
        this.sceneControleur = sceneControleur;
    }

    public AtelierPane(Atelier a, SceneControleur scene){
        int c=0 ,l=0;
        this.model = a;
        this.controleur = new AtelierControleur(this);
        this.sceneControleur = scene;

        this.nom = new Label(a.getNom());
        this.nom.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-font-family:Arial;");
        this.plan = new Label("Plan de l'atelier : ");
        this.plan.setStyle("-fx-font-size: 18;");
    
        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(this.nom, c, l);
        GridPane.setColumnSpan(this.nom, 5);

        this.controleur.initialisation();

        this.bt_retour = new Button("Retour");
        this.pane_saisiedesinfo.add(this.bt_retour,6,l);
        this.bt_retour.setOnAction(evt -> {
            this.controleur.retour();
        });
        l+=1;

        this.bt_machine = new Button("Machine");
        this.pane_saisiedesinfo.add(bt_machine,c,l);
        this.bt_machine.setOnAction(evt -> {
            this.controleur.openMachine();
        });
        c++;
        this.bt_poste = new Button("Poste");
        this.pane_saisiedesinfo.add(bt_poste, c,l);
        this.bt_poste.setOnAction(evt -> {
            this.controleur.openPoste();
        });
        c++;
        this.bt_operation = new Button("Operation");
        this.pane_saisiedesinfo.add(bt_operation,c,l);
        this.bt_operation.setOnAction(evt -> {
            this.controleur.openOperation();
        });
        c++;
        this.bt_gamme = new Button("Gamme");
        this.pane_saisiedesinfo.add(bt_gamme, c, l);
        this.bt_gamme.setOnAction(evt -> {
            this.controleur.openGamme();
        });
        c++;
        this.bt_produit = new Button("Produit");
        this.pane_saisiedesinfo.add(bt_produit, c, l);
        this.bt_produit.setOnAction(evt -> {
            this.controleur.openProduit();
        });
        c++;
        this.bt_operateur = new Button("Operateur");
        this.pane_saisiedesinfo.add(bt_operateur, c, l);
        this.bt_operateur.setOnAction(evt -> {
            this.controleur.openOperateur();
        });
        c++;
        l++;

        this.bt_dessiner = new Button("Plan");
        this.bt_dessiner.setOnAction(evt -> {
            this.controleur.dessinerAtelier();
        });

        this.espace_affichage = new Pane();
        this.espace_affichage.setPrefSize(1000, 600);
        this.espace_affichage.setStyle("-fx-background-color:rgb(70, 79, 97);");

        this.paneHBox = new HBox(10);
        this.paneHBox.getChildren().addAll(this.plan, this.bt_dessiner);
        this.pane_VBox = new VBox(10);
        this.pane_VBox.getChildren().addAll(this.paneHBox, this.espace_affichage);

        this.setPrefSize(900, 500);
        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(this.pane_saisiedesinfo);
        this.getChildren().add(this.pane_VBox);
    }

    
}
