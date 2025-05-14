package org.openjfx;

import org.openjfx.Class.*;
import org.openjfx.Pane.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) { 
        // Graphe de scène avec des nœuds
        Scene scene = new Scene(new AtelierPane(new Atelier("Atelier")), 600, 500);   // Construire une scène à partir de la racine du graphe de scène
        primaryStage.setScene(scene);               // The stage sets scene
        primaryStage.setTitle("Atelier");        // Définir le titre de la fenêtre
        primaryStage.show();                        // Définir la visibilité (l'afficher)
    }

    public static void main(String[] args) {
        launch(args);
    }
}