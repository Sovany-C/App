package org.openjfx.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Fiabilite{

    public static Machine[]calculfiab( Atelier atelier){
        ArrayList<Machine> Liste = (ArrayList<Machine>) atelier.getMachine();
        
        String chemin = "suiviMaintenance.txt";
        int n=Liste.size();
        Machine[]M= new Machine[n+100];
        int e=0;
        
        
        try (BufferedReader in = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            while ((ligne = in.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(ligne, " ");
                String date = t.nextToken();
                String heure = t.nextToken();
                String ref = t.nextToken(); // machine
                String event = t.nextToken();
                String operateur = t.nextToken();
                String cause = t.nextToken();

                boolean ajouter = true;

                if (e == 0) {
                    M[0] = new Machine(ref);
                    M[0].nbPannes = 1;
                    e++;
                    continue;
                }

                for (int i = 0; i < e; i++) {
                    if (M[i].getRefMachine().equals(ref)) {
                        M[i].nbPannes++; // on incrémente directement
                        M[i].ajouterEvenement(event + " par " + operateur + " (" + cause + ")");
                        ajouter = false;
                        break;
                    }
                }

                if (ajouter) {
                    M[e] = new Machine(ref);
                    M[e].nbPannes = 1;
                    M[e].ajouterEvenement(event + " par " + operateur + " (" + cause + ")");
                    e++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Machine[] resultat = new Machine[e];
        for (int i = 0; i < e; i++) {
            resultat[i] = M[i];
        }

        return resultat;
    }
    

    public static void calculerFiabiliteMachines(Machine[] machines) {
        for (Machine m : machines) {
            // Exemple simple : fiabilité = 1 / (1 + nbPannes)
            double rendement = 1.0 / (1 + m.nbPannes);
            m.setRendement(rendement);
        }
    }


}

 