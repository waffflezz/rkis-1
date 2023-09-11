package entities;

import java.util.Objects;

/**
 * Class of vehicle
 */
public class Vehicle {

  /**
   * Vehicle speed
   */
  private int speed;
  /**
   * Vehicle name
   */
  private String name;

  /**
   * Constructor with params
   *
   * @param speed vehicle speed
   * @param name vehicle name
   */
  public Vehicle(int speed, String name) {
    this.speed = speed;
    this.name = name;
  }

  /**
   * Constructor without params
   */
  public Vehicle() {
    this.speed = 0;
    this.name = "Vehicle";
  }

  /**
   * Getter for speed
   *
   * @return vehicle speed
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Setter for speed
   *
   * @param speed vehicle speed
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Getter for name
   *
   * @return vehicle name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name
   *
   * @param name vehicle name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Method for equal two classes
   *
   * @param o object for equal
   * @return true if objects equal and false if not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Vehicle)) {
      return false;
    }

    Vehicle vehicle = (Vehicle) o;

    if (speed != vehicle.speed) {
      return false;
    }
    return Objects.equals(name, vehicle.name);
  }

  /**
   * Method for generate hash code for object
   *
   * @return hash code (int)
   */
  @Override
  public int hashCode() {
    int result = speed;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  /**
   * Method for string output
   *
   * @return string with fields of class
   */
  @Override
  public String toString() {
    return String.format("%s\nName: %s\nSpeed: %d km/h\n", getClass().getSimpleName(), name, speed);
  }
}
