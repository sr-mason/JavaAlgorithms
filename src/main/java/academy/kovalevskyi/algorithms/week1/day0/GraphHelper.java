package academy.kovalevskyi.algorithms.week1.day0;


public class GraphHelper {

  public static boolean equals(GraphBinaryNode<?> left, GraphBinaryNode<?> right) {
    if (left == right) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    return left.value().equals(right.value())
        && equals(left.left(), right.left())
        && equals(left.right(), right.right());
  }

  public static <T> GraphBinaryNode<T> invertGraph(GraphBinaryNode<T> root) {
    if (root == null) {
      return null;
    }
    return new GraphBinaryNode<>(invertGraph(root.right()), invertGraph(root.left()), root.value());
  }
}
