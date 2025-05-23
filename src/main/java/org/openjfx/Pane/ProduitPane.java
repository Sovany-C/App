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

public class ProduitPane extends VBox {

    private ObservableList<Produit> model;
    private ProduitControleur controleur;
    
    private ObservableList<Gamme> gammes;
    private Label codeProduit;
    private Label dProduit;
    private Label gLabel;
    private Label moLabel;

    private TextField code;
    private TextField des;
    private ListView<Gamme> listGamme;

    private ComboBox<Produit> choix;

    private TableView<Produit> tableProduits;
    
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
    public ObservableList<Produit> getModel() {
        return model;
    }
    public void setModel(ObservableList<Produit> model) {
        this.model = model;
    }
    public ProduitControleur getControleur() {
        return controleur;
    }
    public void setControleur(ProduitControleur controleur) {
        this.controleur = controleur;
    }
    public Label getCodeProduit() {
        return codeProduit;
    }
    public void setCodeProduit(Label codeProduit) {
        this.codeProduit = codeProduit;
    }
    public Label getdProduit() {
        return dProduit;
    }
    public void setdProduit(Label dProduit) {
        this.dProduit = dProduit;
    }
    public Label getgLabel() {
        return gLabel;
    }
    public void setgLabel(Label gLabel) {
        this.gLabel = gLabel;
    }
    public TextField getCode() {
        return code;
    }
    public void setCode(TextField code) {
        this.code = code;
    }
    public TextField getDes() {
        return des;
    }
    public void setDes(TextField des) {
        this.des = des;
    }
    public ComboBox<Produit> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Produit> choix) {
        this.choix = choix;
    }
    public TableView<Produit> getTableProduits() {
        return tableProduits;
    }
    public void setTableProduits(TableView<Produit> tableProduits) {
        this.tableProduits = tableProduits;
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
    public ObservableList<Gamme> getGammes() {
        return gammes;
    }
    public void setGammes(ObservableList<Gamme> gammes) {
        this.gammes = gammes;
    }
    public ListView<Gamme> getListGamme() {
        return listGamme;
    }
    public void setListGamme(ListView<Gamme> listGamme) {
        this.listGamme = listGamme;
    }
    public Label getMoLabel() {
        return moLabel;
    }
    public void setMoLabel(Label moLabel) {
        this.moLabel = moLabel;
    }

    public ProduitPane(Atelier a){

        this.model = a.getProduits();
        this.controleur = new ProduitControleur(this);
        this.a = a;

        this.gammes = a.getGammes();
        this.error = new Label();
        this.error.setVisible(false);
        this.codeProduit = new Label("Code:");
        this.dProduit = new Label("Désignation:");
        this.gLabel = new Label("Gammes");

        this.code = new TextField();
        this.des = new TextField();

        this.listGamme = new ListView<>();
        this.listGamme.getItems().addAll(gammes);
        this.listGamme.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        int l=0;
        this.pane_saisiedesinfo.add(this.error,0,l);
        GridPane.setColumnSpan(this.error, 5);
        l++;
        this.pane_saisiedesinfo.add(this.codeProduit, 0, l);
        this.pane_saisiedesinfo.add(this.code,1,l);
        l++;
        this.pane_saisiedesinfo.add(this.dProduit,0,l);
        this.pane_saisiedesinfo.add(this.des, 1,l);
        l++;
        this.pane_saisiedesinfo.add(this.gLabel, 0,l);
        this.pane_saisiedesinfo.add(listGamme,1,l);
        l++;

        this.choix = new ComboBox<>(model);
        this.pane_saisiedesinfo.add(choix, 0,l);

        this.tableProduits = new TableView<Produit>();
        this.tableProduits.setItems(model);
        TableColumn<Produit, String> codeCol = new TableColumn<Produit, String>("Référence");
        codeCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCodeProduit()));
        TableColumn<Produit, String> desCol = new TableColumn<Produit, String>("Désignation");
        desCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdProduit()));
        TableColumn<Produit, String> gamCol = new TableColumn<Produit, String>("Type");
        gamCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().gammeString()));
        this.tableProduits.getColumns().addAll(codeCol, desCol,gamCol);
        this.pane_saisiedesinfo.add(tableProduits, 0, 8);
        this.pane_saisiedesinfo.setColumnSpan(tableProduits,5);

        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, 0, l);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationProduit();
        });

        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, 1, l);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierProduit();
        });

        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, 2, l);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerProduit();
        });

        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, 4, l);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderProduit();
        });
        

        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);

    }
    
    
}
