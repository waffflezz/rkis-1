import java.time.Year;
import java.util.Scanner;

/**
 * Class for input from System.in stream
 */
public class Input {
  /**
   * Method for check and input integer
   *
   * @return int
   */
  public static int intInput() {
    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextInt()) {
      System.err.println("Incorrect value!");
      scan.next();
    }
    return scan.nextInt();
  }

  /**
   * Check input year in range from 1950 to now year
   *
   * @return validate year
   */
  public static int dataAutomobileInput() {
    int year;
    do {
      year = intInput();
      if (year < 1950) {
        System.err.println("We don't have cars below 1950!");
      } else if (year > Year.now().getValue()) {
        System.err.println("We don't have cars from future!");
      }
    } while (year < 1950 || year > Year.now().getValue());

    return year;
  }

  /**
   * Method for check and input positive integer
   *
   * @return int
   */
  public static int positiveIntInput() {
    int number;
    do {
      number = intInput();
      if (number <= 0) {
        System.out.println("Number must be positive!");
      }
    } while (number <= 0);
    return number;
  }

  /**
   * Method for check and input Double
   *
   * @return double
   */
  public static double doubleInput() {
    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextDouble()) {
      System.err.println("Incorrect value!");
      scan.next();
    }
    return scan.nextDouble();
  }

  /**
   * Method for string input
   *
   * @return string
   */
  public static String stringInput() {
    Scanner scan = new Scanner(System.in);
    return scan.nextLine();
  }
}
