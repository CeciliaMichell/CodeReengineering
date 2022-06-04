package before;

import java.sql.Date;
import java.util.Scanner;
import java.util.Vector;

public class App {
  Scanner sc = new Scanner(System.in);
  Vector<Vehicle> vehicles = new Vector<>();
  Vector<Rent> rents = new Vector<>();

  // smell code - long method & switch statement
  public App() {
    int choice = -1;
    while (choice != 5) {
      System.out.println("Vehicle Shop");
      System.out.println("===============");
      System.out.println("1. Add New Vehicle");
      System.out.println("2. Rent Vehicle");
      System.out.println("3. View Vehicle List");
      System.out.println("4. Remove Vehicle");
      System.out.println("5. Exit");
      System.out.print(">> ");
      choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Add New Vehicle");
          System.out.println("===============");

          String type = "";
          while (!Vehicle.validateType(type)) {
            System.out.print("Input Vehicle Type [Car | Motorcycle]: ");
            type = sc.nextLine();
          }

          String manufacturer = "";
          while (!Vehicle.validateManufacturer(manufacturer)) {
            System.out.print("Input Manufacturer [Honda | Suzuki | Yamaha]: ");
            manufacturer = sc.nextLine();
          }

          String name = "";
          while (!Vehicle.validateName(name)) {
            System.out.print("Input Vehicle Name [6..20]: ");
            name = sc.nextLine();
          }

          String color = "";
          while (!Vehicle.validateColor(color)) {
            System.out.print("Input Vehicle Color: ");
            color = sc.nextLine();
          }

          int fuelCapacity = -1;
          while (!Vehicle.validateFuelCapacity(fuelCapacity)) {
            System.out.print("Input Fuel Capacity [min. 1 lt]: ");
            fuelCapacity = sc.nextInt();
          }

          int numberOfSeats = -1;
          if (type.equals("Car")) {
            while (!Car.validateNumberOfSeats(numberOfSeats)) {
              System.out.print("Input Number of Seats [1 - 8]: ");
              numberOfSeats = sc.nextInt();
            }
          }

          System.out.println(numberOfSeats);

          Vehicle vehicle = new Car(type, manufacturer, name, color, fuelCapacity, numberOfSeats);
          System.out.println("Generated vehicle ID: " + vehicle.getId());
          System.out.println("Successfully added new vehicle!");
          vehicles.add(vehicle);

          // duplikate code
          System.out.println("Press enter to continue...");
          sc.nextLine();
          break;
        case 2:
          System.out.println("Rent Vehicle");
          System.out.println("===============");
          Date startDate, endDate;

          Vehicle.viewAll(vehicles);

          String nameRent = "";
          while (!Rent.validateName(nameRent)) {
            System.out.print("Input Your Fullname [6..20]: ");
            nameRent = sc.nextLine();
          }

          String indentityNumb = "";
          while (!Rent.validateIdentityNumber(indentityNumb)) {
            System.out.print("Input Your Indentity Number [16 chars]: ");
            indentityNumb = sc.nextLine();
          }

          int index = -1;
          while (!(index >= 0 && index <= vehicles.size())) {
            System.out.print("Input Index [0.." + vehicles.size() + "]: ");
            index = sc.nextInt();
          }

          rents.add(new Rent(nameRent, indentityNumb, vehicles.get(index), startDate, endDate));

          // duplikate code
          System.out.println("Press enter to continue...");
          sc.nextLine();

          break;
        case 3:
          System.out.println("View Vehicle List");
          System.out.println("===============");

          if (vehicles.isEmpty()) {
            System.out.println("No vehicle added to list yet.");
            // duplikate code
            System.out.println("Press enter to continue...");
            sc.nextLine();
            return;
          }

          Vehicle.viewAll(vehicles);
          // duplikate code
          System.out.println("Press enter to continue...");
          sc.nextLine();
          break;
        case 4:
          System.out.println("Remove Vehicle");
          System.out.println("===============");

          if (vehicles.isEmpty()) {
            System.out.println("No vehicle added to list yet.");
            // duplikate code
            System.out.println("Press enter to continue...");
            sc.nextLine();
            return;
          }

          // smell code - dead code (String view)
          String view = "";
          Vehicle.viewAll(vehicles);
          int len = vehicles.size();

          int idx = -1;
          while (!(idx >= 1 && idx <= len)) {
            System.out.printf("Select vehicle [1 - %d]: ", len);
            idx = sc.nextInt();
          }

          Vehicle v = vehicles.remove(idx - 1);
          System.out.printf("Vehicle (%s) successfully removed!\n", v.getName());

          // duplikate code
          System.out.println("Press enter to continue...");
          sc.nextLine();
          break;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    new App();
  }
}
