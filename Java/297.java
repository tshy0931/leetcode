/**
Serialize: 
Level-order traversal. use dummy node when we want to enqueue null node.

Deserialize: 
Iterate through values in the serialized string and create corresponding nodes at the same index.
Then use 2 indexes to point to the current node as parent (to assign left/right nodes) and the current node as child (to be assigned as left/right).
parent must be non-null. When parent points to null, we go to the next non-null node as current parent.
child could be either node or null, just assign and increment child node as left and right of current parent in order.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        TreeNode dummyNull = new TreeNode(0);
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            TreeNode n = queue.pollFirst();
            builder.append(n == dummyNull ? "null" : n.val);
            builder.append(",");
            if(n != dummyNull){
                queue.offerLast(n.left == null ? dummyNull : n.left);
                queue.offerLast(n.right == null ? dummyNull : n.right);
            }
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] values = data.split(",");
        TreeNode[] nodes = new TreeNode[values.length];
        
        for(int i=0; i<values.length; i++) {
            nodes[i] = values[i].equals("null") ? null : new TreeNode(Integer.parseInt(values[i]));
        }
        // for each node, parent, assign both left and right node to next two nodes, either null or non-null
        // if parent is null, set parent to the next non-null node.
        for(int parent=0, child=1; child<nodes.length && parent<nodes.length;){
            if(nodes[parent]!=null){
                nodes[parent].left = nodes[child++];
                if(child<nodes.length) nodes[parent].right = nodes[child++];
                else break;
            }
            parent++;
        }
        
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
