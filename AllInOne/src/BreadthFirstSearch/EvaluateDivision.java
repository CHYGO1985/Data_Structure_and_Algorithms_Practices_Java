package src.BreadthFirstSearch;

import java.util.List;
import java.util.HashMap;
import java.util.*;

/**
 * 
 * 399. Evaluate Division
 * 
 * @author 
 * 
 */
public class EvaluateDivision {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
    assert equations != null && values != null && queries != null;

    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    for (int idx = 0; idx < equations.size(); idx ++) {
      
      List<String> equation = equations.get(idx);
      String dividend = equation.get(0);
      String divisor = equation.get(1);
      double quotient = values[idx];

      if (!graph.containsKey(dividend)) {
        graph.put(dividend, new HashMap<>());
      }

      if (!graph.containsKey(divisor)) {
        graph.put(dividend, new HashMap<>());
      }

      graph.get(dividend).put(divisor, quotient);
      graph.get(divisor).put(dividend, 1 / quotient);
    }

    double[] results = new double[queries.size()];
    for(int idx = 0 ; idx < queries.size(); idx ++) {

      List<String> query = queries.get(idx);
      String dividend = query.get(0);
      String divisor = query.get(1);

      if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
        results[idx] = -1.0;
      } else if (dividend == divisor) {
        results[idx] = 1.0;
      } else {
        Set<String> visited = new HashSet<>();
        results[idx] = backTrackEvaluate(graph, dividend, divisor, 1, visited);
      }
    }

    return results;
  }

  private double backTrackEvaluate(HashMap<String, HashMap<String, Double>> graph,
    String currNode, String targetNode, double accProduct, Set<String> visited) {

      visited.add(currNode);
      double res = -1.0;

      Map<String, Double> neighbours = graph.get(currNode);
      if (neighbours.containsKey(targetNode)) {
        res = accProduct * neighbours.get(targetNode);
      } else {
        for (Map.Entry<String, Double> pair : neighbours.entrySet()) {
          String nextNode = pair.getKey();
          if (!visited.contains(nextNode)) continue;

          res = backTrackEvaluate(graph, nextNode, targetNode, accProduct*pair.getValue(), visited);

          if (res != -1.0) break;
        }
      }

      visited.remove(currNode);
      return res;
    }
}
