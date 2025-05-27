package org.openjfx.Pane;

import org.openjfx.Controleur.*;
import org.openjfx.Model.*;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PostePane extends VBox{    
    
    private ObservableList<Equipement> model;
    private ObservableList<Machine> machines;
    private PosteControleur controleur;
    
    private Label refPoste;
    private Label dPoste;
    private Label machinesLabel;
    private Label modLabel;
    
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
    private Atelier atelier;   
    
    private Label error;
    
    // Getters et Setters
    public ObservableList<Equipement> getModel() {
        return model;
    }
    public void setModel(ObservableList<Equipement> model) {
        this.model = model;
    }
    public ObservableList<Machine> getMachines() {
        return machines;
    }
    public void setMachines(ObservableList<Machine> machines) {
        this.machines = machines;
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
    public Label getMachinesLabel() {
        return machinesLabel;
    }
    public void setMachinesLabel(Label machinesLabel) {
        this.machinesLabel = machinesLabel;
    }
    public Label getModLabel() {
        return modLabel;
    }
    public void setModLabel(Label modLabel) {
        this.modLabel = modLabel;
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
    public ListView<Machine> getListMachines() {
        return listMachines;
    }
    public void setListMachines(ListView<Machine> listMachines) {
        this.listMachines = listMachines;
    }
    public ComboBox<Poste> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Poste> choix) {
        this.choix = choix;
    }
    public Button getBt_creer() {
        return bt_creer;
    }
    public void setBt_creer(Button bt_creer) {
        this.bt_creer = bt_creer;
    }
    public Button getBt_sauvegarder() {
        return bt_sauvegarder;
    }
    public void setBt_sauvegarder(Button bt_sauvegarder) {
        this.bt_sauvegarder = bt_sauvegarder;
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
    public TableView<Poste> getTablePoste() {
        return tablePoste;
    }
    public void setTablePoste(TableView<Poste> tablePoste) {
        this.tablePoste = tablePoste;
    }
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public void setPane_saisiedesinfo(GridPane pane_saisiedesinfo) {
        this.pane_saisiedesinfo = pane_saisiedesinfo;
    }
    public Atelier getAtelier() {
        return atelier;
    }
    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }
    public Label getError() {
        return error;
    }
    public void setError(Label error) {
        this.error = error;
    }
    
    // Constructeur
    public PostePane(Atelier a){
        this.model = a.getEquipements();
        this.controleur = new PosteControleur(this);
        this.atelier = a;
        
        this.error = new Label();
        this.error.setVisible(false);
        this.refPoste = new Label("Référence:");
        this.dPoste = new Label("Désignation:");
        this.machinesLabel = new Label("Machines:");
        this.modLabel = new Label("Modifier poste:"); 

        this.ref = new TextField();
        this.des = new TextField();     
        this.listMachines = new ListView<>();
        this.listMachines.setItems(this.atelier.getMachine());        
        this.listMachines.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.listViewAff(a);
        
        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);       

        int l=0;
        this.pane_saisiedesinfo.add(this.error,0,l);
        GridPane.setColumnSpan(this.error, 5);
        l++;
        this.pane_saisiedesinfo.add(this.refPoste,0,l);
        this.pane_saisiedesinfo.add(this.ref,1,l);
        l++;
        this.pane_saisiedesinfo.add(this.dPoste, 0, l);
        this.pane_saisiedesinfo.add(this.des, 1, l);
        l++;
        this.pane_saisiedesinfo.add(this.machinesLabel, 0, l);
        this.pane_saisiedesinfo.add(this.listMachines, 1, l);
        l++;
        this.pane_saisiedesinfo.add(this.modLabel,0,l);      
        
        ObservableList<Poste> posteObservable = this.atelier.getPostes();
        this.choix = new ComboBox<>(posteObservable);
        this.pane_saisiedesinfo.add(choix, 1, l);   
        l++;

        // Tableau d'affichage
        this.tablePoste = new TableView<Poste>();
        this.tablePoste.setItems(posteObservable);
        TableColumn<Poste, String> refCol = new TableColumn<Poste, String>("Référence");
        refCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRefEquipement()));
        TableColumn<Poste, String> desCol = new TableColumn<Poste, String>("Désignation");
        desCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdEquipement()));
        TableColumn<Poste,String> machCol = new TableColumn<Poste,String>("Machines");
        machCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().machineString()));
        this.tablePoste.getColumns().addAll(refCol,desCol,machCol);
        this.tablePoste.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        this.pane_saisiedesinfo.add(tablePoste, 0, 8);
        GridPane.setColumnSpan(tablePoste, 5);      
        
        // Boutons
        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, 0, l);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationPoste(posteObservable);
        });     
        
        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, 1, l);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierPoste();
        });     
        
        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, 2, l);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerPoste(posteObservable);
        });     
        
        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, 4, l);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderPoste(a);
        });

        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);
    }

    // Méthode affichage couleur de la ListView
    public void listViewAff(Atelier a){
        this.listMachines.setCellFactory(lv -> new ListCell<>() {
        @Override
        protected void updateItem(Machine item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setStyle("");
            } else {
                setText(item.getRefEquipement());
            if (!a.getMachinelibre().contains(item)) {
                setStyle("-fx-text-fill:rgb(230, 89, 89);"); 
            }
            }
        }
        });
    }
    
}
