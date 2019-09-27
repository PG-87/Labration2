import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static Scanner sc = new Scanner(System.in);
    static ArrayList<MenuOption> menuList = new ArrayList<>();

    public void Store() {

        StoreStock storeStart = new StoreStock();
        storeStart.executeStock();
        while (true) {
            MenusForPrint.printStart();
            mainMenu();
                for (MenuOption menuOption : menuList) {
                    System.out.println(menuOption.text);
                }
            menuChoice();
        }
    }

    private void menuChoice(){
        String input = sc.nextLine();
        int choice = Integer.parseInt(input);
        menuList.get(choice).run.run();
    }

    private void mainMenu() {
        MenuOption m0 = new MenuOption();
        m0.text = "0: Avslutar programmet";
        m0.run = ()-> System.exit(0);
        menuList.add(m0);

        MenuOption m1 = new MenuOption();
        m1.text = "1: Sälj";
        m1.run = () -> new PurchaseMenu().purchaseMenu();
        menuList.add(m1);

        MenuOption m2 = new MenuOption();
        m2.text = "2: Beställ";
        m2.run = () -> new AddItem().AddItem();
        menuList.add(m2);

        MenuOption m3 = new MenuOption();
        m3.text = "3: Lagersaldo";
        m3.run = () -> new GetStoreStockSaldo().getSaldo(sc);
        menuList.add(m3);


    }
}


