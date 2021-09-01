package academy.kovalevskyi.algorithms.week1.day4;

public class VirusApocalypse {

  public static int countDays(Integer[][] startingUniverse) {
    int countDay = 0;
    while (true) {
      for (int i = 0; i < startingUniverse.length; i++) {
        for (int j = 0; j < startingUniverse[i].length; j++) {
          if (startingUniverse[i][j] == 1) {
            infection(startingUniverse, i, j);
          }
        }
      }
      if (!getStateDay(startingUniverse)) {
        if (checkSurvivor(startingUniverse)) {
          return -1;
        }
        break;
      }
      finishInfection(startingUniverse);
      countDay++;
    }
    return countDay;
  }

  private static Integer[][] infection(Integer[][] startingUniverse, int y, int x) {
    // element right
    if (x + 1 < startingUniverse[y].length && startingUniverse[y][x + 1] == 0) {
      startingUniverse[y][x + 1] = -1;
    }
    // element UP
    if (y != 0 && startingUniverse[y - 1][x] == 0) {
      startingUniverse[y - 1][x] = -1;
    }
    // element Down
    if (y + 1 < startingUniverse.length && startingUniverse[y + 1][x] == 0) {
      startingUniverse[y + 1][x] = -1;
    }
    // element left
    if (x != 0 && startingUniverse[y][x - 1] == 0) {
      startingUniverse[y][x - 1] = -1;
    }
    return startingUniverse;
  }

  private static Integer[][] finishInfection(Integer[][] startingUniverse) {
    for (int i = 0; i < startingUniverse.length; i++) {
      for (int j = 0; j < startingUniverse[i].length; j++) {
        if (startingUniverse[i][j] == -1) {
          startingUniverse[i][j] = 1;
        }
      }
    }
    return startingUniverse;
  }

  private static boolean getStateDay(Integer[][] startingUniverse) {
    for (Integer[] integers : startingUniverse) {
      for (Integer integer : integers) {
        if (integer == -1) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean checkSurvivor(Integer[][] startingUniverse) {
    for (Integer[] integers : startingUniverse) {
      for (Integer integer : integers) {
        if (integer == 0) {
          return true;
        }
      }
    }
    return false;
  }
}

