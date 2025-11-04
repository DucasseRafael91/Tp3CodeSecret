package tp3CodeSecret;

import java.util.Random;
import java.util.Scanner;

public class Tp3CodeSecret {

    public static void main(String[] args) {

        Random random = new Random(); 
        String code = "";
        Scanner scan = new Scanner(System.in);
        Boolean isContinue = true;

        generateCode(random, code);
        
        while (isContinue == true) {
            System.out.print("Veuillez entrer un code : ");
            String userCode = scan.next();
            System.out.println("CODE " + userCode);
            
            char[] codeSecretArray = code.toCharArray();
            System.out.println("CODE " + codeSecretArray[0]);
            char[] userCodeArray = userCode.toCharArray();
            System.out.println("CODE " + userCodeArray[0]);
                       
            isContinue = isContinueGame(isContinue,scan);
        }

        scan.close();
    }

	private static void generateCode(Random random, String code) {
		for (int i = 0; i < 4; i++) {
            int chiffre = random.nextInt(10);
            code += chiffre; 
        }

        System.out.println("CODE " + code);
	}

	private static Boolean isContinueGame(Boolean isContinue, Scanner scan) {
		
		 System.out.print("Voulez-vous réessayer ? (taper O ou N) : ");
		 System.out.println();
		 String choice = scan.next();
		
		if (choice.equalsIgnoreCase("O")) {
      
		} else {
			  isContinue = false;
		}
		return isContinue;
	}
}
