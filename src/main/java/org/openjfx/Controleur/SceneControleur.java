package org.openjfx.Controleur;

import org.openjfx.Model.Atelier;
import org.openjfx.Model.Sauvegarde;
import org.openjfx.Pane.AtelierPane;
import org.openjfx.Pane.MainPane;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneControleur {
    
    private Stage stage;
    private Scene scene;
    private MainPane main;

    public SceneControleur(Stage stage) {
        this.stage = stage;
        this.main = new MainPane(this);
        this.scene = new Scene(this.main, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
    }

    // Changement de scene
    public void changeMainPane() {
        scene.setRoot(this.main);
    }

    public void changeAtelierPane(AtelierPane a) {
        scene.setRoot(a);
    }

    // Sauvegarde Atelier
    public void closeStage(){
        stage.setOnCloseRequest(evt->{
            Sauvegarde.sauvegarderAtelier(this.main.getModel());
            for(Atelier a : this.main.getModel()){
                Sauvegarde.sauvegarderMachine(a);
                Sauvegarde.sauvegarderGamme(a);
                Sauvegarde.sauvegarderOperateur(a);
                Sauvegarde.sauvegarderOperation(a);
                Sauvegarde.sauvegarderPoste(a);
                Sauvegarde.sauvegarderProduit(a);
            }
        });
    }
}
