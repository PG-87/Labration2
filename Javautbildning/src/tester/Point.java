package tester;

class Car {
 static void run() {
  System.out.println("car is running");
 }
}
class Audi extends Car {
 static void run() {
  System.out.println("Audi is running safely with 100km/h");
 }
 public static void main(String args[]) {
  Car b = new Audi();
  b.run();
 }
}
