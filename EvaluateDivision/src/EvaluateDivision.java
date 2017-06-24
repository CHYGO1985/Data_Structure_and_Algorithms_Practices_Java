import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * round 1: unsolved, 
 * 
 * method 1: adjecent list + DFS, 4ms, beat 42%
 * ref: https://discuss.leetcode.com/topic/58445/java-solution-using-hashmap-and-dfs
 * 
 * 
 * method 2: floyd-warshall 
 * ref: https://discuss.leetcode.com/topic/58981/java-solution-using-floyd-warshall-algorithm
 * 
 * @author jingjiejiang
 * @Jun 24, 2017
 */ 
public class EvaluateDivision {

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        // use hashtable to store ajdcent list <str, <str, val>>
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.length];
        
        // edge cases
        if (null == equations || 0 == equations.length || 0 == equations[0].length || 0 == queries.length
            || 0 == queries[0].length) return res;
        
        // init map
        for (int i = 0; i < equations.length; i ++) {
            if (map.containsKey(equations[i][0]) == false) map.put(equations[i][0], new HashMap<String, Double>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);    
            
            if (map.containsKey(equations[i][1]) == false) map.put(equations[i][1], new HashMap<String, Double>());
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        
        // search queries
        for (int i = 0; i < queries.length; i ++) {
            // use array here is to keep the data updated in DFS method (primitive type won't be updated)
            double[] para = new double[]{-1.0};
            Set<String> visited = new HashSet<>();
            // dfs
            dfs(map, queries[i][0], queries[i][1], para, visited, 1.0);
            res[i] = para[0];
        }
        
        return res;
    }
    
    private void dfs(Map<String, Map<String, Double>> map, String num1, String num2, 
                        double[] para, Set<String> visited, double res) {
            
        if(map.containsKey(num1) == false || map.containsKey(num2) == false 
            || visited.contains(num1) == true) return ;     
            
        if (num1.equals(num2)) {
            para[0] = res;
            return ;
        }
        
        visited.add(num1);
        for (Map.Entry<String, Double> entry : map.get(num1).entrySet()) 
            dfs (map, entry.getKey(), num2, para, visited, res * entry.getValue());
        visited.remove(num1);
    }
}
