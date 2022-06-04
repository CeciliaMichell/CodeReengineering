package before;

import java.util.Random;

public class Car extends Vehicle {
  private int numberOfSeats;

  public Car(String type, String manufacturer, String name, String color, int fuelCapacity, int numberOfSeats) {
    super(type, manufacturer, name, color, fuelCapacity);
    this.numberOfSeats = numberOfSeats;
    generateId();
  }

  // comment - validatenumberofseat
  public static boolean vnos(int num) {
    return num >= 1 && num <= 8;
  }

  @Override
  protected void generateId() {
    Random rand = new Random();
    id = String.format("CAR-%03d-", rand.nextInt(1000)) + numberOfSeats;
  }

  @Override
  protected int calculateSellPrice() {
    return 210500000 + (100000 * fuelCapacity);
  }
}
