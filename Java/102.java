/**
Use FIFO queue for level-order tree traversal.
Use a pointer to denote last node of each level,
and create a new array in result list when visiting last node at current level.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode last = root;
        queue.offer(root);
        
        List<Integer> currLevel = new ArrayList<>();
        
        while(!queue.isEmpty()){
            TreeNode n = queue.poll();            
            currLevel.add(n.val);

            if(n.left != null){
                queue.offer(n.left);
            }
            if(n.right != null){
                queue.offer(n.right);
            }
                        
            if(last == n){
                if(n.left == null && n.right == null){
                    last = queue.peekLast();
                }else if(n.right != null){
                    last = n.right;
                }else if(n.left != null){
                    last = n.left;
                }

                result.add(currLevel);
                currLevel = new ArrayList<>();
            }            
        }
        
        return result;
    }
}
