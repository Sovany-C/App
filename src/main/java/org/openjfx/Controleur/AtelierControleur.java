package org.openjfx.Controleur;

import org.openjfx.Pane.*;

import java.io.File;

import org.openjfx.Model.Atelier;

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

    public void openMachine(Atelier a){
        Scene scene = new Scene(new MachinePane(a),600,500);
        Stage machineStage = new Stage();
        machineStage.setScene(scene);
        machineStage.setTitle("Machine");
        machineStage.show();    
    }

    public void openPoste(Atelier a){
        Scene scene = new Scene(new PostePane(a), 600, 500);
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Poste");
        posteStage.show();
    }

    public void openOperation(Atelier a){
        Scene scene = new Scene(new OperationPane(a), 600, 500);
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Operation");
        posteStage.show();
    }

    public void openGamme(Atelier a){
        Scene scene = new Scene(new GammePane(a), 600, 500);
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Gamme");
        posteStage.show();
    }

    public void openProduit(Atelier a){
        Scene scene = new Scene(new ProduitPane(a), 600, 500);
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Produit");
        posteStage.show();
    }

    public void openOperateur(Atelier a){
        Scene scene = new Scene(new OperateurPane(a), 600, 500);
        Stage posteStage = new Stage();
        posteStage.setScene(scene);
        posteStage.setTitle("Operateur");
        posteStage.show();
    }

    public void dessinerAtelier(){
        for(int i=0; i<this.vue.getModel().getMachine().size();i++){
            Text text = new Text(this.vue.getModel().getMachine().get(i).getRefEquipement());
            StackPane stack = new StackPane();
            Rectangle machine = new Rectangle();
            machine.setX(this.vue.getModel().getMachine().get(i).getX());
            machine.setY(this.vue.getModel().getMachine().get(i).getY());
            machine.setWidth(30);
            machine.setHeight(30);
            machine.setStroke(Color.BLACK);
            machine.setFill(Color.WHITE); 

            stack.setAlignment(Pos.CENTER);
            stack.getChildren().addAll(machine, text);
            stack.setLayoutX(this.vue.getModel().getMachine().get(i).getX());
            stack.setLayoutY(this.vue.getModel().getMachine().get(i).getY());

            this.vue.getEspace_affichage().getChildren().addAll(stack);
        }
    }

    public void initialisation(){
        File dossier = new File("data");
        if (!dossier.exists()) {
            dossier.mkdir(); // crée le dossier "data" s'il n'existe pas
        }
        this.vue.getModel().initialisation();
    }


    
}
