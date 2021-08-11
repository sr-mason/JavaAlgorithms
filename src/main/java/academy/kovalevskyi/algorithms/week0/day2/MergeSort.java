package academy.kovalevskyi.algorithms.week0.day2;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    T[] temp = sortMerge(target, comparator);
    System.arraycopy(temp, 0, target, 0 , target.length);
  }

  protected   <T> T[] sortMerge(T[] target, Comparator<T> comparator) {
    if (target == null) {
      return null;
    }
    if (target.length < 2) {
      return target;
    }

    T[] arrayLeft = (T[]) new Object[target.length / 2];
    System.arraycopy(target, 0, arrayLeft, 0, target.length / 2);

    T[] arrayRigth = (T[]) new Object[target.length - target.length / 2];
    System.arraycopy(target, target.length / 2, arrayRigth, 0, target.length - target.length / 2);

    arrayLeft = sortMerge(arrayLeft, comparator);
    arrayRigth = sortMerge(arrayRigth, comparator);

    return mergeArray(arrayLeft, arrayRigth, comparator);
  }

  protected static <T> T[] mergeArray(T[] arrayA, T[] arrayB, Comparator<T> comparator) {
    T[] target = (T[]) new Object[arrayA.length + arrayB.length];
    int indexA = 0;
    int indexB = 0;
    for (int i = 0; i < target.length; i++) {
      if (indexA == arrayA.length && indexB < arrayB.length) {
        target[i] = arrayB[indexB++];
      }
      if (indexA < arrayA.length && indexB == arrayB.length) {
        target[i] = arrayA[indexA++];
      }
      if (indexA < arrayA.length && indexB < arrayB.length) {
        if (comparator.compare(arrayA[indexA], arrayB[indexB]) <= 0) {
          target[i] = arrayA[indexA++];
        } else {
          target[i] = arrayB[indexB++];
        }
      }
    }
    return target;
  }

  @Override
  public <T> T[] createSortedArray(final T[] target, final Comparator<T> comparator) {
    T[] temp = Arrays.copyOf(target, target.length);
    sort(temp, comparator);
    return temp;
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
    return "N";
  }
}
