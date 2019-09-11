package tester;

import java.util.Scanner;

public class Uppg21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        if(input.length() > 1){
            System.out.println("Too many zoos!");
        } else if (input.length() == 0){
            System.out.println("You have to write something");
        } else {
            char tecken = input.toLowerCase().charAt(0);

            if(tecken >= 'a' && tecken <= 'z'){

            //   String vokaler = "aeiouy";
            //   if( vokaler.contains(input.toLowerCase()))
                switch ( tecken ){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'y':
                        System.out.println("Vokal");
                        break;
                    default:
                        System.out.println("Konsonant");
                }
            }
        }
    }
}
