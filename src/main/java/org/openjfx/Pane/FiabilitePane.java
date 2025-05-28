package org.openjfx.Pane;

import org.openjfx.Controleur.*;
import org.openjfx.Model.*;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public class FiabilitePane extends VBox {
     private ObservableList<Equipement> model;
    private Atelier atelier;
    
    private Label refMachine;
    private Label dMachine;
    private Label typeMachine;
    private Label cx;
    private Label cy;
    private Label rendement;
    private Label cout;
    private Label moLabel;

    private TableView<Machine> tableMachines;
    private GridPane pane_saisiedesinfo;
    private Node ref;
    private Node type;
    private Node cx_val;
    private Node cy_val;
    private Node cout_val;
    


    public ObservableList<Equipement> getModel() {
        return model;
    }
    public void setModel(ObservableList<Equipement> model) {
        this.model = model;
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
   
    public GridPane getPane_saisiedesinfo() {
        return pane_saisiedesinfo;
    }
    public TableView getTableMachines() {
        return tableMachines;
    }
    public void setTableMachines(TableView tableMachines) {
        this.tableMachines = tableMachines;
    }
    public Atelier getAtelier() {
        return atelier;
    }
    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }


    public FiabilitePane(Atelier a){
        this.model = a.getEquipements();
        this.atelier = a;

        this.refMachine = new Label("Référence:");
        this.dMachine = new Label("Désignation:");
        this.typeMachine = new Label("Type:");
        this.cx = new Label("Cx:");
        this.cy = new Label("Cy:");
        this.cout = new Label("Cout:");
        this.rendement = new Label("Fiabilite");


        this.pane_saisiedesinfo = new GridPane();
        this.pane_saisiedesinfo.setAlignment(Pos.CENTER);
        this.pane_saisiedesinfo.setHgap(5.5);
        this.pane_saisiedesinfo.setVgap(5.5);

        int l=0;
        this.pane_saisiedesinfo.add(this.refMachine, 0, l);
        this.pane_saisiedesinfo.add(this.ref,1,l);
        l++;

        this.pane_saisiedesinfo.add(this.typeMachine,0,l);
        this.pane_saisiedesinfo.add(this.type,1,l);
        l++;
        this.pane_saisiedesinfo.add(this.cx,0,l);
        this.pane_saisiedesinfo.add(this.cx_val,1,l);
        l++;
        this.pane_saisiedesinfo.add(this.cy,0,l);
        this.pane_saisiedesinfo.add(this.cy_val,1,l);
        l++;
        this.pane_saisiedesinfo.add(this.cout,0,l);
        this.pane_saisiedesinfo.add(this.cout_val,1,l);
        l++;
        this.pane_saisiedesinfo.add(this.moLabel,0,l);
        ObservableList<Machine> machinesObservable = this.atelier.getMachine();
        

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
        TableColumn<Fiabilite, Double> rendementCol = new TableColumn<Fiabilite, Double>("Fiabilite");
        rendementCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRendement()));
        this.tableMachines.getColumns().addAll(refCol, desCol,typeCol,cxCol,cyCol,coutCol, rendementCol);
        this.pane_saisiedesinfo.add(tableMachines, 0, 8);
        this.pane_saisiedesinfo.setColumnSpan(tableMachines,5);


        this.setPadding(new Insets(10, 50, 50, 50));
        this.setSpacing(10);
        this.getChildren().add(this.pane_saisiedesinfo);

    }
    
    
    
}
