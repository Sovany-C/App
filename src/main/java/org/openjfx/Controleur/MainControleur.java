package org.openjfx.Controleur;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.openjfx.Model.Atelier;
import org.openjfx.Model.Lecture;
import org.openjfx.Model.Sauvegarde;
import org.openjfx.Pane.*;

import javafx.scene.control.Button;

public class MainControleur {
    
    private MainPane vue;

    public MainControleur(MainPane v){
        this.vue =v;
    }

    public void creationAte(){
        Atelier a = new Atelier(this.vue.getNom().getText().trim());

        Button bt_atelier = new Button(a.getNom());
        bt_atelier.setOnAction(evt -> {
            openAtelier(a);
        });
        
        this.vue.getNom().clear();
        this.vue.getModel().add(a);
        this.vue.getAtelierBouton().put(a, bt_atelier);
        this.vue.getBoutonContainer().getChildren().add(bt_atelier);
        
    }

    public void openAtelier(Atelier a){
        Sauvegarde.sauvegarderAtelier(this.vue.getModel());
        this.vue.getSceneControleur().changeAtelierPane(a);
    }
    

    public void initialisation(){
        this.vue.getModel().addAll(Lecture.lectureAtelier());
        for(Atelier a : this.vue.getModel()){
            Button bt_atelier = new Button(a.getNom());

            bt_atelier.setOnAction(evt -> {
                openAtelier(a);
            });
        
            this.vue.getAtelierBouton().put(a, bt_atelier);
            this.vue.getBoutonContainer().getChildren().add(bt_atelier);
        }
    }
}
