package org.openjfx.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openjfx.Model.*;
import org.openjfx.Controleur.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainPane extends VBox {
    
    private ArrayList<Atelier> model;
    private ArrayList<AtelierPane> scenes;
    private MainControleur controleur;
    private SceneControleur sceneControleur;

    private TextField nom;

    private Map<AtelierPane, Button> atelierBouton;
    private Button bt_creation;

    private Stage primaryStage;
    private VBox boutonContainer;
    private GridPane pane_saisiedesinfo;

    
    public MainControleur getControleur() {
        return controleur;
    }
    public void setControleur(MainControleur controleur) {
        this.controleur = controleur;
    }
    public Map<AtelierPane, Button> getAtelierBouton() {
        return atelierBouton;
    }
    public void setAtelierBouton(Map<AtelierPane, Button> atelierBouton) {
        this.atelierBouton = atelierBouton;
    }
    public Button getBt_creation() {
        return bt_creation;
    }
    public void setBt_creation(Button bt_creation) {
        this.bt_creation = bt_creation;
    }
    public VBox getBoutonContainer() {
        return boutonContainer;
    }
    public void setBoutonContainer(VBox boutonContainer) {
        this.boutonContainer = boutonContainer;
    }
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public void setPane_saisiedesinfo(GridPane pane_saisiedesinfo) {
        this.pane_saisiedesinfo = pane_saisiedesinfo;
    }
    public TextField getNom() {
        return nom;
    }
    public void setNom(TextField nom) {
        this.nom = nom;
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public SceneControleur getSceneControleur() {
        return sceneControleur;
    }
    public void setSceneControleur(SceneControleur sceneControleur) {
        this.sceneControleur = sceneControleur;
    }
    public ArrayList<Atelier> getModel() {
        return model;
    }
    public void setModel(ArrayList<Atelier> model) {
        this.model = model;
    }
    public ArrayList<AtelierPane> getScenes() {
        return scenes;
    }
    public void setScenes(ArrayList<AtelierPane> scenes) {
        this.scenes = scenes;
    }

    public MainPane(SceneControleur sceneControleur){

        this.model = new ArrayList<Atelier>();
        this.controleur = new MainControleur(this);
        this.sceneControleur = sceneControleur;
        this.scenes = new ArrayList<AtelierPane>();

        this.nom = new TextField();

        this.atelierBouton = new HashMap<>();
        this.boutonContainer = new VBox();
        this.boutonContainer.setSpacing(5.5);
        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(nom, 0, 0);

        this.controleur.initialisation();

        this.bt_creation = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creation, 1, 0);
        this.bt_creation.setOnAction(evt ->{
            this.controleur.creationAte();
        });

        this.pane_saisiedesinfo.add(boutonContainer, 0, 1);

        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(100);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(this.pane_saisiedesinfo);
    }
    


}
