package org.openjfx.Pane;

import org.openjfx.Controleur.*;
import org.openjfx.Model.*;

import javafx.beans.property.ReadOnlyObjectWrapper;
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

public class OperationPane extends VBox {

    private ObservableList<Operation> model;
    private OperationControleur controleur;
    
    private ObservableList<Equipement> equipements;
    private Label refOperation;
    private Label dOperation;
    private Label eLabel;
    private Label duree;
    private Label moLabel;

    private TextField ref;
    private TextField des;
    private TextField duree_value;
    private ListView<Equipement> listEquip;

    private ComboBox<Operation> choix;

    private TableView<Operation> tableOperations;
    
    private Button bt_creer;
    private Button bt_sauvegarder;
    private Button bt_modifier;
    private Button bt_supprimer;

    private GridPane pane_saisiedesinfo;
    private Atelier a;
    private Label error;
    
    public Label getError() {
        return error;
    }
    public void setError(Label error) {
        this.error = error;
    }

    public Atelier getA() {
        return a;
    }
    public void setA(Atelier a) {
        this.a = a;
    }
    public ObservableList<Operation> getModel() {
        return model;
    }
    public void setModel(ObservableList<Operation> model) {
        this.model = model;
    }
    public OperationControleur getControleur() {
        return controleur;
    }
    public void setControleur(OperationControleur controleur) {
        this.controleur = controleur;
    }
    public ObservableList<Equipement> getEquipements() {
        return equipements;
    }
    public void setEquipements(ObservableList<Equipement> equipements) {
        this.equipements = equipements;
    }
    public Label getRefOperation() {
        return refOperation;
    }
    public void setRefOperation(Label refOperation) {
        this.refOperation = refOperation;
    }
    public Label getdOperation() {
        return dOperation;
    }
    public void setdOperation(Label dOperation) {
        this.dOperation = dOperation;
    }
    public Label geteLabel() {
        return eLabel;
    }
    public void seteLabel(Label eLabel) {
        this.eLabel = eLabel;
    }
    public Label getDuree() {
        return duree;
    }
    public void setDuree(Label duree) {
        this.duree = duree;
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
    public TextField getDuree_value() {
        return duree_value;
    }
    public void setDuree_value(TextField duree_value) {
        this.duree_value = duree_value;
    }
    public ListView<Equipement> getListEquip() {
        return listEquip;
    }
    public void setListEquip(ListView<Equipement> listEquip) {
        this.listEquip = listEquip;
    }
    public ComboBox<Operation> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Operation> choix) {
        this.choix = choix;
    }
    public TableView<Operation> getTableOperations() {
        return tableOperations;
    }
    public void setTableOperations(TableView<Operation> tableOperations) {
        this.tableOperations = tableOperations;
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
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public void setPane_saisiedesinfo(GridPane pane_saisiedesinfo) {
        this.pane_saisiedesinfo = pane_saisiedesinfo;
    }
    public Label getMoLabel() {
        return moLabel;
    }
    public void setMoLabel(Label moLabel) {
        this.moLabel = moLabel;
    }

    public OperationPane(Atelier a){
        int c=0, l=0;
        this.model = a.getOperations();
        this.controleur = new OperationControleur(this);
        this.a = a;

        this.equipements = a.getEquipements();
        this.error = new Label();
        this.error.setVisible(false);
        this.refOperation = new Label("Référence:");
        this.dOperation = new Label("Désignation:");
        this.duree = new Label("Durée:");
        this.eLabel = new Label("Equipement:");
        this.moLabel = new Label("Modifier operation:");

        this.ref = new TextField();
        this.des = new TextField();
        this.duree_value = new TextField();

        this.listEquip = new ListView<>();
        this.listEquip.setItems(equipements);
        this.listEquip.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(this.error,0,l);
        GridPane.setColumnSpan(this.error, 5);
        l++;
        this.pane_saisiedesinfo.add(this.refOperation, c, l);
        this.pane_saisiedesinfo.add(this.ref,c+1,l);
        this.pane_saisiedesinfo.add(this.dOperation,c,l+1);
        this.pane_saisiedesinfo.add(this.des, c+1,l+1);
        this.pane_saisiedesinfo.add(this.duree,c,l+2);
        this.pane_saisiedesinfo.add(this.duree_value,c+1,l+2);
        this.pane_saisiedesinfo.add(this.eLabel, c,l+3);
        this.pane_saisiedesinfo.add(this.listEquip,c+1,l+3);

        this.pane_saisiedesinfo.add(this.moLabel, c, l+4);
        this.choix = new ComboBox<>(model);
        this.pane_saisiedesinfo.add(choix, 1,l+4);

        this.tableOperations = new TableView<Operation>();
        this.tableOperations.setItems(model);
        TableColumn<Operation, String> refCol = new TableColumn<Operation, String>("Référence");
        refCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRefOperation()));
        TableColumn<Operation, String> desCol = new TableColumn<Operation, String>("Désignation");
        desCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdOperation()));
        TableColumn<Operation, String> equiCol = new TableColumn<Operation, String>("Equipements");
        equiCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().equipementString()));
        TableColumn<Operation, Float> dureeCol = new TableColumn<Operation, Float>("Durée");
        dureeCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDureeOperation()));
        this.tableOperations.getColumns().addAll(refCol, desCol,equiCol,dureeCol);
        this.tableOperations.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.pane_saisiedesinfo.add(tableOperations, c, l+6);
        this.pane_saisiedesinfo.setColumnSpan(tableOperations,5);

        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, c, l+5);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationOperation();
        });

        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, c+1, l+5);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierOperation();
        });

        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, c+2, l+5);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerOperation();
        });

        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, c+3, l+5);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderOperation();
        });
        

        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);

    }
    
    
}
