package academy.kovalevskyi.algorithms.week1.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class NetworkPathFinder {

  public static int[] visited;
  public static int[] dist;
  public static int[][] matrix;


  public static int shortestPath(Node start, Node end) {
    Set<Node> setNode = countNodes(start);
    createMatrixSM(setNode);
    visited = new int[setNode.size()];
    dist = new int[setNode.size()];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    dijkstra(0);
    return dist[end.id];
  }

  // create list graph vertices
  public static Set<Node> countNodes(Node root) {
    Queue<Node> queue = new LinkedList<>();
    Set<Node> set = new HashSet<>();
    queue.add(root);
    int countNode = 0;
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (!set.contains(node)) {
        set.add(node);
        node.id = countNode++;
        queue.addAll(node.connections.keySet());
      }
    }
    return set;
  }

  // create adjacency matrix
  public static int[][] createMatrixSM(Set<Node> set) {
    matrix = new int[set.size()][set.size()];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = -1;
      }
    }
    for (Node node : set) {
      for (Entry<Node, Integer> entry : node.connections.entrySet()) {
        matrix[node.id][entry.getKey().id] = entry.getValue();
      }
    }
    return matrix;
  }

  public static int minDist() {
    int minDistance = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 0; i < dist.length; i++) {
      if (minDistance > dist[i] && visited[i] == 0) {
        minDistance = dist[i];
        index = i;
      }
    }
    return index;
  }

  public static void dijkstra(int start) {
    for (int i = 0; i < dist.length; i++) {
      if (matrix[start][i] > -1 && dist[i] > (matrix[start][i] + dist[start])) {
        dist[i] = matrix[start][i] + dist[start];
      }
    }
    int j = minDist();
    if (j == -1) {
      return;
    }
    visited[j] = 1;
    dijkstra(j);
  }
}
