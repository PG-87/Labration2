package array;

import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int chooseSize = Integer.parseInt(input);
        StringList list1 = new StringList(chooseSize);

        list1.add(sc.nextLine());
        list1.add(sc.nextLine());
        list1.add(sc.nextLine());

        System.out.println(list1.getElementAt(0));
        System.out.println(list1.getElementAt(1));
        System.out.println(list1.getElementAt(2));


    }
}
