/**
 * 
 * 133. Clone Graph
 * 
 * @author jingjiejiang
 * @history Oct 20, 2020 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
      
      if (node == null) return null;
      
      return dfs(node, new HashMap<>());
  }
  
  // dfs
  private Node dfs(Node node, Map<Integer, Node> visitedMap) {
      
      if (visitedMap.containsKey(node.val)) {
          
          return visitedMap.get(node.val);
      }
      
      Node newNode = new Node(node.val, new ArrayList<>());
      
      visitedMap.put(node.val, newNode);
      
      for (Node curNode : node.neighbors) {
      
          newNode.neighbors.add(dfs(curNode, visitedMap));
      }
      
      return newNode;
  }
}