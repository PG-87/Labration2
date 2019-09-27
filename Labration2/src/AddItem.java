import products.Headphones;
import products.Soundbar;
import products.Speaker;
import products.TV;

public class AddItem {
    StoreStock storeStock = new StoreStock();
    private static String input;

    void AddItem() {
        while (true) {
            while (true) {
                System.out.println("BESTÄLLNINGS MENU");
                MenusForPrint.printCatMenu();
                input = Store.sc.nextLine();
                switch (input) {
                    case "1":
                        addNewTv();
                        break;
                    case "2":
                        addNewSoundbar();
                        break;
                    case "3":
                        addNewHeadphone();
                        break;
                    case "4":
                        addNewSpeaker();
                        break;
                    case "0":
                        return;
                }
            }
        }
    }

    void addNewTv() {
        while (true) {
            while (true) {
                System.out.println("Vilken tv vill du beställa:\n1: UE55RU7475\n2: OLED55B8");
                MenusForPrint.backOption();
                input = Store.sc.nextLine();
                switch (input) {
                    case "1":
                        StoreStock.tvStock.add(new TV("UE55RU7475", "Samsung", 55, "TN", 2160, true));
                        System.out.println("Samsung added");
                        break;
                    case "2":
                        StoreStock.tvStock.add(new TV("OLED55B8", "LG", 55, "OLED", 2160, true));
                        System.out.println("OLED added");
                        break;
                    case "0":
                        storeStock.saveTVtoFile();
                        System.out.println("Beställning mottagen, fil sparad\n");
                        return;
                }
            }
        }
    }

    private void addNewSpeaker() {
        while (true) {
            while (true) {
                System.out.println("Vilken speaker vill du beställa:\n1: PLAY1\n2: ADDONT3");
                MenusForPrint.backOption();
                input = Store.sc.nextLine();
                switch (input) {
                    case "1":
                        StoreStock.speakerStock.add(new Speaker("PLAY1", "SONOS", true, false));
                        System.out.println("Sonos added\n");
                        break;
                    case "2":
                        StoreStock.speakerStock.add(new Speaker("ADDONT3", "AudioPro", false, true));
                        System.out.println("Audio Pro added\n");
                        break;
                    case "0":
                        storeStock.saveSpeakerToFile();
                        System.out.println("Beställning mottagen, fil sparad\n");
                        return;
                }
            }
        }
    }

    private void addNewHeadphone() {
        while (true) {
            while (true) {
                System.out.println("Vilken headphone vill du beställa:\n1: QC35\n2: T210");
                MenusForPrint.backOption();
                input = Store.sc.nextLine();
                switch (input) {
                    case "1":
                        StoreStock.headphoneStock.add(new Headphones("QC35", "Bose", true));
                        System.out.println("QC35 added\n");
                        break;
                    case "2":
                        StoreStock.headphoneStock.add(new Headphones("T210", "JBL", false));
                        System.out.println("T210 added\n");
                        break;
                    case "0":
                        storeStock.saveHeadphonesToFile();
                        System.out.println("Beställning mottagen, fil sparad\n");
                        return;
                }
            }
        }
    }

    private void addNewSoundbar() {
        while (true) {
            while (true) {
                System.out.println("Vilken soundbar vill du beställa:\n1: HWN460\n2: STUDIO");
                MenusForPrint.backOption();
                input = Store.sc.nextLine();
                switch (input) {
                    case "1":
                        storeStock.soundbarStock.add(new Soundbar("HWN460", "Samsung", 2.1));
                        System.out.println("HWN460 added\n");
                        break;
                    case "2":
                        storeStock.soundbarStock.add(new Soundbar("STUDIO", "JBL", 2.0));
                        System.out.println("STUDIO added\n");
                        break;
                    case "0":
                        storeStock.saveSoundbarToFile();
                        System.out.println("Beställning mottagen, fil sparad\n");
                        return;
                }
            }
        }
    }
}
