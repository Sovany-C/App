package org.openjfx.Pane;

import org.openjfx.Controleur.*;
import org.openjfx.Model.*;

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

public class OperateurPane extends VBox {

    private ObservableList<Operateur> model;
    private OperateurControleur controleur;
    
    private ObservableList<Machine> machines;
    private Label codeOperateur;
    private Label nomLabel;
    private Label prenomLabel;
    private Label competLabel;
    private Label moLabel;

    private TextField code;
    private TextField prenom;
    private TextField nom;
    private ListView<Machine> listMachine;

    private ComboBox<Operateur> choix;

    private TableView<Operateur> tableOperateurs;
    
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
    public ObservableList<Operateur> getModel() {
        return model;
    }
    public void setModel(ObservableList<Operateur> model) {
        this.model = model;
    }
    public OperateurControleur getControleur() {
        return controleur;
    }
    public void setControleur(OperateurControleur controleur) {
        this.controleur = controleur;
    }
    public ObservableList<Machine> getMachines() {
        return machines;
    }
    public void setMachines(ObservableList<Machine> machines) {
        this.machines = machines;
    }
    public Label getCodeOperateur() {
        return codeOperateur;
    }
    public void setCodeOperateur(Label codeOperateur) {
        this.codeOperateur = codeOperateur;
    }
    public Label getNomLabel() {
        return nomLabel;
    }
    public void setNomLabel(Label nomLabel) {
        this.nomLabel = nomLabel;
    }
    public Label getPrenomLabel() {
        return prenomLabel;
    }
    public void setPrenomLabel(Label prenomLabel) {
        this.prenomLabel = prenomLabel;
    }
    public Label getCompetLabel() {
        return competLabel;
    }
    public void setCompetLabel(Label competLabel) {
        this.competLabel = competLabel;
    }
    public TextField getCode() {
        return code;
    }
    public void setCode(TextField code) {
        this.code = code;
    }
    public TextField getPrenom() {
        return prenom;
    }
    public void setPrenom(TextField prenom) {
        this.prenom = prenom;
    }
    public TextField getNom() {
        return nom;
    }
    public void setNom(TextField nom) {
        this.nom = nom;
    }
    public ListView<Machine> getListMachine() {
        return listMachine;
    }
    public void setListMachine(ListView<Machine> listMachine) {
        this.listMachine = listMachine;
    }
    public ComboBox<Operateur> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Operateur> choix) {
        this.choix = choix;
    }
    public TableView<Operateur> getTableOperateurs() {
        return tableOperateurs;
    }
    public void setTableOperateurs(TableView<Operateur> tableOperateurs) {
        this.tableOperateurs = tableOperateurs;
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

    public OperateurPane(Atelier a){
        int c=0, l=0;
        this.model = a.getOperateurs();
        this.controleur = new OperateurControleur(this);
        this.a = a;

        this.machines = a.getMachine();
        this.error = new Label();
        this.error.setVisible(false);
        this.codeOperateur = new Label("Code:");
        this.nomLabel = new Label("Nom:");
        this.prenomLabel = new Label("Prenom:");
        this.competLabel = new Label("Compétences:");
        this.moLabel = new Label("Modifier operateur");

        this.code = new TextField();
        this.nom = new TextField();
        this.prenom = new TextField();

        this.listMachine = new ListView<>();
        this.listMachine.setItems(machines);
        this.listMachine.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(this.error,0,l);
        GridPane.setColumnSpan(this.error, 5);
        l++;
        this.pane_saisiedesinfo.add(this.codeOperateur, c, l);
        this.pane_saisiedesinfo.add(this.code,c+1,l);
        l++;
        this.pane_saisiedesinfo.add(this.nomLabel,c,l);
        this.pane_saisiedesinfo.add(this.nom, c+1,l);
        l++;
        this.pane_saisiedesinfo.add(this.prenomLabel, c, l);
        this.pane_saisiedesinfo.add(this.prenom, c+1, l);
        l++;
        this.pane_saisiedesinfo.add(this.competLabel, c,l);
        this.pane_saisiedesinfo.add(this.listMachine,c+1,l);
        l++;
        this.pane_saisiedesinfo.add(this.moLabel,0,l);
        this.choix = new ComboBox<>(model);
        this.pane_saisiedesinfo.add(choix, 1,l);

        this.tableOperateurs = new TableView<Operateur>();
        this.tableOperateurs.setItems(model);
        TableColumn<Operateur, String> codeCol = new TableColumn<Operateur, String>("Code");
        codeCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCode()));
        TableColumn<Operateur, String> nomCol = new TableColumn<Operateur, String>("Nom");
        nomCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNom()));
        TableColumn<Operateur, String> prenomCol = new TableColumn<Operateur, String>("Prénom");
        prenomCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPrenom()));
        TableColumn<Operateur, String> machCol = new TableColumn<Operateur, String>("Type");
        machCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().compString()));
        this.tableOperateurs.getColumns().addAll(codeCol, nomCol,prenomCol,machCol);
        this.pane_saisiedesinfo.add(tableOperateurs, 0, 8);
        this.pane_saisiedesinfo.setColumnSpan(tableOperateurs,5);

        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, 0, 7);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationOperateur();
        });

        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, 1, 7);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierOperateur();
        });

        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, 2, 7);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerOperateur();
        });

        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, 4, 7);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderOperateur();
        });
        

        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);

    }
    
    
    
}
