package org.openjfx.Controleur;

import org.openjfx.Model.Machine;
import org.openjfx.Model.Sauvegarde;
import org.openjfx.Pane.FiabilitePane;
import org.openjfx.Pane.MachinePane;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class FiabiliteControleur {

private FiabilitePane vue;

public FiabiliteControleur(MachinePane v){
    this.vue = v;
}
