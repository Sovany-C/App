package org.openjfx.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Sauvegarde {
    
    public static void sauvegarderMachine(Atelier a){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/"+ a.getNom()+"/machines.txt"));
            for (Equipement e : a.getEquipements())
                if(e instanceof Machine){
                    Machine m = (Machine) e;
                    pw.println(m.getRefEquipement()+";"+m.getdEquipement()+";"+m.getType()+";"+m.getX()+";"+m.getY()+";"+m.getCout());
                }
            pw.close();
            System.out.println("Machine ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderPoste(Atelier a){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/"+a.getNom()+"/postes.txt"));
            for (Equipement e : a.getEquipements()){
                if(e instanceof Poste){
                    Poste p = (Poste) e;
                    pw.println(p.getRefEquipement()+";"+p.getdEquipement()+";"+p.machineString());
                }
            }
            pw.close();
            System.out.println("Poste ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderOperation(Atelier a){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/"+a.getNom()+"/operations.txt"));
            for (Operation op : a.getOperations()){
                pw.println(op.getRefOperation()+";"+op.getdOperation()+";"+op.equipementString()+";"+op.getDureeOperation());
            }
            pw.close();
            System.out.println("Operation ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderGamme(Atelier a){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/"+a.getNom()+"/gammes.txt"));
            for (Gamme g : a.getGammes()){
                pw.println(g.getRefGamme()+";"+g.opString()+";"+g.eqString());
            }
            pw.close();
            System.out.println("Gamme ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderProduit(Atelier a){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/"+a.getNom()+"/produits.txt"));
            for (Produit p : a.getProduits()){
                pw.println(p.getCodeProduit()+";"+p.getdProduit()+";"+p.gammeString());
            }
            pw.close();
            System.out.println("Produit ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderOperateur(Atelier a){
        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("data/"+a.getNom()+"/operateurs.txt"));
            for (Operateur p : a.getOperateurs()){
                pw.println(p.getCode()+";"+p.getNom()+";"+p.getPrenom()+";"+p.compString());
            }
            pw.close();
            System.out.println("Operateur ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderAtelier(ArrayList<Atelier> ateliers){
        PrintWriter pw;
        System.out.println(ateliers.size());
        try {
            pw = new PrintWriter(new FileOutputStream("data/ateliers.txt"));
            for (Atelier a : ateliers){
                pw.println(a.getNom());
            }
            pw.close();
            System.out.println("Atelier ajouté au fichier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
