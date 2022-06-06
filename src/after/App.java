package after;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;
import java.util.Vector;

import after.Car;
import after.Rent;
import after.Vehicle;
import after.rentDateRange;

public class App {
  Scanner sc = new Scanner(System.in);
  Vector<Vehicle> vehicles = new Vector<>();
  Vector<Rent> rents = new Vector<>();

  // refactor
  private void AddNewVehicle() {
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
    String helmetType = "";
    Vehicle vehicle;
    if (type.equals("Car")) {
      while (!Car.validateNumberOfSeats(numberOfSeats)) {
        System.out.print("Input Number of Seats [1 - 8]: ");
        numberOfSeats = sc.nextInt();
      }
      vehicle = new Car(type, manufacturer, name, color, fuelCapacity, numberOfSeats);
    } else {

      while (!Motorcycle.validateHelmetType(helmetType)) {
        System.out.println("Input Helmet Type [Full face | Modular] : ");
        helmetType = sc.nextLine();
      }
      vehicle = new Motorcycle(type, manufacturer, name, color, fuelCapacity, helmetType);
    }

    System.out.println(numberOfSeats);
    System.out.println("Generated vehicle ID: " + vehicle.getId());
    System.out.println("Successfully added new vehicle!");
    vehicles.add(vehicle);

  }

  private boolean validateDate(String inputdate, boolean flag) {
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    Date x = null;
    try {
      x = formatDate.parse(inputdate);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private void RentVehicle() throws ParseException {
    System.out.println("Rent Vehicle");
    System.out.println("===============");

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

    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    Date startDate = null;
    Date endDate = null;
    boolean flag = false;
    String inputdatestart;
    String inputdateend;

    do {
      System.out.print("Input Start Date[dd/MM/yyyy]: ");
      inputdatestart = sc.nextLine();
      flag = validateDate(inputdatestart, flag);
    } while (!flag);
    startDate = formatDate.parse(inputdatestart);

    flag = false;
    Date temp = null;
    do {
      System.out.print("Input End Date[dd/MM/yyyy]: ");
      inputdateend = sc.nextLine();
      flag = validateDate(inputdateend, flag);
      temp = formatDate.parse(inputdateend);
    } while (!flag || startDate.after(endDate));
    endDate = temp;

    rents.add(new Rent(nameRent, indentityNumb, vehicles.get(index), new rentDateRange(startDate, endDate)));
  }

  private void ViewVehicleList() {
    System.out.println("View Vehicle List");
    System.out.println("===============");

    if (vehicles.isEmpty()) {
      System.out.println("No vehicle added to list yet.");
      return;
    }

    Vehicle.viewAll(vehicles);
  }

  private void RemoveVehicle() {
    System.out.println("Remove Vehicle");
    System.out.println("===============");

    if (vehicles.isEmpty()) {
      System.out.println("No vehicle added to list yet.");
      return;
    }

    Vehicle.viewAll(vehicles);
    int len = vehicles.size();

    int idx = -1;
    while (!(idx >= 1 && idx <= len)) {
      System.out.printf("Select vehicle [1 - %d]: ", len);
      idx = sc.nextInt();
    }

    Vehicle v = vehicles.remove(idx - 1);
    System.out.printf("Vehicle (%s) successfully removed!\n", v.getName());
  }

  private void printEnter() {
    System.out.println("Press enter to continue...");
    sc.nextLine();
  }

  public App() throws ParseException {
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
          AddNewVehicle();
          printEnter();
          break;
        case 2:
          RentVehicle();
          printEnter();
          break;
        case 3:
          ViewVehicleList();
          printEnter();
          break;
        case 4:
          RemoveVehicle();
          printEnter();
          break;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    new App();
  }
}
