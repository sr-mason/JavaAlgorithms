package academy.kovalevskyi.algorithms.week2.day0;

public record IntTreeNode(
    int value,
    int sum,
    int count,
    int maxDepth,
    int minDepth,
    IntTreeNode left,
    IntTreeNode right) {

  @Override
  public String toString() {
    return "Node{" + value + '}';
  }
}

