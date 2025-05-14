package org.openjfx.Controleur;

import org.openjfx.Pane.*;
import org.openjfx.Class.*;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AtelierControleur {
    private AtelierPane vue;

    public AtelierControleur(AtelierPane v){
        this.vue = v;
    }

    public void openMachine(ObservableList<Equipement> m){
        Scene scene = new Scene(new MachinePane(m),600,500);
        Stage machineStage = new Stage();
        machineStage.setScene(scene);
        machineStage.setTitle("Machine");
        machineStage.show();    
    }

    public void openPoste(ObservableList<Equipement> p){
        Scene scene = new Scene(new PostePane(p), 600, 500);
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


    
}
