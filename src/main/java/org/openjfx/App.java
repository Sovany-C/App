package org.openjfx;

import org.openjfx.Controleur.SceneControleur;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) { 
        SceneControleur navigation = new SceneControleur(primaryStage);
        navigation.changeMainPane(); // Lancement initial
        navigation.closeStage();
        
        primaryStage.setMaximized(true);
        primaryStage.setTitle("App");
        primaryStage.show();                   // Définir la visibilité (l'afficher)
    }

    public static void main(String[] args) {
        launch(args);
    }
}