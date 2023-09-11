package entities;

/**
 * Class of automobile
 */
public class Automobile extends Vehicle {

  /**
   * Year of manufacture of automobile
   */
  private int yearOfManufacture;
  /**
   * Body type of automobile
   */
  private String bodyType;

  /**
   * Constructor with params
   *
   * @param speed Automobile speed
   * @param name Automobile name
   * @param yearOfManufacture Automobile year of manufacture
   * @param bodyType Automobile body type
   */
  public Automobile(int speed, String name, int yearOfManufacture, String bodyType) {
    super(speed, name);
    this.yearOfManufacture = yearOfManufacture;
    this.bodyType = bodyType;
  }

  /**
   * Constructor without params
   */
  public Automobile() {
    this.yearOfManufacture = 1998;
    this.bodyType = "sedan";
  }

  /**
   * Getter year of manufacture
   *
   * @return Year of manufacture
   */
  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  /**
   * Setter year of manufacture
   *
   * @param yearOfManufacture Year of manufacture
   */
  public void setYearOfManufacture(int yearOfManufacture) {
    this.yearOfManufacture = yearOfManufacture;
  }

  /**
   * Getter body type
   *
   * @return body type
   */
  public String getBodyType() {
    return bodyType;
  }

  /**
   * Setter body type
   *
   * @param bodyType body type
   */
  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
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
    if (!(o instanceof Automobile)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Automobile that = (Automobile) o;

    if (yearOfManufacture != that.yearOfManufacture) {
      return false;
    }
    return bodyType != null ? bodyType.equals(that.bodyType) : that.bodyType == null;
  }

  /**
   * Method for generate hash code for object
   *
   * @return hash code (int)
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + yearOfManufacture;
    result = 31 * result + (bodyType != null ? bodyType.hashCode() : 0);
    return result;
  }

  /**
   * Method for string output
   *
   * @return string with fields of class
   */
  @Override
  public String toString() {
    return super.toString() + String.format("Year: %d\nBody Type: %s\n", yearOfManufacture,
        bodyType);
  }
}
