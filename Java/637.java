/**
Level-order tree traversal using a FIFO queue. Beware of the integer value range, sum needs to be a long number.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();
        if(root == null) return res;

        TreeNode last = root;
        queue.offerLast(root);
        long sum = 0; 
        double count = 0.0;
        
        while(!queue.isEmpty()){
            TreeNode n = queue.pollFirst();
            sum += n.val;
            count += 1.0;
            if(n.left != null) queue.offerLast(n.left);
            if(n.right != null) queue.offerLast(n.right);
            if(n == last){
                res.add(sum/count);
                sum = 0;
                count = 0.0;
                last = queue.peekLast();
            }
        }
        
        return res;
    }
}
