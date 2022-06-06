package after;

import java.util.Random;

public class Motorcycle extends Vehicle {
  private String helmetType;

  public Motorcycle(String type, String manufacturer, String name, String color, int fuelCapacity, String helmetType) {
    super(type, manufacturer, name, color, fuelCapacity);
    this.helmetType = helmetType;
    generateId();
  }

  public static boolean validateHelmetType(String type) {
    return type.equalsIgnoreCase("Full face") || type.equalsIgnoreCase("Modular") || type.equalsIgnoreCase("Off-road");
  }

  @Override
  protected void generateId() {
    Random rand = new Random();
    id = String.format("MOTO-%03d-%s", rand.nextInt(1000), helmetType.substring(0, 3).toUpperCase());
  }

  @Override
  protected int calculateSellPrice() {
    return 12000000 + (95000 * fuelCapacity);
  }
}
