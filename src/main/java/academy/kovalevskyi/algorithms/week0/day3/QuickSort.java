package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class QuickSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    quickSort(target, 0, target.length - 1, comparator);
  }

  public <T> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
    if (array.length == 0) {
      return;
    }
    if (low >= high) {
      return;
    }
    // выбор опорного элемента
    int middle = low + (high - low) / 2;
    T opora = array[middle];
    int i = low;
    int j = high;
    while (i <= j) {
      while (comparator.compare(array[i], opora) < 0) {
        i++;
      }
      while (comparator.compare(array[j], opora) > 0) {
        j--;
      }
      if (i <= j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
    }
    if (low < j) {
      quickSort(array, low, j, comparator);
    }
    if (high > i) {
      quickSort(array, i, high, comparator);
    }
  }

  @Override
  public String complexityBest() {
    return "N*log(N)";
  }

  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  @Override
  public String complexityWorst() {
    return "N^2";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N"; // дополнительная O(log n)
  }
}
