package tp3CodeSecret;

import java.util.Random;

public class Tp3CodeSecret {

    public static void main(String[] args) {

        Random random = new Random(); 
        String code = ""; 

        for (int i = 0; i < 4; i++) {
            int chiffre = random.nextInt(10);
            code += chiffre; 
        }

        System.out.println("CODE " + code);
    }

}
