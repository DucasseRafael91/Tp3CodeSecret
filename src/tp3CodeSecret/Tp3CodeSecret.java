package tp3CodeSecret;

import java.util.Random;
import java.util.Scanner;

public class Tp3CodeSecret {

    public static void main(String[] args) {

    	//Affectation de variables
        Random random = new Random(); 
        Scanner scan = new Scanner(System.in);
        boolean isContinue = true;
        
      
        String code = generateCode(random);
        System.out.println("CODE SECRET : " + code);

        while (isContinue) {
        	
            String userCode = userInputCode(scan);

            // Affectation de variables
            char[] codeSecretArray = code.toCharArray();
            char[] userCodeArray = userCode.toCharArray();
            int inCorrectPostion = 0;
            int inWrongPosition = 0;
            boolean[] codeUsed = new boolean[codeSecretArray.length];
            boolean[] userUsed = new boolean[userCodeArray.length];
            
            
            // Boucle pour trouver les chiffres corrects et bien placés
            for (int i_index = 0; i_index < codeSecretArray.length; i_index++) {
            	if (codeSecretArray[i_index] == userCodeArray[i_index]) {

            		inCorrectPostion ++;
            	}	
            }
            
            // Boucle pour trouver les chiffres corrects mais mal placés
            for (int i_index = 0; i_index < userCodeArray.length; i_index++) {
                if (userUsed[i_index]) {
                	continue; 
                }
                for (int j_index = 0; j_index < codeSecretArray.length; j_index++) {
                    if (!codeUsed[j_index] && userCodeArray[i_index] == codeSecretArray[j_index]) {
                    	inWrongPosition++;
                        codeUsed[j_index] = true;
                        break;
                    }
                }
            }

            System.out.println(inCorrectPostion + " chiffre bien placé ; " + inWrongPosition + " chiffre mal placé");
        }
        scan.close();
    }


	private static String userInputCode(Scanner scan) {
		System.out.print("Veuillez entrer un code : ");
		String userCode = scan.next();
		System.out.println("CODE UTILISATEUR : " + userCode);
		return userCode;
	}


    private static String generateCode(Random random) {
        String code = "";
        for (int i = 0; i < 4; i++) {
            int chiffre = random.nextInt(10);
            code += chiffre; 
        }
        return code;
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
