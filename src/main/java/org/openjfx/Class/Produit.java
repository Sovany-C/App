/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.Class;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 *
 * @author anato
 */
public class Produit {
    private String codeProduit;
    private String dProduit;
    private ArrayList<Gamme> gammes;

    // Getters & Setters
    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getdProduit() {
        return dProduit;
    }

    public void setdProduit(String dProduit) {
        this.dProduit = dProduit;
    }

    public ArrayList<Gamme> getGammes() {
        return gammes;
    }

    public void setGammes(ArrayList<Gamme> gammes) {
        this.gammes = gammes;
    }

    // Constructeur
    public Produit(String codeProduit, String dProduit, ArrayList<Gamme> gammes ) {
        this.codeProduit = codeProduit;
        this.dProduit = dProduit;
        this.gammes = gammes;
    }

    // Méthodes
    public String afficheProduit(){
        return "Code produit: " + this.codeProduit + " | Désignation: " + this.dProduit;
    }

    public void modifierProduit(){
        System.out.println("Tapez 1 pour modifier le code produit, tapez 2 pour modifier la désignation");
        Scanner sc = new Scanner(System.in);
        int nombre = sc.nextInt();
        String modif;
        if(nombre == 1){
            System.out.println("Tapez votre modification");
            modif = sc.nextLine();
            this.setCodeProduit(modif);
        }
        if(nombre == 2){
            System.out.println("Tapez votre modification");
            modif = sc.nextLine();
            this.setdProduit(modif);
        }
        sc.close();
    }

    public String gammeString(){
        return this.gammes.stream()
                   .map(Gamme::getRefGamme)
                   .collect(Collectors.joining(","));
    }
  
}
