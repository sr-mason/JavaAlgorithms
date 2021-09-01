package academy.kovalevskyi.algorithms.week2.day2;

import academy.kovalevskyi.algorithms.week2.day0.IntTreeHelper;
import academy.kovalevskyi.algorithms.week2.day0.IntTreeNode;

public class IntSet {
  private IntTreeNode[] array;
  int size = 0;
  int sum = 0;

  public IntSet(int bucketsSize) {
    this.array = new IntTreeNode[bucketsSize];
  }

  public IntSet() {
    this.array = new IntTreeNode[3];
  }

  public int getBucketsCount() {
    return this.array.length;
  }

  public int getBucketId(int value) {
    return value % this.array.length;
  }

  public boolean contains(int value) {
    int index = Math.abs(getBucketId(value));
    return IntTreeHelper.hasValue(this.array[index], value);
  }

  public void add(int value) {
    int index = Math.abs(getBucketId(value));
    this.array[index] = IntTreeHelper.addNode(this.array[index],value);
    this.size++;
    this.sum += value;
  }

  public int count() {
    return this.size;
  }

  public int sum() {
    return this.sum;
  }
}

