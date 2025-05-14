package org.openjfx.Pane;

import org.openjfx.Class.*;
import org.openjfx.Controleur.*;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PostePane extends VBox{

    private ObservableList<Equipement> model;
    private PosteControleur controleur;
    
    private Label refPoste;
    private Label dPoste;
    private Label machinesLabel;
    
    private TextField ref;
    private TextField des;
    private ListView<Machine> listMachines;

    private ComboBox<Poste> choix;

    private Button bt_creer;
    private Button bt_sauvegarder;
    private Button bt_modifier;
    private Button bt_supprimer;

    private TableView<Poste> tablePoste;

    private GridPane pane_saisiedesinfo;

    public ObservableList<Equipement> getModel() {
        return model;
    }
    public void setModel(ObservableList<Equipement> model) {
        this.model = model;
    }
    public PosteControleur getControleur() {
        return controleur;
    }
    public void setControleur(PosteControleur controleur) {
        this.controleur = controleur;
    }
    public Label getRefPoste() {
        return refPoste;
    }
    public void setRefPoste(Label refPoste) {
        this.refPoste = refPoste;
    }
    public Label getdPoste() {
        return dPoste;
    }
    public void setdPoste(Label dPoste) {
        this.dPoste = dPoste;
    }
    public Label getMachines() {
        return machinesLabel;
    }
    public Label getmachinesLabel() {
        return machinesLabel;
    }
    public TextField getRef() {
        return ref;
    }
    public void setRef(TextField ref) {
        this.ref = ref;
    }
    public TextField getDes() {
        return des;
    }
    public void setDes(TextField des) {
        this.des = des;
    }
    public Button getBt_creer() {
        return bt_creer;
    }
    public void setBt_creer(Button bt_creer) {
        this.bt_creer = bt_creer;
    }
    public Button getBt_modifier() {
        return bt_modifier;
    }
    public void setBt_modifier(Button bt_modifier) {
        this.bt_modifier = bt_modifier;
    }
    public Button getBt_supprimer() {
        return bt_supprimer;
    }
    public void setBt_supprimer(Button bt_supprimer) {
        this.bt_supprimer = bt_supprimer;
    }
    public Button getBt_sauvegarder() {
        return bt_sauvegarder;
    }
    public void setBt_sauvegarder(Button bt_sauvegarder) {
        this.bt_sauvegarder = bt_sauvegarder;
    }
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public void setPane_saisiedesinfo(GridPane pane_saisiedesinfo) {
        this.pane_saisiedesinfo = pane_saisiedesinfo;
    }
    public ListView<Machine> getListMachines() {
        return listMachines;
    }
    public void setListMachines(ListView<Machine> listMachines) {
        this.listMachines = listMachines;
    }
    public Label getMachinesLabel() {
        return machinesLabel;
    }
    public void setMachinesLabel(Label machinesLabel) {
        this.machinesLabel = machinesLabel;
    }
    public ComboBox<Poste> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Poste> choix) {
        this.choix = choix;
    }
    public TableView<Poste> getTablePoste() {
        return tablePoste;
    }
    public void setTablePoste(TableView<Poste> tablePoste) {
        this.tablePoste = tablePoste;
    }
    

    public PostePane(ObservableList<Equipement> p){
        ObservableList<Machine> machines = Utilitaire.getMachines(p);

        this.model = p;
        this.controleur = new PosteControleur(this);

        this.refPoste = new Label("Référence:");
        this.dPoste = new Label("Désignation:");
        this.machinesLabel = new Label("Machines:");

        this.ref = new TextField();
        this.des = new TextField();

        this.listMachines = new ListView<>();
        this.listMachines.getItems().addAll(machines);
        this.listMachines.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(this.refPoste,0,0);
        this.pane_saisiedesinfo.add(this.ref,1,0);
        this.pane_saisiedesinfo.add(this.dPoste, 0, 1);
        this.pane_saisiedesinfo.add(this.des, 1, 1);
        this.pane_saisiedesinfo.add(this.machinesLabel, 0, 2);
        this.pane_saisiedesinfo.add(this.listMachines, 1, 2);

        ObservableList<Poste> posteObservable = Utilitaire.getPostes(p);
        this.choix = new ComboBox<>(posteObservable);
        this.pane_saisiedesinfo.add(choix, 0, 3);

        this.tablePoste = new TableView<Poste>();
        this.tablePoste.setItems(posteObservable);
        TableColumn<Poste, String> refCol = new TableColumn<Poste, String>("Référence");
        refCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRefEquipement()));
        TableColumn<Poste, String> desCol = new TableColumn<Poste, String>("Désignation");
        desCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdEquipement()));
        TableColumn<Poste,String> machCol = new TableColumn<Poste,String>("Machines");
        machCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().machineString()));
        this.tablePoste.getColumns().addAll(refCol,desCol,machCol);
        this.pane_saisiedesinfo.add(tablePoste, 0, 7);
        this.pane_saisiedesinfo.setColumnSpan(tablePoste, 5);

        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, 0, 6);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationPoste(posteObservable);
        });

        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, 1, 6);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierPoste();
        });

        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, 2, 6);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerPoste(posteObservable);
        });

        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, 4, 6);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderPoste();
        });


        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);


    }
    
}
