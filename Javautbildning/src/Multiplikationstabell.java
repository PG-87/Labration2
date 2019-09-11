import java.util.Scanner;

public class Multiplikationstabell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv in ett tal för att se dess multiplikationstabell");
        String input = sc.nextLine();
        String input2 = sc.nextLine();
        int age = Integer.parseInt(input);
       // multi(input);
        name(age, input2);

        System.out.println(input2);
    }
        public static void multi(int x){
            for (int i = 1; i < 11; i++) {
                System.out.print(x * i + " ");
            }
        }
        public static void name (int age, String name){
            System.out.println(age - 2019);
            System.out.println("Your name is: " + name);
        }
    }

