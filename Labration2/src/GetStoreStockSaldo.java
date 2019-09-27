import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetStoreStockSaldo {

    public void getSaldo(Scanner sc){
        while(true) {
            while (true) {
                System.out.println("LAGERSALDO MENU");
                MenusForPrint.printCatMenu();
                String input = sc.nextLine().toLowerCase();
                switch (input) {
                    case "1":
                        System.out.println("TV i lager: " + StoreStock.tvStock.stream().toArray().length);
                        System.out.print("Modeller i lager: ");
                        Map<String, Long> mapTv = StoreStock.tvStock.stream().collect(Collectors.groupingBy(t -> t.getModelName(), Collectors.counting()));
                        System.out.println(mapTv + "\n");
                        break;
                    case "2":
                        System.out.println("Soundbars i lager: " + StoreStock.soundbarStock.stream().toArray().length);
                        System.out.print("Modeller i lager: ");
                        Map<String, Long> mapSoundbar = StoreStock.soundbarStock.stream().collect(Collectors.groupingBy(t -> t.getModelName(), Collectors.counting()));
                        System.out.println(mapSoundbar+ "\n");
                        break;
                    case "3":
                        System.out.println("Headphones i lager: " + StoreStock.headphoneStock.stream().toArray().length);
                        System.out.print("Modeller i lager: ");
                        Map<String, Long> mapHeadphone = StoreStock.headphoneStock.stream().collect(Collectors.groupingBy(t -> t.getModelName(), Collectors.counting()));
                        System.out.println(mapHeadphone+ "\n");
                        break;
                    case "4":
                        System.out.println("Speakers i lager: " + StoreStock.speakerStock.stream().toArray().length);
                        System.out.print("Modeller i lager: ");
                        Map<String, Long> mapSpeaker = StoreStock.speakerStock.stream().collect(Collectors.groupingBy(t -> t.getModelName(), Collectors.counting()));
                        System.out.println(mapSpeaker+ "\n");
                        break;
                    case "0":
                        return;
                }
            }
        }

    }
}
