package academy.kovalevskyi.algorithms.week1.day4;
import java.util.HashMap;
import java.util.Map;

public class Node {
  public Map<Node, Integer> connections = new HashMap<>();
  public Integer distance = Integer.MAX_VALUE;
  public int id;
}

