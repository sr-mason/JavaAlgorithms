package academy.kovalevskyi.algorithms.week2.day0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class IntTreeHelper {

  public static IntTreeNode createNode(int value) {
    return new IntTreeNode(value, value, 1, 1, 1, null, null);
  }

  public static IntTreeNode addNode(IntTreeNode root, int value) {
    if (root == null) {
      return createNode(value);
    }
    IntTreeNode temp = null;
    if (value < root.value()) {
      if (root.left() != null) {
        var nodeLeft = addNode(root.left(), value);
        var nodeRight = clone(root.right());
        int minDepth = Math.min(nodeLeft.minDepth(), (nodeRight != null) ? nodeRight.minDepth() : 10000) + 1;
        int maxDepth = Math.max(nodeLeft.maxDepth(), (nodeRight != null) ? nodeRight.maxDepth() : -1) + 1;
        temp = new IntTreeNode(root.value(), root.sum() + value, root.count() + 1, maxDepth, minDepth, nodeLeft, nodeRight);
      } else {
        var nodeLeft = createNode(value);
        var nodeRight = clone(root.right());
        int minDepth = Math.min(nodeLeft.minDepth(), (nodeRight != null) ? nodeRight.minDepth() : 10000) + 1;
        int maxDepth = Math.max(nodeLeft.maxDepth(), (nodeRight != null) ? nodeRight.maxDepth() : -1) + 1;
        temp = new IntTreeNode(root.value(), root.sum() + value, root.count() + 1, maxDepth, minDepth, nodeLeft, nodeRight);
      }
    } else {
      if (root.right() != null) {
        var nodeLeft = clone(root.left());
        var nodeRight = addNode(root.right(), value);
        int minDepth =
            Math.min((nodeLeft != null) ? nodeLeft.minDepth() : 10000, nodeRight.minDepth()) + 1;
        int maxDepth =
            Math.max((nodeLeft != null) ? nodeLeft.maxDepth() : -1, nodeRight.maxDepth()) + 1;
        temp = new IntTreeNode(root.value(), root.sum() + value, root.count() + 1, maxDepth,
            minDepth, nodeLeft, nodeRight);
      } else {
        var nodeLeft = clone(root.left());
        var nodeRight = createNode(value);
        int minDepth =
            Math.min((nodeLeft != null) ? nodeLeft.minDepth() : 10000, nodeRight.minDepth()) + 1;
        int maxDepth =
            Math.max((nodeLeft != null) ? nodeLeft.maxDepth() : -1, nodeRight.maxDepth()) + 1;
        temp = new IntTreeNode(root.value(), root.sum() + value, root.count() + 1,
            maxDepth, minDepth, nodeLeft, nodeRight);
      }
    }
    return temp;
  }

  public static IntTreeNode clone(IntTreeNode root) {
    if (root == null) {
      return root;
    }
    return new IntTreeNode(root.value(), root.sum(), root.count(), root.maxDepth(), root.minDepth(),
        clone(root.left()), clone(root.right()));
  }

  public static boolean needBalancing(IntTreeNode root) {
    if(root == null) return false;
    return root.maxDepth() > root.minDepth() * 2;
  }

  public static List<Integer> getSortedList(IntTreeNode root) {
    List<Integer> list = new ArrayList<>();
    Queue<IntTreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        if (node.left() != null) {
          queue.add(node.left());
        }
        if (node.right() != null) {
          queue.add(node.right());
        }
        list.add(node.value());
      }
    }
    list.sort(Integer::compare);
    return list;
  }

  public static IntTreeNode generateBalanceTree(IntTreeNode root) {
    int balance = root.maxDepth() - (2 * root.minDepth());
    if (balance >= 1) {
      if (root.right().maxDepth() > root.right().maxDepth()) {
        root = rotateLeft(root);
      } else {
        var right = rotateRight(root.right());
        root = new IntTreeNode(root.value(), root.left().sum() + right.sum(), root.count(), maxDepthTemp(root.left(), right), minDepthTemp(root.left(), right), root.left(), right);
        root = rotateLeft(root);
      }
    } else if (balance < -1) {
      if (root.left().maxDepth() > root.right().maxDepth())
        root = rotateRight(root);
      else {
        var left = rotateLeft(root.left());
        root = new IntTreeNode(root.value(), left.sum() + root.right().sum(), root.count(), maxDepthTemp(left, root.right()), minDepthTemp(left, root.right()), left, root.right());
        root = rotateRight(root);
      }
    }
    return root;
  }

  public static IntTreeNode rotateRight(IntTreeNode root) {
    if (root.right() == null) return root;
    var rootLR = root.left().right();
    var rootR = root.right();
    var rootL = root.left();
    var rootLL = root.left().left();

    int sumTempRightY = (rootLR != null) ? rootLR.sum() + rootR.sum() + root.value() : rootR.sum() + root.value();
    int countTempRightY = (rootLR != null) ? rootLR.count() + rootR.count() + 1 : rootR.count() + 1;
    int minDepthTempRightY = minDepthTemp(rootLR, rootR);
    int maxDepthTempRightY = maxDepthTemp(rootLR, rootR);

    IntTreeNode tempRightY = new IntTreeNode(root.value(), sumTempRightY, countTempRightY, maxDepthTempRightY, minDepthTempRightY, rootLR, root.right());

    int sumTempX = (rootLL != null) ? rootLL.sum() + sumTempRightY + rootL.value() : sumTempRightY + rootL.value();
    int countTempX = (rootLL != null) ? countTempRightY + rootLL.count() + 1 : countTempRightY + 1;
    int minDepthTempX = (rootLL != null) ? Math.min(minDepthTempRightY, rootLL.minDepth()) + 1: minDepthTempRightY + 1;
    int maxDepthTempX = (rootLL != null) ? Math.max(maxDepthTempRightY, rootLL.maxDepth()) + 1 : maxDepthTempRightY + 1;

    return new IntTreeNode(rootL.value(), sumTempX, countTempX, maxDepthTempX, minDepthTempX, rootLL, tempRightY);
  }

  public static IntTreeNode rotateLeft(IntTreeNode root) {
    if (root.left() == null) return  root;
    var rootRL = root.right().left();
    var rootR = root.right();
    var rootL = root.left();
    var rootRR = root.right().right();

    int sumTempRightY = (rootRL != null) ? rootL.sum() + rootRL.sum() + root.value() : rootL.sum() + root.value();
    int countTempRightY = (rootRL != null) ? rootL.count() + rootRL.count() + 1 : rootL.count() + 1;
    int minDepthTempRightY = minDepthTemp(rootL, rootRL);
    int maxDepthTempRightY = maxDepthTemp(rootL, rootRL);

    IntTreeNode tempRightY = new IntTreeNode(root.value(), sumTempRightY, countTempRightY, maxDepthTempRightY, minDepthTempRightY, rootL, rootRL);

    int sumTempX = (rootRR != null) ? rootRR.sum() + sumTempRightY + rootR.value() : sumTempRightY + rootR.value();
    int countTempX = (rootRR != null)? countTempRightY + rootRR.count() + 1 : countTempRightY  + 1;
    int minDepthTempX = (rootRR != null) ? Math.max(minDepthTempRightY, rootRR.minDepth()) + 1 : minDepthTempRightY + 1;
    int maxDepthTempX = (rootRR != null) ? Math.max(maxDepthTempRightY, rootRR.maxDepth()) + 1: maxDepthTempRightY + 1;

    return new IntTreeNode(rootR.value(), sumTempX, countTempX, maxDepthTempX, minDepthTempX, tempRightY, rootRR);
  }

  private static int minDepthTemp(IntTreeNode a, IntTreeNode b) {
    if (a == null && b == null) {
      return 1;
    }
    if (a == null) {
      return b.minDepth() + 1;
    }
    if (b == null) {
      return a.minDepth() + 1;
    }
    return Math.min(a.minDepth(), b.minDepth()) + 1;
  }

  private static int maxDepthTemp(IntTreeNode a, IntTreeNode b) {
    if (a == null && b == null) {
      return 1;
    }
    if (a == null) {
      return b.maxDepth() + 1;
    }
    if (b == null) {
      return a.maxDepth() + 1;
    }
    return Math.max(a.maxDepth(), b.maxDepth()) + 1;
  }

  public static boolean hasValue(IntTreeNode root, int value) {
    if (root == null) {
      return false;
    }
    if (root.value() > value) {
      return hasValue(root.left(), value);
    }
    if (root.value() < value) {
      return hasValue(root.right(), value);
    }
    return true;
  }

  public static void printTree(IntTreeNode rootNode) {
    var list = new ArrayList<IntTreeNode>();
    var globalStack = new Stack<IntTreeNode>(); // общий стек для значений дерева
    globalStack.push(rootNode);
    int gaps = 32; // начальное значение расстояния между элементами
    boolean isRowEmpty = false;
    String separator = "-----------------------------------------------------------------";
    System.out.println(separator);
    while (!isRowEmpty) {
      var localStack = new Stack<IntTreeNode>();
      isRowEmpty = true;
      System.out.print(" ".repeat(gaps));
      while (!globalStack.isEmpty()) {
        var node = globalStack.pop();
        if (node != null) {
          System.out.print(node.value());
          list.add(node);
          localStack.push(node.left());
          localStack.push(node.right());
          if (node.left() != null || node.right() != null) {
            isRowEmpty = false;
          }
        } else {
          System.out.print("__");
          localStack.push(null);
          localStack.push(null);
        }
        System.out.print(" ".repeat(gaps * 2 - 2));
      }
      System.out.println();
      gaps /= 2;
      while (!localStack.isEmpty()) {
        globalStack.push(localStack.pop());
      }
    }
    System.out.println(separator);
    list.forEach(node -> {
      System.out.println(
          "Node" + node.value() + " left=" + node.left() + " right=" + node.right() + " sum="
              + node.sum() + " count=" + node.count() + " maxDepth=" + node.maxDepth()
              + " minDepth=" + node.minDepth());
    });
  }
}


