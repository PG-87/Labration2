import java.util.Scanner;

public class Miniräknare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Skriv in på nummer");
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();

            System.out.println("Vad vill du göra med dessa nummer?");
            System.out.println("1. Addera");
            System.out.println("2. Multiplicera");
            System.out.println("3. Subtrahera");
            System.out.println("4. Dividera");
            System.out.println("5. Modulera");
            System.out.println("6. Exit");

            int choose = sc.nextInt();

            if (choose == 1) {
                int sumadd = input1 + input2;
                System.out.println("Result: " + sumadd);
            } else if (choose == 2) {
                int summulti = input1 * input2;
                System.out.println("Result: " + summulti);
            } else if (choose == 3) {
                int sumsub = input1 - input2;
                System.out.println("Result: " + sumsub);
            } else if (choose == 4) {
                int sumdiv = input1 / input2;
                System.out.println("Result: " + sumdiv);
            } else if (choose == 5) {
                int summod = input1 % input2;
                System.out.println("Result: " + summod);
            } else if (choose == 6){
                break;
            } else
                System.out.println("Du måste välja ett nummer mellan 1 och 5");
        }


    }
}
