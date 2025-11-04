package tp3CodeSecret;

import java.util.Random;
import java.util.Scanner;

public class Tp3CodeSecret {

    public static void main(String[] args) {

        Random random = new Random(); 
        Scanner scan = new Scanner(System.in);
        boolean isContinue = true;
        int inCorrectPostion = 0;


        String code = generateCode(random);
        System.out.println("CODE SECRET : " + code);

        while (isContinue) {
            System.out.print("Veuillez entrer un code : ");
            String userCode = scan.next();
            System.out.println("CODE UTILISATEUR : " + userCode);


            char[] codeSecretArray = code.toCharArray();
            char[] userCodeArray = userCode.toCharArray();

            for (int i_index = 0; i_index < codeSecretArray.length; i_index++) {
            	if (codeSecretArray[i_index] == userCodeArray[i_index]) {

            		inCorrectPostion ++;
            		
            	}
            	
            }

            System.out.println(inCorrectPostion + " chiffre bien placé ; 1 chiffre mal placé");
            isContinue = isContinueGame(isContinue,scan);
        }

        scan.close();
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
