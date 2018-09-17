/**
Recursive:
To be symmetric, below rules must hold when comparing two nodes l, r:
1) they must be both null or non-null
2) their values must be equal
3) l.left must be symmectric to r.right
4) l.right must be symmectric to r.left

Iterative:
Level-order traversal, and at each level the values must "mirror".

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // return check(root.left, root.right);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode l = queue.poll(); 
            TreeNode r = queue.poll();
            if(l == null && r == null) continue;
            if(l == null || r == null) return false;
            if(l.val != r.val) return false;
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }
    
    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
