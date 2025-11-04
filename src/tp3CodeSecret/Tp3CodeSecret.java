package tp3CodeSecret;

import java.util.Random;
import java.util.Scanner;

public class Tp3CodeSecret {

    public static void main(String[] args) {

        Random random = new Random(); 
        Scanner scan = new Scanner(System.in);
        boolean isContinue = true;


        String code = generateCode(random);
        System.out.println("CODE SECRET : " + code);

        while (isContinue) {
            System.out.print("Veuillez entrer un code : ");
            String userCode = scan.next();
            System.out.println("CODE UTILISATEUR : " + userCode);


            char[] codeSecretArray = code.toCharArray();
            char[] userCodeArray = userCode.toCharArray();

            System.out.println("Tableau du code secret :");
            for (char c : codeSecretArray) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("Tableau du code utilisateur :");
            for (char c : userCodeArray) {
                System.out.print(c + " ");
            }
            System.out.println();

            isContinue = isContinueGame(scan);
        }

        scan.close();
    }

    // Méthode qui génère et retourne un code à 4 chiffres
    private static String generateCode(Random random) {
        String code = "";
        for (int i = 0; i < 4; i++) {
            int chiffre = random.nextInt(10);
            code += chiffre; 
        }
        return code;
    }

    // Méthode qui demande à l'utilisateur s'il veut continuer
    private static boolean isContinueGame(Scanner scan) {
        System.out.print("Voulez-vous réessayer ? (taper O ou N) : ");
        String choice = scan.next();
        return choice.equalsIgnoreCase("O");
    }
}
