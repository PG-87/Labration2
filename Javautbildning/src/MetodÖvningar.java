import java.util.Scanner;

public class MetodÖvningar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Vad är din årsinkomst?: ");
        String input = sc.nextLine();
        double income = Double.parseDouble(input);
        System.out.println("Du ska betala: " + calculateTax(income) + "kr i skatt.");

    }

        public static double calculateTax (double x){

            if (x > 100000){
                return (x * 0.4);
            } else {
                return (x * 0.3);
            }
    }
}
