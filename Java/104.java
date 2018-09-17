/**
Recursive:
Use an array to keep a reference to max depth we found during traversal.
Pass current depth to left/right node and compare max depth when leaf node is reached.

Iterative:
Level-order traversal, the count of levels is the max depth.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // int[] max = new int[]{0};
        // getDepth(root, 0, max);
        // return max[0];
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode last = root;
        
        if(root != null) {
            queue.offerLast(root);
        }
        int count = 0;
        
        while(!queue.isEmpty()) {
            TreeNode n = queue.pollFirst();
            if(n.left!=null) queue.offerLast(n.left);
            if(n.right!=null) queue.offerLast(n.right);
            if(last == n) {
                count++;
                last = queue.peekLast();
            }
        }
        
        return count;
    }
    
    private void getDepth(TreeNode node, int depth, int[] max) {
        if(node == null) {
            max[0] = depth > max[0] ? depth : max[0];
            return;
        }
        getDepth(node.left, depth+1, max);
        getDepth(node.right, depth+1, max);
    }
}
