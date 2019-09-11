import objects.Car;

import java.util.Scanner;

public class OOPexample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car car1 = new Car();

        System.out.println("Bygg din egen bil:");
        System.out.print("Hur många passagerare: ");car1.setPassengers(sc.nextByte());
        System.out.println("");
        System.out.print("Vad är det för märke: ");car1.setModel(sc.nextLine());

            car1.setFuelCap(50);
            car1.setLiterKm(0.5);
            car1.setModel(sc.nextLine());


        Car car2 = new Car();
      //      car2.setPassengers(2);
      //      car2.setFuelCap(40);
       //     car2.setLiterKm(0.39);
       //     car2.setModel("Kia");

        System.out.println("Bil nr 1 är en " +car1.getModel()+" med plats för "+car1.getPassengers()+" passagerare.");
        System.out.println("Denna bil kan köra "+car1.getcomputeRange()+ " km på en full tank");

        System.out.println("Bil nr 2 är en " +car2.getModel()+" med plats för "+car2.getPassengers()+" passagerare.");
        System.out.print("Denna bil kan köra ");
        System.out.format("%.2f",car2.getcomputeRange());
        System.out.print(" km på en full tank");
    }
}
