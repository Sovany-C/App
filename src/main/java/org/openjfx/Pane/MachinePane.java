package org.openjfx.Pane;

import org.openjfx.Class.Equipement;
import org.openjfx.Class.Machine;
import org.openjfx.Class.Utilitaire;
import org.openjfx.Controleur.MachineControleur;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class MachinePane extends VBox {
    
    private ObservableList<Equipement> model;
    private MachineControleur controleur;
    
    private Label refMachine;
    private Label dMachine;
    private Label typeMachine;
    private Label cx;
    private Label cy;
    private Label cout;
    
    private TextField ref;
    private TextField des;
    private TextField type;
    private TextField cx_val;
    private TextField cy_val;
    private TextField cout_val;

    private ComboBox<Machine> choix;

    private TableView<Machine> tableMachines;
    
    private Button bt_creer;
    private Button bt_sauvegarder;
    private Button bt_modifier;
    private Button bt_supprimer;

    private GridPane pane_saisiedesinfo;

    public ObservableList<Equipement> getModel() {
        return model;
    }
    public void setModel(ObservableList<Equipement> model) {
        this.model = model;
    }
    public MachineControleur getControleur() {
        return controleur;
    }
    public void setControleur(MachineControleur controleur) {
        this.controleur = controleur;
    }
    public Label getRefMachine() {
        return refMachine;
    }
    public void setRefMachine(Label refMachine) {
        this.refMachine = refMachine;
    }
    public Label getdMachine() {
        return dMachine;
    }
    public void setdMachine(Label dMachine) {
        this.dMachine = dMachine;
    }
    public Label getTypeMachine() {
        return typeMachine;
    }
    public void setTypeMachine(Label typeMachine) {
        this.typeMachine = typeMachine;
    }
    public Label getCx() {
        return cx;
    }
    public void setCx(Label cx) {
        this.cx = cx;
    }
    public Label getCy() {
        return cy;
    }
    public void setCy(Label cy) {
        this.cy = cy;
    }
    public Label getCout() {
        return cout;
    }
    public void setCout(Label cout) {
        this.cout = cout;
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
    public TextField getType() {
        return type;
    }
    public void setType(TextField type) {
        this.type = type;
    }
    public TextField getCx_val() {
        return cx_val;
    }
    public void setCx_val(TextField cx_val) {
        this.cx_val = cx_val;
    }
    public TextField getCy_val() {
        return cy_val;
    }
    public void setCy_val(TextField cy_val) {
        this.cy_val = cy_val;
    }
    public TextField getCout_val() {
        return cout_val;
    }
    public void setCout_val(TextField cout_val) {
        this.cout_val = cout_val;
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
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public void setPane_saisiedesinfo(GridPane pane_saisiedesinfo) {
        this.pane_saisiedesinfo = pane_saisiedesinfo;
    }
    public ComboBox<Machine> getChoix() {
        return choix;
    }
    public void setChoix(ComboBox<Machine> choix) {
        this.choix = choix;
    }
    public TableView getTableMachines() {
        return tableMachines;
    }
    public void setTableMachines(TableView tableMachines) {
        this.tableMachines = tableMachines;
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



    public MachinePane(ObservableList<Equipement> m){
        this.model = m;
        this.controleur = new MachineControleur(this);

        this.refMachine = new Label("Référence:");
        this.dMachine = new Label("Désignation:");
        this.typeMachine = new Label("Type:");
        this.cx = new Label("Cx:");
        this.cy = new Label("Cy:");
        this.cout = new Label("Cout:");

        this.ref = new TextField();
        this.des = new TextField();
        this.type = new TextField();
        this.cx_val = new TextField();
        this.cy_val = new TextField();
        this.cout_val = new TextField();


        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        this.pane_saisiedesinfo.add(this.refMachine, 0, 0);
        this.pane_saisiedesinfo.add(this.ref,1,0);
        this.pane_saisiedesinfo.add(this.dMachine,0,1);
        this.pane_saisiedesinfo.add(this.des, 1,1);
        this.pane_saisiedesinfo.add(this.typeMachine,0,2);
        this.pane_saisiedesinfo.add(this.type,1,2);
        this.pane_saisiedesinfo.add(this.cx,0,3);
        this.pane_saisiedesinfo.add(this.cx_val,1,3);
        this.pane_saisiedesinfo.add(this.cy,0,4);
        this.pane_saisiedesinfo.add(this.cy_val,1,4);
        this.pane_saisiedesinfo.add(this.cout,0,5);
        this.pane_saisiedesinfo.add(this.cout_val,1,5);

        ObservableList<Machine> machinesObservable = Utilitaire.getMachines(m);
        this.choix = new ComboBox<>(machinesObservable);
        this.pane_saisiedesinfo.add(choix, 0,6);

        this.tableMachines = new TableView<Machine>();
        this.tableMachines.setItems(machinesObservable);
        TableColumn<Machine, String> refCol = new TableColumn<Machine, String>("Référence");
        refCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getRefEquipement()));
        TableColumn<Machine, String> desCol = new TableColumn<Machine, String>("Désignation");
        desCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdEquipement()));
        TableColumn<Machine, String> typeCol = new TableColumn<Machine, String>("Type");
        typeCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getType()));
        TableColumn<Machine, Float> cxCol = new TableColumn<Machine, Float>("Cx");
        cxCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getX()));
        TableColumn<Machine, Float> cyCol = new TableColumn<Machine, Float>("Cy");
        cyCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getY()));
        TableColumn<Machine, Float> coutCol = new TableColumn<Machine, Float>("Cout");
        coutCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCout()));
        this.tableMachines.getColumns().addAll(refCol, desCol,typeCol,cxCol,cyCol,coutCol);
        this.pane_saisiedesinfo.add(tableMachines, 0, 8);
        this.pane_saisiedesinfo.setColumnSpan(tableMachines,5);

        this.bt_creer = new Button("Créer");
        this.pane_saisiedesinfo.add(bt_creer, 0, 7);
        this.bt_creer.setOnAction(evt -> {
            this.controleur.creationMachine(machinesObservable);
        });

        this.bt_modifier = new Button("Modifier");
        this.pane_saisiedesinfo.add(bt_modifier, 1, 7);
        this.bt_modifier.setOnAction(evt -> {
            this.controleur.modifierMachine();
        });

        this.bt_supprimer = new Button("Supprimer");
        this.pane_saisiedesinfo.add(bt_supprimer, 2, 7);
        this.bt_supprimer.setOnAction(evt -> {
            this.controleur.supprimerMach(machinesObservable);
        });

        this.bt_sauvegarder = new Button("Sauvegarder");
        this.pane_saisiedesinfo.add(bt_sauvegarder, 4, 7);
        this.bt_sauvegarder.setOnAction(evt -> {
            this.controleur.sauvegarderMach();
        });
        

        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);

    }
    
    
}
