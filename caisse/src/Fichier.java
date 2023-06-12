import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Fichier {

    static public FileInputStream ouvrirFichierLecture(String nomFichier) {
        FileInputStream fichier = null;
        try {
            fichier = new FileInputStream(nomFichier);
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur d’ouverture de fichier");
        }
        return fichier;
    }

    static public FileOutputStream ouvrirFichierEcriture(String nomFichier) {
        FileOutputStream ficSortie = null;
        try {
            ficSortie = new FileOutputStream(nomFichier);
        } catch (FileNotFoundException ex) {
            System.out.println("Erreur de création de fichier");
        }
        return ficSortie;
    }

    static public void fermerFichier(Closeable fichier) {
        try {
            fichier.close();
        } catch (IOException ex) {
            System.out.println("Erreur de fermeture de fichier");
        }
    }

    static int compterLignes(String nomFichier) {
        FileInputStream fichier = ouvrirFichierLecture(nomFichier);
        Scanner lecteurFichier = new Scanner(fichier);
        String ligne;
        int nombreLignes = 0;

        while (lecteurFichier.hasNext()) {
            ligne = lecteurFichier.next();
            nombreLignes++;
        }

        return nombreLignes;
    }


}
