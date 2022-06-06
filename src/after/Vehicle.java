package after;

import java.util.Vector;

public abstract class Vehicle {
  protected String id;
  protected String type;
  protected String manufacturer;
  protected String name;
  protected String color;
  protected int fuelCapacity;

  public Vehicle(String type, String manufacturer, String name, String color, int fuelCapacity) {
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
    this.color = color;
    this.fuelCapacity = fuelCapacity;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static boolean validateType(String type) {
    return type.equals("Car") || type.equals("Motorcycle");
  }

  public static boolean validateManufacturer(String manufacturer) {
    return manufacturer.equals("Honda") || manufacturer.equals("Suzuki") || manufacturer.equals("Yamaha");
  }

  public static boolean validateName(String name) {
    return name.length() >= 6 && name.length() <= 20;
  }

  public static boolean validateColor(String color) {
    return !color.isEmpty();
  }

  public static boolean validateFuelCapacity(int fuelCapacity) {
    return fuelCapacity > 0;
  }

  public static void viewAll(Vector<Vehicle> vehicles) {
    int len = vehicles.size();

    for (int i = 0; i < len; i++) {
      System.out.printf("| %2d. | %s\n", i + 1, vehicles.get(i));
    }
  }

  @Override
  public String toString() {
    return String.format("%-20s | %-12s | %-15s | Rp. %15d |", name, manufacturer, id, calculateSellPrice());
  }

  protected abstract void generateId();

  protected abstract int calculateSellPrice();

}
