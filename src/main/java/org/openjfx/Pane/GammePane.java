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

public class GammePane extends VBox {

    private ObservableList<Gamme> model;
    private GammeControleur controleur;
    
    private ObservableList<Operation> operations;

    private Label refGamme;
    private Label oLabel;
    private Label moLabel;

    private TextField ref;

    private ListView<Operation> listOperation;

    private ComboBox<Gamme> choix;

    private TableView<Gamme> tableGammes;
    
    private Button bt_creer;
    private Button bt_sauvegarder;
    private Button bt_modifier;
    private Button bt_supprimer;

    private GridPane pane_saisiedesinfo;
    private Atelier a;

    private Label error;
    
    // Getters et Setters
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
    public ObservableList<Gamme> getModel() {
        return model;
    }
    public void setModel(ObservableList<Gamme> model) {
        this.model = model;
    }
    public GammeControleur getControleur() {
        return controleur;
    }
    public void setControleur(GammeControleur controleur) {
        this.controleur = controleur;
    }
    public ObservableList<Operation> getOperations() {
        return operations;
    }
    public void setOperations(ObservableList<Operation> operations) {
        this.operations = operations;
    }
    public Label getRefGamme() {
        return refGamme;
    }
    public void setRefGamme(Label refGamme) {
        this.refGamme = refGamme;
    }
    public Label getoLabel() {
        return oLabel;
    }
    public void setoLabel(Label oLabel) {
        this.oLabel = oLabel;
    }
    public TextField getRef() {
        return ref;
    }
    public void setRef(TextField ref) {
        this.ref = ref;
    }
    public ListView<Operation> getListOperation() {
        return listOperation;
    }
    public void setListOperation(ListView<Operation> listOperation) {
        this.listOperation = listOperation;
    }
    public ComboBox<Gamme> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Gamme> choix) {
        this.choix = choix;
    }
    public TableView<Gamme> getTableGammes() {
        return tableGammes;
    }
    public void setTableGammes(TableView<Gamme> tableGammes) {
        this.tableGammes = tableGammes;
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

    // Constructeur
    public GammePane(Atelier a){
        int c=0, l=0;
        this.model = a.getGammes();
        this.controleur = new GammeControleur(this);
        this.a = a;

        this.operations = a.getOperations();
        this.error = new Label();
        this.error.setVisible(false);
        this.refGamme = new Label("Référence:");
        this.oLabel = new Label("Operations:");
        this.moLabel = new Label("Modifier gamme ");

        this.ref = new TextField();

        this.listOperation = new ListView<>();
        this.listOperation.setItems(operations);
        this.listOperation.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(this.error,0,l);
        GridPane.setColumnSpan(this.error, 5);
        l++;
        this.pane_saisiedesinfo.add(this.refGamme, c, l);
        this.pane_saisiedesinfo.add(this.ref,c+1,l);
        l++;
        this.pane_saisiedesinfo.add(this.oLabel,c,l);
        this.pane_saisiedesinfo.add(this.listOperation,c+1,l);
        l++;
        this.pane_saisiedesinfo.add(this.getMoLabel(), c, l);
        this.choix = new ComboBox<>(model);
        this.pane_saisiedesinfo.add(choix, c+1,l);
        
        // Tableau d'affichage
        this.tableGammes = new TableView<Gamme>();
        this.tableGammes.setItems(model);
        TableColumn<Gamme, String> refCol = new TableColumn<Gamme, String>("Référence");
        refCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRefGamme()));
        TableColumn<Gamme, String> opCol = new TableColumn<Gamme, String>("Opérations");
        opCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().opString()));
        TableColumn<Gamme, String> eqCol = new TableColumn<Gamme, String>("Equipements");
        eqCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().eqString()));
        TableColumn<Gamme, Float> coutCol = new TableColumn<Gamme, Float>("Cout");
        coutCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().coutGamme()));
        TableColumn<Gamme, Float> dureeCol = new TableColumn<Gamme, Float>("Durée");
        dureeCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().dureeGamme()));
        this.tableGammes.getColumns().addAll(refCol, opCol,eqCol,coutCol,dureeCol);
        this.tableGammes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.pane_saisiedesinfo.add(tableGammes, 0, 8);
        GridPane.setColumnSpan(tableGammes,5);

        // Boutons
        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, 0, 7);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationGamme();
        });

        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, 1, 7);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierGamme();
        });

        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, 2, 7);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerGamme();
        });

        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, 4, 7);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderGamme();
        });
        
        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);

    }
    
    
}
