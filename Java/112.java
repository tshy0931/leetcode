/**
Recursive:
top-down recursively traverse the tree and pass the sum at the node down to children nodes.
only leaf node should be counted, which has both left and right nodes as null.

Iterative:
use a stack to post-order traverse the tree and track the sum along the way.
When visiting a leaf node (which has neither left nor right node) and current sum equals the target sum, return true.
Otherwise, if the node has unvisited right subtree, don't pop the node, and go to visit the right subtree. 
To identify right subtree visited or not, use a pointer, prev, to track the node processed previously.
If prev points to right node of current node, that means we've already visited right subtree, 
then just pop current node and subtract its value from currSum.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        // return findSum(root, 0, sum);
        Deque<TreeNode> stack = new ArrayDeque<>();
        int currSum = 0;
        
        TreeNode curr = null, prev = null;
        
        for(curr=root; curr!=null; curr=curr.left) {
            currSum += curr.val;
            stack.offerLast(curr);
        }
        
        while(!stack.isEmpty()) {
            curr = stack.peekLast();
            if(curr.left == null && curr.right == null && currSum == sum) return true;
            if(curr.right != null && prev != curr.right) { // right subtree hasn't been visited
                for(curr=curr.right; curr!=null; curr=curr.left) {
                    currSum += curr.val;
                    stack.offerLast(curr);
                }
            } else { // right subtree has been visited
                currSum -= curr.val;
                prev = stack.pollLast();
            }
        }
        
        return false;
    }
    
    private boolean findSum(TreeNode node, int currSum, int target) {
        if(node == null) return false;
        currSum += node.val;
        if(node.left == null && node.right == null) return currSum == target;
        return findSum(node.left, currSum, target) || findSum(node.right, currSum, target);
    }
    
    private class Tuple {
        public TreeNode node;
        public int sum;
        
        public Tuple(TreeNode n, int s) {
            this.node = n;
            this.sum = s;
        }
    }
}
