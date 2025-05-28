package org.openjfx.Controleur;

import org.openjfx.Pane.*;
import org.openjfx.Model.*;

import java.io.File;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AtelierControleur {
    private AtelierPane vue;

    public AtelierControleur(AtelierPane v){
        this.vue = v;
    }

    // Ouverture fenêtre spécifique
    public void openMachine(){
        Scene scene = new Scene(new MachinePane(this.vue.getModel()),800,500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage machineStage = new Stage();
        machineStage.setScene(scene);
        machineStage.setTitle("Machine");
        machineStage.show();    
    }

    public void openPoste(){
        Scene scene = new Scene(new PostePane(this.vue.getModel()), 800, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Poste");
        posteStage.show();
    }

    public void openOperation(){
        Scene scene = new Scene(new OperationPane(this.vue.getModel()), 800, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Operation");
        posteStage.show();
    }

    public void openGamme(){
        Scene scene = new Scene(new GammePane(this.vue.getModel()), 800, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Gamme");
        posteStage.show();
    }

    public void openProduit(){
        Scene scene = new Scene(new ProduitPane(this.vue.getModel()), 800, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Produit");
        posteStage.show();
    }

    public void openOperateur(){
        Scene scene = new Scene(new OperateurPane(this.vue.getModel()), 800, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Operateur");
        posteStage.show();
    }

    public void openFiabilite(){
        Fiabilite.reinitialisation(this.vue.getModel());
        Fiabilite.calculfiab(this.vue.getModel());
        Fiabilite.calculerFiabiliteMachines(this.vue.getModel());
        Scene scene = new Scene(new FiabilitePane(this.vue.getModel()), 800, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Fiabilite");
        posteStage.show();
    }

    // Dessin plan atelier
    public void dessinerAtelier(){
        this.vue.getEspace_affichage().getChildren().clear();
        for(int i=0; i<this.vue.getModel().getMachine().size();i++){
            Text text = new Text(this.vue.getModel().getMachine().get(i).getRefEquipement());
            StackPane stack = new StackPane();
            Rectangle machine = new Rectangle();
            machine.setX(this.vue.getModel().getMachine().get(i).getX());
            machine.setY(this.vue.getModel().getMachine().get(i).getY());
            machine.setWidth(35);
            machine.setHeight(35);
            machine.setStroke(Color.BLACK);
            machine.setFill(Color.WHITE); 

            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(machine, text);
            stack.setLayoutX(this.vue.getModel().getMachine().get(i).getX());
            stack.setLayoutY(this.vue.getModel().getMachine().get(i).getY());

            this.vue.getEspace_affichage().getChildren().addAll(stack);
        }
    }

    // Création des éléments à l'ouverture
    public void initialisation(){
        File dossier = new File("data/" + this.vue.getModel().getNom());
        if (!dossier.exists()) {
            dossier.mkdir(); // crée le dossier "data" s'il n'existe pas
        }
        this.vue.getModel().initialisation();
    }

    public void retour(){
        this.vue.getSceneControleur().changeMainPane();
    }
    
}
