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

  public static int calcSizeX(int newLevel) {
    int sizeX = 1;
    for (int i = 1; i < Math.sqrt(newLevel); i++) {
      if (newLevel % i == 0)
        sizeX = i;
    }
    return sizeX;
  }
}
