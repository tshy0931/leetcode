/**
Iterative:
Starting from root, push the left node into stack until we've pushed the left-most node into stack.
Then while the stack is not empty (which means there are still nodes not processed),
pop a node from the top of stack, process its value.
if the node has right node, starting from the right node, push all left node into stack.
This is to make sure we always process left subtree first, then the root node, then the right subtree.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        for(TreeNode p = root; p != null; p = p.left) {
            stack.offerLast(p);
        }
        
        while(!stack.isEmpty()) {
            TreeNode n = stack.pollLast();
            result.add(n.val);
            for(TreeNode q = n.right; q != null; q = q.left){
                stack.offerLast(q);
            }
        }
        return result;
    }
}
