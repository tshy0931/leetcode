/**
At each node n, the diameter in its subtree is sum of max depth from both left and right nodes plus the edges of n -> n.left and n -> n.right.
Recursively get max depth at each node, update longest path we've seen so far.
For example in below tree, max depth of node 2 and 3 is 1. So their parent node 1 has 
    diameter = 1 + depth_of_node2 + 1 + depth_of_node3 = 4
update the longest path to 4.

          1
         / \
        2   3
       / \   \ 
      4   5   6

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }
    
    private int dfs(TreeNode root, int[] max) {
        int diameter = 0;
        int maxDepth = 0;
        if(root.left != null) {
            maxDepth = dfs(root.left, max) + 1;
            diameter += maxDepth;
        }
        if(root.right != null) {
            int depthR = dfs(root.right, max) + 1;
            diameter += depthR;
            maxDepth = depthR > maxDepth ? depthR : maxDepth;
        }
        if(diameter > max[0]) max[0] = diameter;
        return maxDepth;
    }
}
