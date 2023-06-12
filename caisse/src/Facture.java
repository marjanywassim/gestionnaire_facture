import java.io.FileInputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.time.LocalDate;

public class Facture {
    public static ArrayList<Fournisseur> listeFournisseurs = new ArrayList<>();
    public static HashMap<String, Facture> listeFoctures_hash = new HashMap<>();
    private int id;
    private String nomFournisseur;
    private Fournisseur fournisseur;
    private LocalDate date;
    private double montant;
    private boolean paye;
    private boolean urgent;
    private double reste;
    Scanner s = new Scanner(System.in);
    private int jour;
    private int mois;
    private int annee;

    public Facture() {
        System.out.print("Saisir le nom du fournisseur :");
        this.nomFournisseur = s.next();
        System.out.println("Saisir la date :");
        System.out.print("Jour : ");
        this.jour = s.nextInt();
        System.out.print("Mois : ");
        this.mois = s.nextInt();
        System.out.print("Annee : ");
        this.annee = s.nextInt();
        this.date = LocalDate.of(annee, mois, jour);
        System.out.println("Saisir le montant : ");
        this.montant = s.nextDouble();
        System.out.println("Etat de paie : ");
        this.paye = Util.repondre();


    }
    public Facture(String nomFournisseur, LocalDate date, double montant, boolean paye) {
        this.fournisseur = Fournisseur.listeFournisseurs_hash.get(nomFournisseur);
        this.id = fournisseur.getFournisseurFacture_id();
        this.nomFournisseur = nomFournisseur;
        this.date = date;
        this.montant = montant;
        this.paye = paye;
        fournisseur.setFournisseurFacture_id(fournisseur.getFournisseurFacture_id()+1);
    }

    public void afficherFacture(){
        String affichage = "- Numero : " + id + '\n'
                + "- Fournisseur : " + nomFournisseur + '\n'
                + "- Date : " + date + '\n'
                + "- Montant : " + montant + '\n'
                + "- Paye : " + paye + '\n'
                + "- Reste : " + reste + '\n'
                + "- Urgent : " + urgent + '\n';

        System.out.println(affichage);
    }

    public void creerFacture(){


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setnomFournisseur(String fournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }
}
