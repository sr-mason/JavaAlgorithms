package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphHelper2 {

  public static boolean includesDepthFirstSearchRecursive(GraphBinaryNode<?> root, Object value) {
    if (root == null) {
      return false;
    }
    return value.equals(root.value())
        || includesDepthFirstSearch(root.right(), value)
        || includesDepthFirstSearch(root.left(), value);
  }

  public static boolean includesDepthFirstSearch(GraphBinaryNode<?> root, Object value) {
    Stack<GraphBinaryNode<?>> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      var tree = stack.pop();
      if (value.equals(tree.value())) {
        return true;
      }
      if (tree.right() != null) {
        stack.push(tree.right());
      }
      if (tree.left() != null) {
        stack.push(tree.left());
      }
    }
    return false;
  }

  public static boolean includesBreathFirstSearch(GraphBinaryNode<?> root, Object value) {
    Queue<GraphBinaryNode<?>> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (value.equals(node.value())) {
        return true;
      }
      if (node.left() != null) {
        queue.offer(node.left());
      }
      if (node.right() != null) {
        queue.offer(node.right());
      }
    }
    return false;
  }
}