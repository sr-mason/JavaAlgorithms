package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class HeapSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    heapSort(target, comparator);
  }

  public static <T> void heapSort(T[] a, Comparator<T> comparator) {
    int count = a.length;
    heapify(a, count, comparator);
    int end = count - 1;
    while (end > 0) {
      T tmp = a[end];
      a[end] = a[0];
      a[0] = tmp;
      siftDown(a, 0, end - 1, comparator);
      end--;
    }
  }

  public static <T> void heapify(T[] a, int count, Comparator<T> comparator) {
    int start = (count - 2) / 2;
    while (start >= 0) {
      siftDown(a, start, count - 1, comparator);
      start--;
    }
  }

  public static <T> void siftDown(T[] a, int start, int end, Comparator<T> comparator) {
    int root = start;
    while ((root * 2 + 1) <= end) {
      int child = root * 2 + 1;
      if (child + 1 <= end && comparator.compare(a[child], a[child + 1]) < 0) {
        child = child + 1;
      }
      if (comparator.compare(a[root], a[child]) < 0) {
        T tmp = a[root];
        a[root] = a[child];
        a[child] = tmp;
        root = child;
      } else {
        return;
      }
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
    return "N*log(N)";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N"; // дополнительная O(1)
  }
}

