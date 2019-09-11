import java.util.Scanner;

public class v34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int siffror = 0;
        try {
            int siffror2 = Integer.parseInt(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(siffror);
    }
}
