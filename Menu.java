import entities.Airplane;
import entities.Automobile;
import entities.Ship;
import entities.Vehicle;
import java.util.ArrayList;

/**
 * Class for terminal UI
 */
class Menu {

  /**
   * Enum for choice menu option
   */
  private enum MenuChoice {
    ADD,
    DELETE,
    PRINT,
    COMPARE,
    EXIT,
  }

  /**
   * Enum for option when add vehicle (with or without params)
   */
  private enum AddVehicle {
    WITH_PARAMS,
    WITHOUT_PARAMS,
    EXIT,
  }

  /**
   * Enum for choice vehicle in submenu
   */
  private enum VehicleChoice {
    AIRPLANE,
    AUTOMOBILE,
    SHIP,
    EXIT,
  }

  /**
   * Start UI
   */
  public void start() {
    int choice;
    MenuChoice command;
    ArrayList<Vehicle> VehiclesList = new ArrayList<>(0);

    do {
      printMenu();
      printEnterMessage("number:");
      choice = Input.positiveIntInput();

      try {
        command = MenuChoice.values()[choice - 1];
      } catch (ArrayIndexOutOfBoundsException e) {
        System.err.println("This menu item does not exist!");
        continue;
      }

      switch (command) {
        case ADD -> addVehicle(VehiclesList);
        case DELETE -> deleteVehicle(VehiclesList);
        case PRINT -> printAllVehicle(VehiclesList);
        case COMPARE -> compareTwoVehicles(VehiclesList);
        case EXIT -> System.out.println("Exit from program");
      }
    } while (choice != 5);
  }

  /**
   * Method compare two Vehicles
   *
   * @param list Vehicles list
   */
  private void compareTwoVehicles(ArrayList<Vehicle> list) {
    int firstVehicle, secondVehicle;
    if (list.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }

    printEnterMessage("first vehicle index");
    firstVehicle = Input.intInput();
    printEnterMessage("second vehicle index");
    secondVehicle = Input.intInput();
    try {
      if (list.get(firstVehicle).hashCode() == list.get(secondVehicle).hashCode() &&
          list.get(firstVehicle).equals(list.get(secondVehicle))) {
        System.out.println("Vehicles equals!");
      } else {
        System.out.println("Vehicles not equal!");
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Selected non-existent element!");
    }
  }

  /**
   * Method for delete Vehicle from list
   *
   * @param list Vehicles list
   */
  private void deleteVehicle(ArrayList<Vehicle> list) {
    if (list.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }

    System.out.println("Enter index of Vehicle for delete:");
    try {
      list.remove(Input.intInput());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Selected non-existent element!");
    }
  }

  /**
   * Method for print all Vehicles in list
   *
   * @param list Vehicles list
   */
  private void printAllVehicle(ArrayList<Vehicle> list) {
    int count = 0;
    if (list.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }
    System.out.println("------Vehicles------");

    for (Vehicle Vehicle : list) {
      System.out.println("Index-" + count++ + "\n" + Vehicle.toString());
    }
  }

  /**
   * Method for choose Vehicle with params or not
   *
   * @param list Vehicles list
   */
  private void addVehicle(ArrayList<Vehicle> list) {
    int choice;
    AddVehicle command;
    do {
      printAddInfo();
      printEnterMessage("number:");
      choice = Input.positiveIntInput();

      try {
        command = AddVehicle.values()[choice - 1];
      } catch (IndexOutOfBoundsException e) {
        System.err.println("This menu item does not exist!");
        continue;
      }

      switch (command) {
        case WITH_PARAMS -> addVehicleWithParams(list);
        case WITHOUT_PARAMS -> addVehicleWithoutParams(list);
        case EXIT -> System.out.println("Return back");
      }

    } while (choice != 3);
  }

  /**
   * Method for add vehicle without params
   *
   * @param list vehicles list
   */
  private void addVehicleWithoutParams(ArrayList<Vehicle> list) {
    int choice;
    VehicleChoice command;
    do {
      printTypes();
      printEnterMessage("number:");
      choice = Input.positiveIntInput();
      try {
        command = VehicleChoice.values()[choice - 1];
      } catch (IndexOutOfBoundsException e) {
        System.err.println("This menu item does not exist!");
        continue;
      }

      switch (command) {
        case AIRPLANE -> list.add(new Airplane());
        case AUTOMOBILE -> list.add(new Automobile());
        case SHIP -> list.add(new Ship());
        case EXIT -> System.out.println("Return back");
      }
    } while (choice != 4);
  }

  /**
   * Method for add vehicles with params
   *
   * @param list vehicles list
   */
  private void addVehicleWithParams(ArrayList<Vehicle> list) {
    int choice;
    VehicleChoice command;
    do {
      printTypes();
      printEnterMessage("number:");
      choice = Input.positiveIntInput();
      try {
        command = VehicleChoice.values()[choice - 1];
      } catch (IndexOutOfBoundsException e) {
        System.err.println("This menu item does not exist!");
        continue;
      }

      switch (command) {
        case AIRPLANE -> list.add(createAirplane());
        case AUTOMOBILE -> list.add(createAutomobile());
        case SHIP -> list.add(createShip());
        case EXIT -> System.out.println("Return back");
      }

    } while (choice != 4);
  }

  /**
   * Method for create garden equipment with params
   *
   * @return garden equipment
   */
  private Vehicle createAirplane() {
    String name, flightName;
    int speed, engineCount;
    printEnterMessage("vehicle name");
    name = Input.stringInput();
    printEnterMessage("vehicle speed");
    speed = Input.positiveIntInput();
    printEnterMessage("flight name");
    flightName = Input.stringInput();
    printEnterMessage("engine count");
    engineCount = Input.positiveIntInput();
    System.out.println("Airplane add!");
    return new Airplane(speed, name, engineCount, flightName);
  }

  /**
   * Method for create automotive equipment with params
   *
   * @return automotive equipment
   */
  private Vehicle createAutomobile() {
    String name, bodyType;
    int speed, yearOfManufacture;
    printEnterMessage("automobile name");
    name = Input.stringInput();
    printEnterMessage("automobile speed");
    speed = Input.positiveIntInput();
    printEnterMessage("body type");
    bodyType = Input.stringInput();
    printEnterMessage("year of manufacture");
    yearOfManufacture = Input.dataAutomobileInput();
    System.out.println("Automobile add!");
    return new Automobile(speed, name, yearOfManufacture, bodyType);
  }

  /**
   * Method for create appliance with params
   *
   * @return appliance
   */
  private Vehicle createShip() {
    String name, shipType;
    int speed, displacement;
    printEnterMessage("ship name");
    name = Input.stringInput();
    printEnterMessage("ship power");
    speed = Input.positiveIntInput();
    printEnterMessage("ship type");
    shipType = Input.stringInput();
    printEnterMessage("displacement");
    displacement = Input.positiveIntInput();
    System.out.println("Ship add!");
    return new Ship(speed, name, displacement, shipType);
  }

  /**
   * Method for print menu
   */
  private void printMenu() {
    System.out.println("""
        -----MENU-----
        1. Add vehicle
        2. Delete vehicle
        3. Print all vehicles
        4. Compare two vehicle
        5. Exit
        --------------
        """);
  }

  /**
   * Method for print menu with type of vehicles
   */
  private void printTypes() {
    System.out.println("""
        1. Create airplane
        2. Create automobile
        3. Create ship
        4. Exit
        """);
  }

  /**
   * Method for print menu with vehicles with params or not
   */
  private void printAddInfo() {
    System.out.println("""
        1. Add with params
        2. Add without params
        3. Exit
        """);
  }

  /**
   * Method for print message like "Enter ..."
   *
   * @param string string for message
   */
  private void printEnterMessage(String string) {
    System.out.println("Enter " + string);
  }
}
