package tester;

import java.util.Scanner;

public class Övningarv1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Uppgift 13 vända på text
        System.out.print("Input a string: ");
        String input = sc.nextLine();

        for (int i = input.length() - 1; i >= 0 ; i--) {
            System.out.print( input.charAt(i) );
        }
        System.out.println("");

        //Uppgift 20, jämnföra 2 tal
        System.out.println("Skriv in 2 tal för att jämnföra dem med varandra");
        String input2 = sc.nextLine();
        float tal1 = Float.parseFloat(input2);

        input2 = sc.nextLine();
        float tal2 = Float.parseFloat(input2);

        float diff = Math.abs( tal1 - tal2 );

        if ( diff < 0.001  ){
            System.out.println("Talen är lika");
        } else {
            System.out.println("Talen är inte lika");
        }
        //(int) konverterar float och dubble till int
        int heltal1 = (int) (tal1 * 1000);
        int heltal2 = (int) (tal2 * 1000);

        if (heltal1 == heltal2){
            System.out.println("Talen är lika");
        } else {
            System.out.println("Talen är inte lika");
        }

        //Uppgift 21 konsonant vs vokal


    }
}
