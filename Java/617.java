/**
Recursive:
Return null if both t1 and t2 are null;
Return the non-null node if one of t1 and t2 is null;
Otherwise update t1's val to sum of t1.val and t2.val, recursively call mergeTrees to left subtree and right subtree.

Iterative:
Use 2 stacks to iteratively traverse the trees with the same order. pop node from both stacks each turn and merge the sum to node in stack1.
3 possible cases for left/right nodes are:
a) if current node in t1 is null, then just transplant the subtree at this position in t2. No need to push the node to stack.
b) if current node in t1 exists but not in t2, keep the node as is.
c) if current node in t1 and t2 both exist, push them to corresponding stack to merge later.

Return t1.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.offerFirst(t1);
        stack2.offerFirst(t2);
        
        while(!stack1.isEmpty()){
            TreeNode n1 = stack1.pollFirst();
            TreeNode n2 = stack2.pollFirst();
            
            n1.val += n2.val;
            
            if(n1.left == null){ // t1 missing left node here, just transplant t2's subtree here.
                n1.left = n2.left;
            }else if(n2.left != null){ // both nodes exists, add to stack for later process.
                stack1.offerFirst(n1.left);
                stack2.offerFirst(n2.left);
            }
            
            if(n1.right == null){ // t1 missing right node here, just transplant t2's subtree here.
                n1.right = n2.right;
            }else if(n2.right != null){ // both nodes exists, add to stack for later process.
                stack1.offerFirst(n1.right);
                stack2.offerFirst(n2.right);
            }
        }
        
        return t1;
    }
    
    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //     if(t1 == null & t2 == null) return null;
    //     if(t1 == null) return t2;
    //     if(t2 == null) return t1;
    //     t1.val = t1.val + t2.val;
    //     t1.left = mergeTrees(t1.left, t2.left);
    //     t1.right = mergeTrees(t1.right, t2.right);
    //     return t1;
    // }
    
    private class Tuple {
        TreeNode t1;
        TreeNode t2;
        
        public Tuple(TreeNode t1, TreeNode t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
    }
}
