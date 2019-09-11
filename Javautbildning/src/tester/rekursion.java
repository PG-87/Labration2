package tester;

public class rekursion {

    public static void main(String[] args) {

        recursionTemplate(10);
        printFibonacci(48);
    }

    static void recursionTemplate(int count){
        if (count <= 0)
            return;

        System.out.println(count);

        recursionTemplate(count - 1);
        System.out.print(" " + count);
    }

    static long n1 = 0, n2 = 1, n3 = 0; //Memorization fo last two calculated values

    static void printFibonacci(int count){
        if (count > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            printFibonacci(count - 1);
        }
    }
}
