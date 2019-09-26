import java.util.ArrayList;
import java.util.List;

public class Store {
    static ArrayList<MenuOption> menuList = new ArrayList<>();
    public void Store() {

        StoreStock storeStart = new StoreStock();
        storeStart.executeStock();
        while (true) {
            printMenu();
            runMenu();
            testMenu();
        }
    }

    void testMenu(){
        String input = main.sc.nextLine();
        int choice = Integer.parseInt(input);
        menuList.get(choice).run.run();
    }

    void runMenu() {
        MenuOption m0 = new MenuOption();
        m0.text = "Avslutar programmet";
        m0.run = ()-> System.exit(0);
        menuList.add(m0);

        MenuOption m1 = new MenuOption();
        m1.text = "Sälj";
        menuList.add(m1);
//        m1.run.menuAction();

        MenuOption m2 = new MenuOption();
        m2.text = "Beställ";
        m2.run = () -> new AddItem().addNewTv();
        menuList.add(m2);

        MenuOption m3 = new MenuOption();
        m3.text = "Lagersaldo";
        m3.run = () -> new StoreStock().getTvStock();
        menuList.add(m3);
//        m3.run = ()-> StoreStock.class.tvStock;
//        m3.run.menuAction();

//        MenuOption m4 = new MenuOption();
//        m4.text = "Sparar till fil";
//        m4.run = () -> new StoreStock().SaveToFile();
//        menuList.add(m4);
    }
    public void printMenu() {
        System.out.println("*******************");
        System.out.println("Patriks Ljud & Bild");
        System.out.println("");
        System.out.println("1. Sälj");
        System.out.println("2. Beställ");
        System.out.println("3. Lagersaldo\n");

    }
}


