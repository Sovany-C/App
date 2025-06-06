package org.openjfx.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Lecture {
    
    public static void lecturePoste(Atelier atelier){
        Alert alert = new Alert(AlertType.ERROR);
        File fichier = new File("data/"+atelier.getNom()+"/postes.txt");
        if(fichier.exists()){
            String refPoste,dPoste;
            String[] machines;
            Set<Machine> machinePoste = new HashSet<>();
            String[] mots;

            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
        
                    //* -Décomposer une chaine de caratères avec la méthode split de la classe String
                    mots = lignelue.split(";");
                    refPoste = mots[0];
                    dPoste = mots[1];
                    machines = mots[2].split(",");

                    for(Equipement e : atelier.getEquipements()){
                        if(e instanceof Machine){
                            Machine m = (Machine) e;
                            for(String ref : machines){
                                if(m.getRefEquipement().equals(ref)){
                                    if(!atelier.getMachinelibre().contains(m)){
                                        throw new IllegalArgumentException("Erreur: élément déjà utilisé");
                                    }
                                    machinePoste.add(m);
                                    break;
                                }
                            }
                        }
                    }
                    atelier.verifPoste(refPoste);
                    Poste p = new Poste(refPoste, dPoste,new HashSet<>(machinePoste));
                    atelier.getEquipements().add(p);
                    machinePoste.clear();
                }
                flux.close();
                
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err +" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
            }
            catch(IOException err){
                System.out.println("Erreur Poste :\n"+err);

            }
            catch(IllegalArgumentException e){
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText(e.getMessage()+" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
                System.out.println(e.getMessage());
            }   
        }
        

    }

    public static void lectureMachine(Atelier atelier){
        Alert alert = new Alert(AlertType.ERROR);
        File fichier = new File("data/"+atelier.getNom()+ "/machines.txt");
        if(fichier.exists()){
            String refMachine,dMachine,type;
            float x,y,cout;
            String[] mots;

            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
        
                    //* -Décomposer une chaine de caratères avec la méthode split de la classe String
                    mots = lignelue.split(";");
                    refMachine = mots[0];
                    dMachine = mots[1];
                    type = mots[2];
                    x = Float.valueOf(mots[3]);
                    y = Float.valueOf(mots[4]);
                    cout = Float.valueOf(mots[5]);

                    atelier.verifMachine(refMachine);
                    Machine m = new Machine(refMachine, dMachine, type, x, y, cout);
                    atelier.getEquipements().add(m);
                }
                flux.close();
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err +" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
            }
            catch(IOException err){
                System.out.println("Erreur Machine:\n"+err);
            }
            catch(NumberFormatException e){
                System.out.println("Erreur: format des nombres incorrectes");
            }
            catch(IllegalArgumentException e){
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText(e.getMessage()+" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
                System.out.println(e.getMessage());
            }    
        }
    }

    public static void lectureOperateur(Atelier atelier){
        Alert alert = new Alert(AlertType.ERROR);
        File fichier = new File("data/"+atelier.getNom()+ "/operateurs.txt");
        if(fichier.exists()){
            String code,nom,prenom;
            String[] machines;
            ArrayList<Machine> competences = new ArrayList<>();
            String[] mots;

            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
        
                    //* -Décomposer une chaine de caratères avec la méthode split de la classe String
                    mots = lignelue.split(";");
                    code = mots[0];
                    nom = mots[1];
                    prenom = mots[2];
                    machines = mots[3].split(",");

                    for(Equipement e : atelier.getEquipements()){
                        if(e instanceof Machine){
                            Machine m = (Machine) e;
                            for(String ref : machines){
                                if(m.getRefEquipement().equals(ref)){
                                    competences.add(m);
                                    break;
                                }
                            }
                        }
                    }
                    atelier.verifOperateur(code);
                    Operateur op = new Operateur(code, nom, prenom, new ArrayList<>(competences));
                    atelier.getOperateurs().add(op);
                    competences.clear();
                }
                flux.close();
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err +" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
            }
            catch(IOException err){
                System.out.println("Erreur :\n"+err);
            }
            catch(IllegalArgumentException e){
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText(e.getMessage()+" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
                System.out.println(e.getMessage());
            }    
        }
    }

    public static void lectureGamme(Atelier atelier){
        Alert alert = new Alert(AlertType.ERROR);
        File fichier = new File("data/"+atelier.getNom()+"/gammes.txt");
        if(fichier.exists()){
            String ref;
            String[] equipement, operations;
            ArrayList<Operation> Listop = new ArrayList<>();
            Set<Equipement> Listequi = new HashSet<>();
            String[] mots;

            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
        
                    //* -Décomposer une chaine de caratères avec la méthode split de la classe String
                    mots = lignelue.split(";");
                    ref = mots[0];
                    operations = mots[1].split(",");
                    equipement = mots[2].split(",");

                    for(Operation o : atelier.getOperations()){
                        for(String op : operations){
                                if(o.getRefOperation().equals(op)){
                                    Listop.add(o);
                                    break;
                                }
                            }
                    }

                    for(Equipement e : atelier.getEquipements()){
                        for(String eq : equipement){
                                if(e.getRefEquipement().equals(eq)){
                                    Listequi.add(e);
                                    break;
                                }
                            }
                    }

                    atelier.verifGamme(ref);
                    Gamme g = new Gamme(ref, new ArrayList<>(Listop), new HashSet<>(Listequi));
                    atelier.getGammes().add(g);
                    Listequi.clear();
                    Listop.clear();
                }
                flux.close();
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err +" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
            }
            catch(IOException err){
                System.out.println("Erreur :\n"+err);}
            catch(IllegalArgumentException e){
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText(e.getMessage()+" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
                System.out.println(e.getMessage());
            }   
        }
        
    }

    public static void lectureOperation(Atelier atelier){
        Alert alert = new Alert(AlertType.ERROR);
        File fichier = new File("data/" +atelier.getNom()+"/operations.txt");
        if(fichier.exists()){
            String refOp, dOp;
            float duree;
            String[] equipement;
            ArrayList<Equipement> Listequi = new ArrayList<>();
            String[] mots;

            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
        
                    //* -Décomposer une chaine de caratères avec la méthode split de la classe String
                    mots = lignelue.split(";");
                    refOp = mots[0];
                    dOp = mots[1];
                    equipement = mots[2].split(",");
                    duree = Float.valueOf(mots[3]);

                    for(Equipement e : atelier.getEquipements()){
                        for(String eq : equipement){
                                if(e.getRefEquipement().equals(eq)){
                                    Listequi.add(e);
                                    break;
                                }
                            }
                    }
                    atelier.verifOperation(refOp);
                    Operation op = new Operation(refOp, dOp, new ArrayList<>(Listequi),duree);
                    atelier.getOperations().add(op);
                    Listequi.clear();
                }
                flux.close();
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err +" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
            } 
            catch(IOException err){
                System.out.println("Erreur :\n"+err);}
            catch(IllegalArgumentException e){
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText(e.getMessage()+" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
                System.out.println(e.getMessage());
            }   
        }
        
    }

    public static void lectureProduit(Atelier atelier){
        Alert alert = new Alert(AlertType.ERROR);
        File fichier = new File("data/"+atelier.getNom()+"/produits.txt");
        if(fichier.exists()){
            String codePro, dProd;
            String[] gammes;
            ArrayList<Gamme> Listgamme = new ArrayList<>();
            String[] mots;

            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
        
                    //* -Décomposer une chaine de caratères avec la méthode split de la classe String
                    mots = lignelue.split(";");
                    codePro = mots[0];
                    dProd = mots[1];
                    gammes = mots[2].split(",");

                    for(Gamme g : atelier.getGammes()){
                        for(String ref : gammes){
                                if(g.getRefGamme().equals(ref)){
                                    if(!atelier.getGammelibre().contains(g)){
                                        throw new IllegalArgumentException("Erreur: Gamme déjà utilisé");
                                    }
                                    Listgamme.add(g);
                                    break;
                                }
                            }
                    }
                    atelier.verifPoste(codePro);
                    Produit pr = new Produit(codePro,dProd,new ArrayList<>(Listgamme));
                    atelier.getProduits().add(pr);
                    Listgamme.clear();
                }
                flux.close();
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err +" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
            }
            catch(IOException err){
                System.out.println("Erreur :\n"+err);}
            catch(IllegalArgumentException e){
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText(e.getMessage()+" |Atelier: " + atelier.getNom());
                    alert.showAndWait();
                });
                System.out.println(e.getMessage());
            }   
        }
        
    }

    public static ArrayList<Atelier> lectureAtelier(){
        Alert alert = new Alert(AlertType.ERROR);
        ArrayList<Atelier> ateliers = new ArrayList<>();
        File fichier = new File("data/ateliers.txt");

        if(fichier.exists()){
            try{
                BufferedReader flux=new BufferedReader(new FileReader(fichier));
                String lignelue;
                while((lignelue=flux.readLine())!=null){
                    ateliers.add(new Atelier(lignelue));
                }
                flux.close();
            }
            catch(FileNotFoundException err){
                System.out.println("Erreur :le fichier n’existe pas!\n "+err);
                Platform.runLater(() -> {
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :le fichier n’existe pas!\n "+err);
                    alert.showAndWait();
                });
            }
            catch(IOException err){
                System.out.println("Erreur :\n"+err);}     
        }
        return ateliers;
    }

    
}
