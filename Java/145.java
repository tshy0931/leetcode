/**
Key point is each node needs to be pushed and popped to stack twice, 
first time to find and process its right node, 
second time to process itself.
Use a HashSet to identify whether a node is popped for first or second time.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> popped = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        for(TreeNode p = root; p != null; p = p.left) {
            stack.offerLast(p);
        }
        
        while(!stack.isEmpty()) {
            TreeNode n = stack.pollLast();
            if(popped.contains(n)) {
                result.add(n.val);
            } else {
                popped.add(n);
                stack.offerLast(n);
                for(TreeNode q = n.right; q != null; q = q.left){
                    stack.offerLast(q);
                }
            }
        }
        return result;
    }
}
