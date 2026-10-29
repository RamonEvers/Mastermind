
package mastermind;

import java.util.Scanner;
import java.util.Random;

public class Variables02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] kleuren = {
            "rood", "paars", "blauw",
            "geel", "oranje", "groen"
        };

        String[] code = new String[4];

        for (int i = 0; i < 4; i++) {
            code[i] = kleuren[random.nextInt(6)];
        }

        int poging = 1;
        boolean gewonnen = false;

        System.out.println("=== MASTERMIND ===");
        System.out.println("Je hebt 10 pogingen om de code te raden.");
        System.out.println("Kies uit: rood, paars, blauw, geel, oranje, groen");

        while (poging <= 10 && !gewonnen) {

            String[] gok = new String[4];

            System.out.println("\nPoging " + poging);

            for (int i = 0; i < 4; i++) {

                boolean geldigeKleur = false;

                while (!geldigeKleur) {

                    System.out.print("Kleur " + (i + 1) + ": ");
                    String invoer = scanner.nextLine().trim().toLowerCase();

                    for (int j = 0; j < kleuren.length; j++) {
                        if (invoer.equals(kleuren[j])) {
                            geldigeKleur = true;
                            gok[i] = invoer;
                            break;
                        }
                    }

                    if (!geldigeKleur) {
                        System.out.println(
                            "cheeky boy! ramon does not approve"
                        );
                        System.out.println(
                            "Kies alleen: rood, paars, blauw, geel, oranje of groen."
                        );
                    }
                }
            }

            int zwart = 0;
            int wit = 0;

            boolean[] codeGebruikt = new boolean[4];
            boolean[] gokGebruikt = new boolean[4];

            for (int i = 0; i < 4; i++) {
                if (gok[i].equals(code[i])) {
                    zwart++;
                    codeGebruikt[i] = true;
                    gokGebruikt[i] = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                if (!gokGebruikt[i]) {
                    for (int j = 0; j < 4; j++) {
                        if (!codeGebruikt[j] && gok[i].equals(code[j])) {
                            wit++;
                            codeGebruikt[j] = true;
                            break;
                        }
                    }
                }
            }

            System.out.println("Zwarte pionnen: " + zwart);
            System.out.println("Witte pionnen: " + wit);

            if (zwart == 4) {
                gewonnen = true;
                System.out.println("\nGEWONNEN!");
                System.out.println("Je hebt de code geraden!");
                System.out.println("Aantal pogingen: " + poging);
            } else {
                System.out.println("Probeer opnieuw!");
            }

            poging++;
        }

        if (!gewonnen) {
            System.out.println("\nVERLOREN!");
            System.out.println("Je hebt alle 10 pogingen gebruikt.");
            System.out.print("De geheime code was: ");

            for (int i = 0; i < 4; i++) {
                System.out.print(code[i] + " ");
            }
        }

        scanner.close();
    }
}

