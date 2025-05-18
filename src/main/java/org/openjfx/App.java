package org.openjfx;

import org.openjfx.Controleur.SceneControleur;
import org.openjfx.Pane.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) { 
        SceneControleur navigation = new SceneControleur(primaryStage);
        navigation.changeMainPane(); // Lancement initial
        navigation.closeStage();
        
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Acceuil");
        primaryStage.show();                   // Définir la visibilité (l'afficher)
    }

    public static void main(String[] args) {
        launch(args);
    }
}