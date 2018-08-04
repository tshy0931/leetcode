/**
Iterative:
Use stacks to iterate the trees in a left to right order, and use lists to contain leaf nodes (left and right nodes are both null) in left to right order.
Then check if the lists contain the same values in the same order.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        
        List<TreeNode> leaf1 = new ArrayList<>();
        List<TreeNode> leaf2 = new ArrayList<>();

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.offerFirst(root1);
        stack2.offerFirst(root2);
        
        while(!stack1.isEmpty()){
            TreeNode n = stack1.pollFirst();
            if(n.left == null && n.right == null){
                leaf1.add(n);
            } else {
                if(n.right != null) stack1.offerFirst(n.right);
                if(n.left != null) stack1.offerFirst(n.left);   
            }
        }
        
        while(!stack2.isEmpty()){
            TreeNode n = stack2.pollFirst();
            if(n.left == null && n.right == null){
                leaf2.add(n);
            } else {
                if(n.right != null) stack2.offerFirst(n.right);
                if(n.left != null) stack2.offerFirst(n.left);   
            }
        }
        
        if(leaf1.size() != leaf2.size()) return false;
        for(int i=0; i<leaf1.size(); i++){
            if(leaf1.get(i).val != leaf2.get(i).val) return false;
        }
        return true;
    }
}
