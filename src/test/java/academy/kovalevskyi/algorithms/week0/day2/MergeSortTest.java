package academy.kovalevskyi.algorithms.week0.day2;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void mergeArray() {
    Integer[] a = {1, 2, 3, 4};
    Integer[] b = {5};
    Integer[] expected = {1, 2, 3, 4, 5};
    Assertions.assertArrayEquals(expected, MergeSort.mergeArray(a, b, Integer::compareTo));
  }

  @Test
  void mergeArray2() {
    Integer[] a = {1, 7};
    Integer[] b = {5, 6};
    Integer[] expected = {1, 5, 6, 7};
    Assertions.assertArrayEquals(expected, MergeSort.mergeArray(a, b, Integer::compareTo));
  }

  @Test
  void mergeArray3() {
    Integer[] a = {0};
    Integer[] b = {5, 6};
    Integer[] expected = {0, 5, 6};
    Assertions.assertArrayEquals(expected, MergeSort.mergeArray(a, b, Integer::compareTo));
  }

  @Test
  void mergeArray4() {
    Integer[] a = {0, 1, 2};
    Integer[] b = {1, 2};
    Integer[] expected = {0, 1, 1, 2, 2};
    Assertions.assertArrayEquals(expected, MergeSort.mergeArray(a, b, Integer::compareTo));
  }

  @Test
  void createSortedArray() {
    Integer[] a = {-6, 12, 2, 8};
    Integer[] expected = {-6, 2, 8, 12};
    MergeSort mergeSort = new MergeSort();
    Assertions.assertArrayEquals(expected, mergeSort.sortMerge(a, Integer::compareTo));
  }
}