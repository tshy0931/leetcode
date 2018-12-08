/**
Iterative:
In-order traversal of BST must be monotonically increasing. otherwise return false.
*Beware that using Integer.MIN_VALUE as default min value can cause wrong answers,
Long.MIN_VALUE works fine but incurs implicit type conversions.

Recursive:
We pass the parent node reference to left/right child nodes as the upperbound/lowerbound to constrain value range.
the left child node should have its parent node as new upperbound, and keep using the same lowerbound passed from ancestors.
the right child node should have its parent node as new lowerbound, and keep using the same upperbound passed from ancestors.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // return iterative(root);
        return recursive(root, null, null);
    }
    
    private boolean recursive(TreeNode node, TreeNode upperbound, TreeNode lowerbound) {
        if(node == null) return true;
        if((upperbound != null && node.val >= upperbound.val) || (lowerbound != null && node.val <= lowerbound.val)) return false;
        return recursive(node.left, node, lowerbound) && recursive(node.right, upperbound, node);
    }
    
    private boolean iterative(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        if(root.val == Integer.MIN_VALUE && root.left != null) return false;
        Stack<TreeNode> stack = new Stack<>();
        long prevVal = Long.MIN_VALUE;
        
        for(TreeNode p = root; p!=null; p = p.left){
            stack.push(p);
        }
            
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(n.val <= prevVal) return false;
            prevVal = n.val;
            for(TreeNode q = n.right; q != null; q = q.left){
                stack.push(q);
            }
        }
        return true;
    }
}
