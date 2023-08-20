package util;

import java.util.Random;
import java.util.UUID;

public class Utils {
  public static String createNewId() {
    return UUID.randomUUID().toString();
  }

  public static Position createRandomPosition(double width, double height) {
    double x = new Random().nextDouble() * width;
    double y = new Random().nextDouble() * width;
    return new Position(x, y);
  }
}
