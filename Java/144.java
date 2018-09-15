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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        stack.offerLast(root);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pollLast();
            result.add(n.val);
            if(n.right!=null){
                stack.offerLast(n.right);
            }
            if(n.left!=null){
                stack.offerLast(n.left);
            }
        }
        return result;
    }
}
