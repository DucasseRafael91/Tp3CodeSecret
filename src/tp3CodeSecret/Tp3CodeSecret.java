package tp3CodeSecret;

import java.util.Random;
import java.util.Scanner;

public class Tp3CodeSecret {

    public static void main(String[] args) {

    	//Affectation de variables
        Random random = new Random(); 
        Scanner scan = new Scanner(System.in);
        Boolean codeFound = false ;
        
        String code = generateCode(random);
        System.out.println("CODE SECRET : " + code);

        while (codeFound == false) {
        	
            String userCode = userInputCode(scan);

            // Affectation de variables
            char[] codeSecretArray = code.toCharArray();
            char[] userCodeArray = userCode.toCharArray();
            int inCorrectPostion = 0;
            int inWrongPosition = 0;
            boolean[] codeUsed = new boolean[codeSecretArray.length];
            boolean[] userUsed = new boolean[userCodeArray.length];
            
            
            inCorrectPostion = correctWithGoodPosition(codeSecretArray, userCodeArray, inCorrectPostion, codeUsed,userUsed);
            inWrongPosition = correctButNotCorrectPosition(codeSecretArray, userCodeArray, inWrongPosition, codeUsed,userUsed);
            
            System.out.println(inCorrectPostion + " chiffre bien placé ; " + inWrongPosition + " chiffre mal placé");
            
            if(inCorrectPostion == 4) {
            	System.out.print("Vous avez trouvé le code");
            	codeFound = true ; 
            	break;
            }
        }
        scan.close();
    }


	private static int correctWithGoodPosition(char[] secretCodeArray, char[] userCodeArray, int inCorrectPostion, boolean[] codeUsed, boolean[] userUsed) {
		/**
		 * Méthode permettant de savoir si un chiffre est au bonne endroit
		 * param secretCodeArray : liste des characters du code à trouver
		 * param userCodeArray : liste des characters du code saisie par l'utilisateur
		 * param inCorrectPostion : nombre de characters à la bonne position
		 * param codeUsed : permet de savoir si une valeur du code générée à été utilisée
		 * param userUsed : permet de savoir si une valeur du code saisie par l'utilisateur à été utilisée
		 * return inCorrectPostion : nombre de valeurs bien placés
		 */
		
		for (int i_index = 0; i_index < secretCodeArray.length; i_index++) {
			if (secretCodeArray[i_index] == userCodeArray[i_index]) {

				inCorrectPostion ++;
				  codeUsed[i_index] = true; 
			      userUsed[i_index] = true; 
			}	
		}
		return inCorrectPostion;
	}


	private static int correctButNotCorrectPosition(char[] secretCodeArray, char[] userCodeArray, int inWrongPosition, boolean[] codeUsed, boolean[] userUsed) {
		/**
		 * Méthode permettant de savoir si un chiffre est correct mais au mauvaise endroit
		 * param secretCodeArray : liste des characters du code à trouver
		 * param userCodeArray : liste des characters du code saisie par l'utilisateur
		 * param inCorrectPostion : nombre de characters à la bonne position
		 * param codeUsed : permet de savoir si une valeur du code générée à été utilisée
		 * param userUsed : permet de savoir si une valeur du code saisie par l'utilisateur à été utilisée
		 * return inCorrectPostion : nombre de valeurs bien placés
		 */
		
		// Boucle pour trouver les chiffres corrects mais mal placés
		for (int i_index = 0; i_index < userCodeArray.length; i_index++) {
		    if (userUsed[i_index]) {
		    	continue; 
		    }
		    for (int j_index = 0; j_index < secretCodeArray.length; j_index++) {
		        if (!codeUsed[j_index] && userCodeArray[i_index] == secretCodeArray[j_index]) {
		        	inWrongPosition++;
		            codeUsed[j_index] = true;
		            break;
		        }
		    }
		}
		return inWrongPosition;
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
}
