import java.util.Scanner;

public class OrdningOchReda {

    private int totalSum;

    public void startOrdningOchReda(Scanner sc) {
        System.out.println("Ordning och reda!");
        System.out.println("Skriv in några tal, avsluta med ENTER");

        String input = sc.nextLine();
        String[] arrOfString = input.split(" ");
        int[] arrOfIntegers = new int[arrOfString.length];
        for (int i = 0; i < arrOfIntegers.length; i++) {
            int arrToInt = Integer.parseInt(arrOfString[i]);
            arrOfIntegers[i] = arrToInt;
            totalSum = totalSum + arrToInt;

        }
        int minValue = arrOfIntegers[0];
        int secondMinValue = arrOfIntegers[0];
        int maxValue = arrOfIntegers[0];
        int secondMaxValue = arrOfIntegers[0];

        for (int i = 0; i < arrOfIntegers.length; i++) {
            if (arrOfIntegers[i] > maxValue) {
                secondMaxValue = maxValue;
                maxValue = arrOfIntegers[i];
            } else if (arrOfIntegers[i] > secondMaxValue) {
                secondMaxValue = arrOfIntegers[i];
            }
            if (arrOfIntegers[i] < minValue) {
                secondMinValue = minValue;
                minValue = arrOfIntegers[i];
            } else if (arrOfIntegers[i] < secondMinValue) {
                secondMinValue = arrOfIntegers[i];
            }
        }
        System.out.format("Min value: %d\n", minValue);
        System.out.format("2Min value: %d\n", secondMinValue);
        System.out.format("Max value: %d\n", maxValue);
        System.out.format("2Man value: %d\n", secondMaxValue);
        System.out.println("List is sorted: " + arrayMaker.isSorted(arrOfIntegers));
        System.out.format("Summa: %d", totalSum);
    }
}


