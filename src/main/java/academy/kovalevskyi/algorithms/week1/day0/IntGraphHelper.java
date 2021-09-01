package academy.kovalevskyi.algorithms.week1.day0;

import java.util.Stack;

public class IntGraphHelper {

  public static GraphBinaryNode<Integer> createNode(Integer value) {
    return new GraphBinaryNode<>(null, null, value);
  }

  public static GraphBinaryNode<Integer> addNode(GraphBinaryNode<Integer> root, Integer value) {
    if (root == null) {
      return createNode(value);
    }
    GraphBinaryNode<Integer> temp = null;
    if (value.compareTo(root.value()) < 0) {
      if (root.left() != null) {
        temp = new GraphBinaryNode<>(addNode(root.left(), value), clone(root.right()), root.value());
      } else {
        temp = new GraphBinaryNode<>(createNode(value), clone(root.right()), root.value());
      }
    } else {
      if (root.right() != null) {
        temp = new GraphBinaryNode<>(clone(root.left()), addNode(root.right(), value),
            root.value());
      } else {
        temp = new GraphBinaryNode<>(clone(root.left()), createNode(value), root.value());
      }
    }
    return temp;
  }

  public static GraphBinaryNode<Integer> clone(GraphBinaryNode<Integer> root) {
    if (root == null) {
      return root;
    }
    return new GraphBinaryNode<>(clone(root.left()), clone(root.right()), root.value());
  }

  public static boolean contains(GraphBinaryNode<Integer> root, Integer value) {
    if (root == null) {
      return false;
    }
    if (value.compareTo(root.value()) > 0) {
      return contains(root.right(), value);
    } else if (value.compareTo(root.value()) < 0) {
      return contains(root.left(), value);
    }
    return true;
  }

  public static void printTree(GraphBinaryNode<Integer> rootNode) {
    Stack<GraphBinaryNode<Integer>> globalStack = new Stack<>(); // общий стек для значений дерева
    globalStack.push(rootNode);
    int gaps = 32; // начальное значение расстояния между элементами
    boolean isRowEmpty = false;
    String separator = "-----------------------------------------------------------------";
    System.out.println(separator);
    // черта для указания начала нового дерева
    while (!isRowEmpty) {
      // локальный стек для задания потомков элемента
      Stack<GraphBinaryNode<Integer>> localStack = new Stack<>();
      isRowEmpty = true;

      for (int j = 0; j < gaps; j++) {
        System.out.print(' ');
      }
      while (!globalStack.isEmpty()) {
        // берем следующий, при этом удаляя его из стека
        GraphBinaryNode<Integer> temp = (GraphBinaryNode<Integer>) globalStack.pop();
        if (temp != null) {
          // выводим его значение в консоли
          System.out.print(temp.value());
          //соохраняем в локальный стек, наследники текущего элемента
          localStack.push(temp.left());
          localStack.push(temp.right());
          if (temp.left() != null || temp.right() != null) {
            isRowEmpty = false;
          }
        } else {
          // - если элемент пустой
          System.out.print("__");
          localStack.push(null);
          localStack.push(null);
        }
        for (int j = 0; j < gaps * 2 - 2; j++) {
          System.out.print(' ');
        }
      }
      System.out.println();
      // при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
      gaps /= 2;
      while (!localStack.isEmpty()) {
        // перемещаем все элементы из локального стека в глобальный
        globalStack.push(localStack.pop());
      }
    }
    System.out.println(separator);

  }

  public static void main(String[] args) {
    var leftRight5 = new GraphBinaryNode<Integer>(null, null, 5);
    var leftLeftM2 = new GraphBinaryNode<Integer>(null, null, -2);
    var left2 = new GraphBinaryNode<Integer>(leftLeftM2, leftRight5, 2);
    var right12 = new GraphBinaryNode<Integer>(null, null, 12);
    var root = new GraphBinaryNode<Integer>(left2, right12, 10);
    printTree(root);
    printTree(addNode(root, -7));
  }
}
