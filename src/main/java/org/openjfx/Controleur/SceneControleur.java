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
        stage.setScene(scene);
    }

    public void changeMainPane() {
        scene.setRoot(this.main);
    }

    public void changeAtelierPane(Atelier a) {
        scene.setRoot(new AtelierPane(a,this));
    }

    public void closeStage(){
        stage.setOnCloseRequest(evt->{
            Sauvegarde.sauvegarderAtelier(this.main.getModel());
        });
    }
}
