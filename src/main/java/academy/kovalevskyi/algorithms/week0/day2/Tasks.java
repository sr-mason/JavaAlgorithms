package academy.kovalevskyi.algorithms.week0.day2;

import java.util.OptionalInt;

public class Tasks {

  public static OptionalInt findIndex(int[] sortedArray, int target) {
    OptionalInt findNum = null;
    int start = 0;
    int end = sortedArray.length - 1;
    int mid;
    while (start <= end) {
      mid = (start + end) / 2;
      if (target == sortedArray[mid]) {
        return findNum.of(mid);
      }
      if (target > sortedArray[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return findNum;
  }
}
