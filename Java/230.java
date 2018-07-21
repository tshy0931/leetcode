/**
In-order traversal until the kth node is being visited, return the val at that node.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(p != null){
            stack.push(p);
            p = p.left;
        }
        
        while(!stack.isEmpty()) {
            p = stack.pop();
            if(++count == k) return p.val;
            p = p.right;
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return root.val;
    }    
}
