package academy.kovalevskyi.algorithms.week0.day1;

public class Tasks {

  public static class Node {

    public Node next;
    public int value;
  }

  public static int findMiddleInOneGo(Node start) {
    if (start == null) {
      return 0;
    }
    Node first = start;
    Node second = start;
    while (second != null && second.next != null) {
      first = first.next;
      second = second.next.next;
    }
    return first.value;
  }

  public static boolean hasCycle(Node start) {
    if (start == null) {
      return false;
    }
    Node first = start;
    Node second = start;
    while (first.next != null && second.next != null && second.next.next != null) {
      first = first.next;
      second = second.next.next;
      if (first == second) {
        return true;
      }
    }
    return false;
  }
}
