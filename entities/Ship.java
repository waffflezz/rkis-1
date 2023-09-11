package entities;

/**
 * Class of ship
 */
public class Ship extends Vehicle {

  /**
   * Ship displacement
   */
  private int displacement;
  /**
   * Ship body type
   */
  private String shipType;

  /**
   * Ship constructor
   *
   * @param speed Ship speed
   * @param name Ship name
   * @param displacement Ship displacement
   * @param shipType Ship body type
   */
  public Ship(int speed, String name, int displacement, String shipType) {
    super(speed, name);
    this.displacement = displacement;
    this.shipType = shipType;
  }

  /**
   * Ship constructor without params with default variables
   */
  public Ship() {
    super();
    this.displacement = 100;
    this.shipType = "battleship";
  }

  /**
   * Getter for displacement
   *
   * @return displacement
   */
  public int getDisplacement() {
    return displacement;
  }

  /**
   * Setter for displacement
   *
   * @param displacement displacement
   */
  public void setDisplacement(int displacement) {
    this.displacement = displacement;
  }

  /**
   * Getter for ship type
   *
   * @return ship type
   */
  public String getShipType() {
    return shipType;
  }

  /**
   * Setter for ship body type
   *
   * @param shipType ship type
   */
  public void setShipType(String shipType) {
    this.shipType = shipType;
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
    if (!(o instanceof Ship)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Ship ship = (Ship) o;

    if (displacement != ship.displacement) {
      return false;
    }
    return shipType != null ? shipType.equals(ship.shipType) : ship.shipType == null;
  }

  /**
   * Method for generate hash code for object
   *
   * @return hash code (int)
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + displacement;
    result = 31 * result + (shipType != null ? shipType.hashCode() : 0);
    return result;
  }

  /**
   * Method for string output
   *
   * @return string with fields of class
   */
  @Override
  public String toString() {
    return super.toString() + String.format("Displacement: %d tone\nShip type: %s\n", displacement,
        shipType);
  }
}
