/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return recursive(root, val);
    }
    
    private TreeNode iterative(TreeNode root, int val) {
        if(root == null) return null;
        TreeNode p = root;
        while(p!=null){
            if(p.val == val) return p;
            if(val < p.val) p = p.left;
            else p = p.right;
        }
        return null;
    }
    
    private TreeNode recursive(TreeNode root, int val) {
        if(root == null) return null;
        if(val == root.val) return root;
        if(val < root.val) return recursive(root.left, val);
        else return recursive(root.right, val);
    }
}
