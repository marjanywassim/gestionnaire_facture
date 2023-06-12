import java.util.Scanner;

public class Util {
    static Scanner s = new Scanner(System.in);

    public static boolean repondre() {
        String reponse;
        do {
            System.out.println("Veuillez repondre par O/Oui ou N/Non : ");
            reponse = s.next();
            if (reponse.equalsIgnoreCase("O") || reponse.equalsIgnoreCase("Oui")) {
                return true;
            } else if (reponse.equalsIgnoreCase("N") || reponse.equalsIgnoreCase("Non")) {
                return false;
            } else {
                System.out.println("Commande incorrect !");
            }
        } while (!(reponse.equalsIgnoreCase("O") || reponse.equalsIgnoreCase("Oui") || reponse.equalsIgnoreCase("N") || reponse.equalsIgnoreCase("Non")));
        return false;
    }

}
