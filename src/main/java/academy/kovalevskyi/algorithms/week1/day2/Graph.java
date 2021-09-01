package academy.kovalevskyi.algorithms.week1.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {
  private final Map<Node, Integer> map;
  int id = 0;

  private Graph() {
    this.map = new HashMap<>();
  }

  public static Graph generateGraph(Set<Node> nodes) {
    Graph graph = new Graph();
    for (Node node : nodes) {
      if (graph.map.containsKey(node)) {
        continue;
      }
      graph.id++;
      graph.depthFirstSearch(node, graph.id);
    }
    return graph;
  }

  private void depthFirstSearch(Node node, int id) {
    for (Node neighbour : node.neighbours) {
      if (map.put(neighbour, id) == null) {
        depthFirstSearch(neighbour, id);
      }
    }
    map.put(node, id);
  }

  public int countComponents() {
    return id;
  }

  public int getComponentId(Node node) {
    return map.get(node);
  }
}


