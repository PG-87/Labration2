import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseMenu {
    private ArrayList<Object> receipt = new ArrayList<>();
    private String input;

    void purchaseMenu(){
        MenusForPrint.purchaseMenu();
        input = Store.sc.nextLine();
        Map<String, Long> mapPurchase = StoreStock.tvStock.stream().collect(Collectors.groupingBy(t -> t.getModelName(), Collectors.counting()));
//        mapPurchase.
//        receipt.add(StoreStock.tvStock.stream().filter(tv -> tv.getModelName().equals(input)).findAny().orElse(null));
//        StoreStock.tvStock.remove(receipt);
        for (Object newReceipt : receipt){
            System.out.println(newReceipt);
        }
    }
}
