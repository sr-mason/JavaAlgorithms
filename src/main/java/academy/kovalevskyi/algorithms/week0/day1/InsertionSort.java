package academy.kovalevskyi.algorithms.week0.day1;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class InsertionSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    for (int i = 1; i < target.length; i++) {
      T current = target[i];
      int j = i;
      while (j > 0 && comparator.compare(target[j - 1], current) > 0) {
        target[j] = target[j - 1];
        j--;
      }
      target[j] = current;
    }
  }

  @Override
  public String complexityBest() {
    return "N";
  }

  @Override
  public String complexityAverage() {
    return "N^2";
  }

  @Override
  public String complexityWorst() {
    return "N^2";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N";
  }
}
