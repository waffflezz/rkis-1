package entities;

public class Airplane extends Vehicle {

  /**
   * Airplane engine count
   */
  private int engineCount;
  /**
   * Airplane flight name (from: city code - to: city code)
   */
  private String flightName;

  /**
   * Constructor with params
   *
   * @param speed airplane speed
   * @param name airplane name
   * @param engineCount airplane engine count
   * @param flightName airplane flight name
   */
  public Airplane(int speed, String name, int engineCount, String flightName) {
    super(speed, name);
    this.engineCount = engineCount;
    this.flightName = flightName;
  }

  /**
   * Constructor without params
   */
  public Airplane() {
    this.engineCount = 1;
    this.flightName = "KDJ-DMD";
  }

  /**
   * Getter for engine count
   *
   * @return engine count
   */
  public int getEngineCount() {
    return engineCount;
  }

  /**
   * Setter for engine count
   *
   * @param engineCount engine count
   */
  public void setEngineCount(int engineCount) {
    this.engineCount = engineCount;
  }

  /**
   * Getter for flight name
   *
   * @return flight name
   */
  public String getFlightName() {
    return flightName;
  }

  /**
   * Setter for flight name
   *
   * @param flightName flight name
   */
  public void setFlightName(String flightName) {
    this.flightName = flightName;
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
    if (!(o instanceof Airplane)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Airplane airplane = (Airplane) o;

    if (engineCount != airplane.engineCount) {
      return false;
    }
    return flightName != null ? flightName.equals(airplane.flightName)
        : airplane.flightName == null;
  }

  /**
   * Method for generate hash code for object
   *
   * @return hash code (int)
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + engineCount;
    result = 31 * result + (flightName != null ? flightName.hashCode() : 0);
    return result;
  }

  /**
   * Method for string output
   *
   * @return string with fields of class
   */
  @Override
  public String toString() {
    return super.toString() + String.format("Engine count: %d\nFlight name: %s\n", engineCount,
        flightName);
  }
}
