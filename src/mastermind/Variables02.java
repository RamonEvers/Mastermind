package mastermind;


import java.util.Scanner;
import java.util.Random;

public class Variables02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] kleuren = {"rood", "paars", "blauw", "geel", "oranje"};
        String[] code = new String[4];

       
        for (int i = 0; i < 4; i++) {
            code[i] = kleuren[random.nextInt(5)];
        }

        int poging = 1;
        boolean gewonnen = false;

        System.out.println("=== MASTERMIND ===");
        System.out.println("Kies uit: rood, paars, blauw, geel, oranje");

        while (!gewonnen) {

            String[] gok = new String[4];

            System.out.println("\nPoging " + poging);

          
            for (int i = 0; i < 4; i++) {
                System.out.print("Kleur " + (i + 1) + ": ");
                gok[i] = scanner.nextLine().toLowerCase();
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
                            gokGebruikt[i] = true;
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

        scanner.close();
    }
}