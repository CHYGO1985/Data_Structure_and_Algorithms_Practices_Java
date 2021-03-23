import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * 
 * 428. Serialize and Deserialize N-ary Tree
 * 
 * @author jingjiejiang
 * @history Mar 23, 2021
 * 
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {

        List<String> strList = new LinkedList<>();
        serializeHelper(root, strList);

        return String.join("#", strList);
    }

    private void serializeHelper(Node root, List<String> strList) {

        if (root == null) {
            return ;
        } else {
            strList.add(String.valueOf(root.val));
            strList.add(String.valueOf(root.children.size()));
            for (Node node : root.children) {
                serializeHelper(node, strList);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {

        if (data.isEmpty()) return null;

        String[] strs = data.split("#");
        Queue<String> queue = new LinkedList(Arrays.asList(strs));

        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {

        Node root = new Node();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<Node>(size);

        for (int idx = 0; idx < size; idx ++) {
            root.children.add(deserializeHelper(queue));
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));