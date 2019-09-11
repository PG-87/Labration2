package array;

import java.util.Arrays;
import java.util.Scanner;

public class Arrayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] anArray = new int[10];

        anArray[0] = 10;

        System.out.println(anArray[0]);
        System.out.println(Integer.MAX_VALUE);//En integers maxvärde, som är hur stor en Array kan vara
        System.out.println(Arrays.toString(anArray)); //En hjälp klass till arrays för att skriva ut, sortera mm, i arrayer.

        String[] cars = {"Volvo", "BMW", "Ford", "Saab"};
        String searchString = sc.nextLine(); //.intern() JVM letar efter interna textsträngar som redan finns i minnet.
        int index = findIndexOfCar(searchString, cars);
        System.out.println(index);

        for (String car : cars) { //for each loop
            System.out.print(car);
            if (car.length() < 4)
                System.out.print("\t");
            System.out.print("\t");
        }

        int[][] dim2 = new int[3][5];

        print2DimArray(dim2);

    }
    private static void print2DimArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);

            }
            System.out.println("");
        }
    }
    private static int findIndexOfCar(String brand, String[] array){
        for (int i = 0; i < array.length; i++) {
            if (brand.equals( array[i]) )
                return i;
        } return -1;
    }
}