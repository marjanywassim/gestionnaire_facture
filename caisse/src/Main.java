import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        /*Scanner s = new Scanner(System.in);
        int choix;

        afficherMenu();

        afficherMenuActions();
        choix = s.nextInt();
        switch (choix) {
            case 1:
                break;
            case 2:
                break;
            case 0:
                afficherCredits();
                break;
            default:
                System.out.println("Erreur, veuiller saisir un nombre entre 0 et 2 !");
        }*/

        Fournisseur.creerBaseDonnees_fournisseurs();
        /*Facture f1 = new Facture("adonis", LocalDate.of(2020, 6, 10),1500,true);
        Facture f2 = new Facture("adonis", LocalDate.of(2023, 6, 10),1500,true);
        Facture f3 = new Facture("venizia", LocalDate.of(2023, 6, 10),1500,true);*/

        Facture f1 = new Facture();
        Facture f2 = new Facture();


        f1.afficherFacture();
        f2.afficherFacture();

        /*LocalDate l1 = LocalDate.now();
        LocalDate l2 = LocalDate.of(2004, 15, 2);
        System.out.println();
*/

    }

    static void afficherMenu() {
        final String MENU = '\t' + "*****" + " MARCHE MARJANY " + "*****" + '\t' + '\n'
                + '\t' + "GESTIONNAIRE DE FACTURES" + '\n';

        System.out.println(MENU);

    }

    static void afficherMenuActions() {
        final String MENU_ACTIONS = "Choisissez une action :" + '\n'
                + '\t' + "1- Voir les factures" + '\n'
                + '\t' + "2- Ajouter une facture" + '\n'
                + '\t' + "0- Quitter" + '\n'
                + "Saisir un numero (0-2) : ";

        System.out.println(MENU_ACTIONS);
        System.out.println();

    }

    static void afficherCredits() {
        final String CREDITS = '\t' + "**************" + '\n'
                + '\t' + "MADE BY 5KINNY" + '\n'
                + '\t' + "**************" + '\n';

        System.out.println(CREDITS);
    }

    static void afficherMenu_Factures() {
        final String MENU_FACTURES = "Choisissez une action :" + '\n'
                + '\t' + "1- Chercher par fournisseur" + '\n'
                + '\t' + "2- Chercher par date" + '\n'
                + '\t' + "3- Chercher par ID" + '\n'
                + '\t' + "0- Revenir en arriere" + '\n'
                + "Saisir un numero (0-3) : ";

        System.out.println(MENU_FACTURES);
        System.out.println();
    }

    static void voirFactures() {
        Scanner s = new Scanner(System.in);
        int choix;

        do {
            afficherMenu_Factures();
            choix = s.nextInt();
            switch (choix) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Erreur, veuiller saisir un nombre entre 0 et 3 !");
            }
        } while (choix != 0);
    }

}