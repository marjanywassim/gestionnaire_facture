import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Fournisseur {
    public static ArrayList<Fournisseur> listeFournisseurs = new ArrayList<>();
    public static HashMap<String, Fournisseur> listeFournisseurs_hash = new HashMap<>();
    private String nom;
    private int nombreFactures;
    private int fournisseurFacture_id = 1;
    private int nombreFactures_payees;
    private int nombreFactures_impayes;
    private static int nombreFournisseurs = Fichier.compterLignes("listeFournisseurs.txt");
    public static String[][] baseDonnees_fournisseurs = creerBaseDonnees_fournisseurs();


    public Fournisseur(String nom, int nombreFactures, int nombreFactures_payees, int nombreFactures_impayes) {
        this.nom = nom;
        this.nombreFactures = nombreFactures;
        this.nombreFactures_payees = nombreFactures_payees;
        this.nombreFactures_impayes = nombreFactures_impayes;
        listeFournisseurs.add(this);
        listeFournisseurs_hash.put(nom, this);
    }

    public static String[][] creerBaseDonnees_fournisseurs() {
        String[][] baseDonnees_Fournisseurs = new String[nombreFournisseurs][4];
        FileInputStream fichier = Fichier.ouvrirFichierLecture("listeFournisseurs.txt");
        Scanner lecteurFichier = new Scanner(fichier);
        String[] tableauTemp;
        String ligne;

        for (int i = 0; i < nombreFournisseurs; i++) {
            ligne = lecteurFichier.next();
            tableauTemp = ligne.split(";");
            for (int j = 0; j < 4; j++) {
                baseDonnees_Fournisseurs[i][j] = tableauTemp[j];
                listeFournisseurs.add(new Fournisseur(tableauTemp[0], Integer.parseInt(tableauTemp[1]), Integer.parseInt(tableauTemp[2]), Integer.parseInt(tableauTemp[3])));
            }

        }

        return baseDonnees_Fournisseurs;
    }

    public static Fournisseur chercherFournisseur_nom() {
        Scanner s = new Scanner(System.in);
        String nom;
        int compteurResultats;
        String resultat = null;

        do {
            compteurResultats = 0;
            System.out.print("Saisir le nom : ");
            nom = s.next();
            System.out.println("Résultats trouvés : ");
            for (int i = 0; i < baseDonnees_fournisseurs.length; i++) {
                if (baseDonnees_fournisseurs[i][0].contains(nom)) {
                    compteurResultats++;
                    System.out.println(baseDonnees_fournisseurs[i][0]);
                    resultat = baseDonnees_fournisseurs[i][0];
                }
            }
            System.out.println("Nombre de résultats trouvés : " + compteurResultats);
            if (compteurResultats == 0) {
                System.out.println("Nous n'avons trouvé aucun résultat, veuillez réessayer !");
            } else if (compteurResultats > 1) {
                System.out.println("Nous avons trouvé plusieurs résultats, veuillez raffiner votre recherche !");
            } else if (compteurResultats == 1) {
                System.out.println("Nous avons trouvé : " + resultat);
            }
        } while (compteurResultats != 1);
        return listeFournisseurs_hash.get(resultat);
    }

    /*public static Fournisseur chercherFournisseur_date() {

    }*/

    public static void afficherTableau_Fournisseurs() {
        for (int i = 0; i < nombreFournisseurs; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        System.out.print("Nom : " + baseDonnees_fournisseurs[i][j] + " | ");
                        break;
                    case 1:
                        System.out.print("Nombre de factures : " + baseDonnees_fournisseurs[i][j] + " | ");
                        break;
                    case 2:
                        System.out.print("Payées : " + baseDonnees_fournisseurs[i][j] + " | ");
                        break;
                    case 3:
                        System.out.print("Impayées : " + baseDonnees_fournisseurs[i][j]);
                        break;
                }
            }

            System.out.println();
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreFactures() {
        return nombreFactures;
    }

    public void setNombreFactures(int nombreFactures) {
        this.nombreFactures = nombreFactures;
    }

    public int getFournisseurFacture_id() {
        return fournisseurFacture_id;
    }

    public void setFournisseurFacture_id(int fournisseurFacture_id) {
        this.fournisseurFacture_id = fournisseurFacture_id;
    }

    public int getNombreFactures_payees() {
        return nombreFactures_payees;
    }

    public void setNombreFactures_payees(int nombreFactures_payees) {
        this.nombreFactures_payees = nombreFactures_payees;
    }

    public int getNombreFactures_impayes() {
        return nombreFactures_impayes;
    }

    public void setNombreFactures_impayes(int nombreFactures_impayes) {
        this.nombreFactures_impayes = nombreFactures_impayes;
    }
}
