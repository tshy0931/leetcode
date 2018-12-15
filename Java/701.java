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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode p = root;
        while(true){
            if(val < p.val){
                if(p.left == null) {
                    p.left = new TreeNode(val);
                    return root;
                }
                p = p.left;
            } else {
                if(p.right == null) {
                    p.right = new TreeNode(val);
                    return root;
                }
                p = p.right;
            }
        }
    }
}
